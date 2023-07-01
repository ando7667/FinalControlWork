package UI;

import Models.AnimalsType;
import org.mariadb.jdbc.Connection;

import java.sql.SQLException;
import java.util.Scanner;

import static Models.AnimalsType.getStringEnumAnimalType;
import static Services.DBLib.readTable;


public class MenuAction {

    private static final Scanner inputUser = new Scanner(System.in);

    public void selectAction(int action, int type, Connection connection) throws SQLException {

        // получим название таблицы из AnimalsType.animalsType по введенному пользователем type
        String table = AnimalsType.getByValueAnimalsType(type - 1);

        // для теста
        System.out.printf("Выбран пункт меню: %d | Выбран тип питомца: %s", action, table);


        switch (action) {
            //Вывод списка питомцев по выбранному виду
            case 1 -> outputTableAnimals(connection, table);

            //Добавим нового питомца в выбранный вид
            case 2 -> addNewAnimals(connection, table);

            //Вывод списка всех команд выбранного питомца по выбранному виду
            case 3 -> outputCommandsAnimal(connection, 2, table);

            //Добавить новую команду выбранному питомцу по выбранному виду
            case 4 -> addNewCommandsAnimal(connection, 3, table);

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
    }

    public void addNewAnimals(Connection conn, String table) {
        System.out.printf("\nДобавляем нового питомца в таблицу %s\n", table);

    }

    public void outputCommandsAnimal(Connection conn, int id, String table) {
        System.out.printf("\nВыводим команды питомца c ид= %d из таблицы %s\n", id, table);

    }

    public void addNewCommandsAnimal(Connection conn, int id, String table) {
        System.out.printf("\nДобавим новую команду питомцу c ид= %d из таблицы %s\n", id, table);

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
        for (AnimalsType.animalType name : AnimalsType.animalType.values()) {
            System.out.printf("\nЧитаем содержимое таблицы %s\n", name);
            readTable(conn, name.toString());
        }
    }


    // ввод целого числа
    public int inputInt(String str) {
        System.out.println(str);
        int num;
        if (inputUser.hasNextInt()) {
            num = inputUser.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            inputUser.next();
            //рекурсия
            num = inputInt(str);
        }
        return num;
    }

}