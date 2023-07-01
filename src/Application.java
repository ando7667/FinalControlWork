
import java.io.IOException;
import java.sql.SQLException;

import UI.Menu;
import UI.MenuAction;
import org.mariadb.jdbc.Connection;

import static Services.DBLib.*;

public class Application {

    private static Connection connection;


    public static void main(String[] args) throws SQLException, IOException {
        try {
            connection = initDatabaseConnection();
            Menu m = new Menu();
            MenuAction ma = new MenuAction();
            // вызов меню
            boolean menuContinue = true;
            while (menuContinue) {
                m.showMenu();
                // если выбрали режим 0 - выход из программы
                if (m.getAction() != 0) {
                    ma.selectAction(m.getAction(), m.getAnimalType(), connection);
                }else {
                    menuContinue = false;
                }
            }
            // все далее для теста, удалить  !!!
//            System.out.println("Читаем содержимое таблицы cats из базы данных human_friends");
//            readTable(connection, "cats");
//            // Введем новых животных
//            Dog pet1 = new Dog(110,"Фунтик","2015-08-16","стоять,лежать,голос");
//            Cat pet2 = new Cat(100,"Люси","2015-11-21","имя,кискис");
//            Horse pet3 = new Horse(80,"Арчебальд","2015-11-21","вперед,стой,рысь");
//            System.out.println("Вывод новых животных в консоль");
//            System.out.println(pet1.toString());
//            System.out.println(pet2.toString());
//            System.out.println(pet3.toString());

            //запись питомца в соответствующую таблицу
//            writeRecords(connection,"cats","Люси","2015-11-21", "имя,кискис", 2);

            // для теста --- потом удалить
//            String group = pet1.getStringAnimalGroups();
//            System.out.println("group= "+group);
//            System.out.println("тип группы: "+pet1.getAnimalGroups());
//            System.out.println("id группы: "+pet1.getIntAnimalGroups());
//            System.out.println("вид: "+pet1.type);
//            System.out.println("id вида: "+pet1.type.ordinal());
//            group = pet2.getStringAnimalGroups();
//            System.out.println("group= "+group);
//            System.out.println("тип группы: "+pet2.getAnimalGroups());
//            System.out.println("id группы: "+pet2.getIntAnimalGroups());
//            System.out.println("вид: "+pet2.type);
//            System.out.println("id вида: "+pet2.type.ordinal());
//            group = pet3.getStringAnimalGroups();
//            System.out.println("group= "+group);
//            System.out.println("тип группы: "+pet3.getAnimalGroups());
//            System.out.println("id группы: "+pet3.getIntAnimalGroups());
//            System.out.println("вид: "+pet3.type);
//            System.out.println("id вида: "+pet3.type.ordinal());
        } finally {
            if (connection != null) {
                closeDatabaseConnection(connection);
            }
        }
    }

}
