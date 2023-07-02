package UI;

import Models.Animals.HomeAnimalsMem.Cat;
import Models.Animals.HomeAnimalsMem.Dog;
import Models.Animals.HomeAnimalsMem.Hamster;
import Models.Animals.PackAnimalsMem.Camel;
import Models.Animals.PackAnimalsMem.Donkey;
import Models.Animals.PackAnimalsMem.Horse;
import Models.AnimalsType;
import Services.AnimalCounter;
import org.mariadb.jdbc.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static Models.AnimalsType.*;
import static Services.AnimalCounter.setCounter;
import static Services.DBLib.*;
import static UI.UserInterface.*;

public class MenuAction {

    private static final Scanner input = new Scanner(System.in);


    public void selectAction(int action, int type, Connection connection) throws SQLException {

        // получим название таблицы из AnimalsType.AnimalSpecies по введенному пользователем type
        String table = AnimalsType.getAnimalType(type - 1).toString();

        switch (action) {
            //Вывод списка питомцев по выбранному виду
            case 1 -> outputTableAnimals(connection, table);

            //Добавим нового питомца в выбранный вид
            case 2 -> addNewAnimals(connection, table, type - 1);

            //Вывод списка всех команд выбранного питомца по выбранному виду
            case 3 -> outputCommandsAnimal(connection, table);

            //Добавить новую команду выбранному питомцу по выбранному виду
            case 4 -> addNewCommandsAnimal(connection, table);

            //Удаить выбранного питомца по выбранному виду
            case 5 -> deleteAnimal(connection, 2, table);

            //Вывод списка всех питомцев
            case 6 -> outputAllAnimals(connection);
            default -> System.out.println("Был передан неправильный аргумент меню!");
        }
    }

    /**
     * Метод читает таблицу из базы животных и выводит их на экран
     *
     * @param conn  принимает Connection коннект к базе
     * @param table имя таблицы для чтения из базы
     */
    public void outputTableAnimals(Connection conn, String table) throws SQLException {

        System.out.printf("\nЧитаем содержимое таблицы %s\n", table);
        readTable(conn, table);
        OutputSplitLine();
    }

    public void addNewAnimals(Connection conn, String table, int tp) {
        System.out.printf("\nДобавляем нового питомца в таблицу %s\n", table);
        // определим группу животного из его вида
        int group;
        switch (getAnimalType(tp)) {
            case dogs -> group = new Dog().getIntAnimalGroups();
            case cats -> group = new Cat().getIntAnimalGroups();
            case hamsters -> group = new Hamster().getIntAnimalGroups();
            case horses -> group = new Horse().getIntAnimalGroups();
            case camels -> group = new Camel().getIntAnimalGroups();
            case donkeys -> group = new Donkey().getIntAnimalGroups();
            default -> group = 0;
        }

        // определим вид животного, согласованный с базой данных
        int genus = getGenusAnimalSpecies(tp);

        String name = UserInterface.InputString("Введите кличку питомца: ");
        String birthday = UserInterface.InputFormatData("Введите дату рождения питомца (образец - 2011-05-08): ");
        String commands = UserInterface.InputString("Введите через ',' команды, которые знает питомец (образец - вперед,стой,рысь): ");
        if (ValidatorInputDate(conn, table, name, birthday, commands, genus)) {
            System.out.printf("\nГруппа животных= %d", genus);
            writeRecords(conn, table, name, birthday, commands, genus);
            System.out.printf("Количество животных в базе: %d\n", AnimalCounter.getCounter());
            OutputSplitLine();
        } else {
            System.out.println("Введены неполные данные! Повторите ввод!");
            addNewAnimals(conn, table, tp);
        }
    }


    public int outputCommandsAnimal(Connection conn, String table) {
        String commands;
        readTable(conn, table);
        OutputSplitLine();
        int id = UserInterface.InputInt("Введите ид питомца:");
        if (id > 0) {
            System.out.printf("\nВыводим команды питомца c ид= %d из таблицы %s\n", id, table);
            commands = readCommandsAnimal(conn, table, id);
            System.out.printf("Питомец %d знает команды: %s\n", id, commands);
            OutputSplitLine();
        }
        return id;
    }

    public void addNewCommandsAnimal(Connection conn, String table) {
        int id = outputCommandsAnimal(conn, table);
        String commands;
        ArrayList<String> animal = readRecordTable(conn, table, id);

        commands = InputString("Введите новую команду");
        if (animal.get(3) == null || animal.get(3).isEmpty() || animal.get(3).length() == 0) {
            animal.set(3, commands);
        } else {
            animal.set(3, animal.get(3) + ',' + commands);
        }

        System.out.printf("\nДобавим новую команду питомцу %s из таблицы %s\n", animal.get(1), table);
        updateRecordTable(conn, table, animal);
        OutputSplitLine();

    }

    public void deleteAnimal(Connection conn, int id, String table) {
        System.out.printf("\nУдалим питомца c ид= %d из таблицы %s\n", id, table);

    }

    /**
     * Метод читает все таблицы животных из базы и выводит их на экран
     *
     * @param conn принимает Connection коннект к базе
     */
    public void outputAllAnimals(Connection conn) throws SQLException {

        System.out.println("Читаем содержимое всех таблиц\n");
        String[] arr_str = getStringEnumAnimalType().split(",");
        for (AnimalSpecies name : AnimalSpecies.values()) {
            System.out.printf("\nЧитаем содержимое таблицы %s\n", name);
            readTable(conn, name.toString());
        }
        OutputSplitLine();
    }

    public static int initCounter(Connection conn) throws SQLException {
        int records = 0;
        for (AnimalsType.AnimalSpecies name : AnimalsType.AnimalSpecies.values()) {
            records  = records + getNumberAnimalsRecords(conn, name.toString());
         }
        setCounter(records);
        return records;
    }

}