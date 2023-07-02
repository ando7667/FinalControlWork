package Models;

import java.util.stream.Stream;

public class AnimalsType {

    // виды животных
    public enum AnimalSpecies {
        dogs(1),
        cats(2),
        hamsters(3),
        horses(1),
        camels(2),
        donkeys(3);
        private int genus;

        AnimalSpecies(int genus) {
            this.genus = genus;
        }

        public static Stream<AnimalSpecies> stream() {
            return Stream.of(AnimalSpecies.values());
        }

    }


    /**
     * Метод возвращает в строке все виды животных через запятую из перечисления AnimalSpecies
     */
    public static String getStringEnumAnimalType() {
        String str = "";
        for (AnimalSpecies at : AnimalSpecies.values()) {
            str = str.concat(getAnimalsType(at) + ",");
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /**
     * Метод возвращает строковое представление выбранного значения из перечисления AnimalSpecies
     *
     * @param animalSpecies интересующее значение из перечисления AnimalSpecies
     */
    public static String getAnimalsType(AnimalSpecies animalSpecies) {
        return switch (animalSpecies) {
            case dogs -> "Собака";
            case cats -> "Кошка";
            case hamsters -> "Хомяк";
            case horses -> "Лошадь";
            case camels -> "Верблюд";
            case donkeys -> "Осёл";
        };
    }

    /**
     * Метод возвращает вид питомца из перечисления AnimalSpecies, соответсующий целому чилу
     *
     * @param value целое число, которому ищется соответствие в перечислении AnimalSpecies
     */
    public static AnimalSpecies getAnimalType(int value) {
        for (AnimalSpecies at : AnimalSpecies.values()) {
            if (at.ordinal() == value)
                return at;
        }
        throw new IllegalArgumentException("нету такого элемента в перечислении" + value);
    }

    /**
     * Метод возвращает число соответствия вида питомца с таблицами home_animals и pack_animals базы данных
     * из перечисления AnimalSpecies, соответсующий целому чилу ( хранится в поле genus перечисления AnimalSpecies)
     *
     * @param value целое число, которому ищется соответствие в перечислении AnimalSpecies
     */
    public static int getGenusAnimalSpecies(int value) {
        return getAnimalType(value).genus;
    }

}