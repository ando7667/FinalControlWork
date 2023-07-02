package Models.Animals;

import Models.AnimalsType;

public class HomeAnimals extends Animals {

    static final animalGroups animals = animalGroups.home;

    public animalGroups getAnimalGroups() {
        return animals;
    }

    public int getIntAnimalGroups() {
        return animals.ordinal();
    }

    public String getStringAnimalGroups() {
        return "Домашние";
    }
}
