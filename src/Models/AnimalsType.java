package Models;

import java.util.stream.Stream;

public class AnimalsType {

    // виды животных
    public enum animalType {
        dogs,
        cats,
        hamsters,
        horses,
        camels,
        donkeys
    }

    public static Stream<animalType> stream() {
        return Stream.of(animalType.values());
    }

    public static String getStringEnumAnimalType() {
        String str = "";
        for (animalType at : animalType.values()) {
            str = str.concat(getAnimalsType(at) + ",");
        }
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static String getAnimalsType(animalType typeAnimals) {
        return switch (typeAnimals) {
            case dogs -> "Собака";
            case cats -> "Кошка";
            case hamsters -> "Хомяк";
            case horses -> "Лошадь";
            case camels -> "Верблюд";
            case donkeys -> "Осёл";
        };
    }

    public static String getByValueAnimalsType(int value) {
        for (animalType at : animalType.values()) {
            if (at.ordinal() == value)
                return at.toString();
        }
        throw new IllegalArgumentException("нету такого элемента в перечислении" + value);
    }

}