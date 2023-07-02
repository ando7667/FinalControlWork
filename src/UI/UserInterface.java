package UI;

import org.mariadb.jdbc.Connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UserInterface {
    static String str;
    static int val;
    static Scanner scanner = new Scanner(System.in);

    /**
     * Метод для вывода сообщения пользователю
     * и получения от него строки
     *
     * @param msg строка сообщения
     * @return введенная строка
     */
    public static String InputString(String msg) {

        System.out.printf(msg);
        return scanner.nextLine();
    }

    /**
     * Метод для вывода сообщения пользователю
     * и получения от него целого
     *
     * @param msg строка выводимого сообщения пользователю перед вводом
     * @return возвращает целое число
     */
    public static int InputInt(String msg) {
        str = InputString(msg);
        try {
            val = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            System.out.println("\nВвели неправильные данные!");
            InputInt(msg);
        }
        return val;
    }

    /**
     * Метод для вывода сообщения пользователю
     * и получения от него даты в формате гггг-мм-дд
     *
     * @param msg строка выводимого сообщения пользователю перед вводом
     */
    public static String InputFormatData(String msg) {

        str = InputString(msg);
        if (!isValidDate()) {
            System.out.println("\nВвели неправильные данные!");
            InputFormatData(msg);
        }
        return str;
    }

    /**
     * Выводит строку отбивкки
     */
    public static void OutputSplitLine() {
        System.out.println(String.format("\n%55s", "").replace(' ', '-'));
    }

    /**
     * Метод проверки правильности ввода Даты
     */
    static boolean isValidDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String regex = "^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$";
        if (str == null || !str.matches(regex))
            return false;
        try {
            format.parse(str);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * вывод массива строк на экран в виде меню
     *
     * @param arr принимает массив строк для вывода
     */
    public static void showText(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " - " + arr[i]);
        }
    }

    public static boolean ValidatorInputDate(Connection conn, String table, String name, String birthday,String commands, int genus) {

        boolean valid = true;
        if(table.isEmpty()) valid = false;
        if(name.isEmpty()) valid = false;
        if (birthday.isEmpty()) valid = false;
        return valid;
    }
}
