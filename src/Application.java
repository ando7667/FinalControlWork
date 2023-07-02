
import java.io.IOException;
import java.sql.SQLException;

import UI.Menu;
import UI.MenuAction;
import org.mariadb.jdbc.Connection;

import static Services.DBLib.*;
import static UI.MenuAction.initCounter;

public class Application {

    private static Connection connection;


    public static void main(String[] args) throws SQLException, IOException {
        try {
            connection = initDatabaseConnection();
            // инициализируем счетчик животных по содержимому базы
            System.out.printf("Количество животных в базе: %d\n\n", initCounter(connection));
            Menu m = new Menu();
            MenuAction ma = new MenuAction();

            // вызов меню
            boolean menuContinue = true;
            while (menuContinue) {
                m.showMenu();
                // если выбрали режим 0 - выход из программы
                if (m.getAction() != 0) {
                    ma.selectAction(m.getAction(), m.getAnimalType(), connection);
                } else {
                    menuContinue = false;
                }
            }

        } finally {
            if (connection != null) {
                closeDatabaseConnection(connection);
            }
        }
    }

}
