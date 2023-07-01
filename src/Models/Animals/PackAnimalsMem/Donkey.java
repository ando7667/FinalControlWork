package Models.Animals.PackAnimalsMem;

import Models.Animals.PackAnimals;
import Models.AnimalsType;

import java.util.ArrayList;
import java.util.Arrays;

public class Donkey extends PackAnimals {

    public Donkey() {
        this.type = AnimalsType.animalType.donkeys;
    }

    public Donkey(int id, String name, String date,String commands){
        this.idPet = id;
        this.name = name;
        this.birthday = date;
        this.commands = new ArrayList<String>(Arrays.asList(commands.split(",")));;
        this.type = AnimalsType.animalType.donkeys;
    }

}
