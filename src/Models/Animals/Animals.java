package Models.Animals;

import Models.AnimalsType.animalType;
import java.util.List;
import static Models.AnimalsType.getAnimalsType;

abstract public class Animals {

    //группы животных
    public enum animalGroups {
        home,
        pack;
    }

    public int idPet;

    public String name;
    public String birthday;
    public List<String> commands;

    public animalType type;

    public int getIdPet() {
        return this.idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getStringBirthday() {
        return String.format("%tF\n", this.birthday);
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCommands() {
        if ( this.commands == null || this.commands.isEmpty() )
            return "нет";
        return String.join("-", this.commands);

    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public String getStringType() {

        return getAnimalsType(this.type);

    }

    public void setType(animalType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, кличка: %s, родился: %s, выполняет команды: %s;", getIdPet(), getStringType(), getName(), getBirthday(), getCommands());
    }

}
