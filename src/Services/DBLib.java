package Services;

import Models.Animals.Animals;
import org.mariadb.jdbc.Connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBLib {

    private static Connection con;
    private static Statement statDB;
    private static ResultSet resultSet;
    private static String query;

    public static java.sql.Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/Resources/database.properties")) {

            props.load(fis);
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");
            return DriverManager.getConnection(url, username, password);
        }
    }

    public static Connection initDatabaseConnection() throws SQLException, IOException {
        System.out.println("\nПодключаемся к базе данных...");
        con = (Connection) getConnection();
        checkConnection(con);
        return (Connection) getConnection();

    }


    public static void closeDatabaseConnection(Connection con) throws SQLException {
        System.out.println("\nЗакрываем подключение к базе данных...");
        con.close();
        checkConnection(con);
    }

    private static void checkConnection(Connection con) throws SQLException {
        System.out.println("Подключение есть?: " + (con.isValid(5) ? "Да" : "Нет"));
    }


    public static void writeRecords(Connection con, String table, String name, String birthday, String commands, int id_genus) throws SQLException {

        query = "INSERT INTO " + table + " (name, birthday, commands, id_genus) VALUES (?, ?, ?, ?)";
        try (PreparedStatement prepSt = con.prepareStatement(query)) {

//            prepSt.setString(1, table);
            prepSt.setString(1, name);
            prepSt.setString(2, birthday);
            prepSt.setString(3, commands);
            prepSt.setInt(4, id_genus);

            int rowsInserted = prepSt.executeUpdate();
            System.out.println("Строка добавлена: " + rowsInserted);
        } catch (SQLException ex) {
            Logger.getLogger(DBLib.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static void readTable(Connection con, String table) throws SQLException {

        try (Statement statDB = con.createStatement()) {
            query = "SELECT id, name, birthday, commands, id_genus" +
                    " FROM " + table +
                    " ";
            resultSet = statDB.executeQuery(query);
            boolean empty = true;
            while (resultSet.next()) {
                empty = false;
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String birthday = resultSet.getString(3);
                String commands = resultSet.getString(4);
                int id_genus = resultSet.getInt(5);
                System.out.println(id + ",\t" + id_genus + ",\t" + name + ",\t" + birthday + ",\t" + commands + ";");
            }
            if (empty) {
                System.out.printf("\t В таблице %s нет записей", table);
            }

        }

    }


}
