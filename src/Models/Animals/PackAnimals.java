package Models.Animals;

import Models.AnimalsType;

public class PackAnimals extends Animals {

    static final Animals.animalGroups animals = Animals.animalGroups.pack;

    public animalGroups getAnimalGroups() {
        return animals;
    }

    public int getIntAnimalGroups() {
        return animals.ordinal();
    }

    public String getStringAnimalGroups() {
        return "Вьючные";
    }
}
