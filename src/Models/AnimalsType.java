package Models;

public class AnimalsType {

    // виды животных
    public enum animalType {
        dog,
        cat,
        hamster,
        horse,
        camel,
        donkey;
    }

    public static String getAnimalsType(animalType typeAnimals) {
        return switch (typeAnimals) {
            case dog -> "Собака";
            case cat -> "Кошка";
            case hamster -> "Хомяк";
            case horse -> "Лошадь";
            case camel -> "Верблюд";
            case donkey -> "Осёл";
        };
    }
}