package Models.Animals.HomeAnimalsMem;

import Models.Animals.HomeAnimals;
import Models.AnimalsType;

import java.util.ArrayList;
import java.util.Arrays;

public class Hamster extends HomeAnimals {

    public Hamster() {
        this.type = AnimalsType.AnimalSpecies.hamsters;
    }

    public Hamster(int id, String name, String date, String commands) {
        this.idPet = id;
        this.name = name;
        this.birthday = date;
        this.commands = new ArrayList<String>(Arrays.asList(commands.split(",")));
        this.type = AnimalsType.AnimalSpecies.hamsters;
    }

}
