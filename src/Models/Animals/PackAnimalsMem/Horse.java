package Models.Animals.PackAnimalsMem;

import Models.Animals.PackAnimals;
import Models.AnimalsType;

import java.util.ArrayList;
import java.util.Arrays;

public class Horse extends PackAnimals {

    public Horse() {
        this.type = AnimalsType.animalType.horses;
    }

    public Horse(int id, String name, String date,String commands){
        this.idPet = id;
        this.name = name;
        this.birthday = date;
        this.commands = new ArrayList<String>(Arrays.asList(commands.split(",")));;
        this.type = AnimalsType.animalType.horses;
    }

}
