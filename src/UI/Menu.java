package UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static Models.AnimalsType.getStringEnumAnimalType;
import static UI.UserInterface.OutputSplitLine;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    // массив строк меню выбора действия c питомцами
    private final String[] arr_action = new String[]{
            "Выход",
            "Вывод списка питомцев по видам",
            "Добавить нового питомца",
            "Вывод списка команд питомца",
            "Добавить питомцу новую команду",
            "Удалить питомца",
            "Вывод общего списка питомцев"
    };
    // массив строк подменю выбора вида животного
    String[] arr_genus;

    // сообщения для меню
    String msgAction = "Выберите действие: ";
    String msgAnimalType = "Выберите вид животного:";

    // хранит выбранное действие в меню
    private int action;

    // хранит выбранный вид животного в меню
    private int animalType;

    // конструктор
    public Menu() {
        this.action = 0;
        this.animalType = 0;

        // переносим содержимое enum AnimalType.AnimalSpecies в массив arr_genus, который используется
        //  для построения подменю выбора вида питомца
        String str = getStringEnumAnimalType();
        ArrayList<String> listAnimals = new ArrayList<String>(Arrays.asList(str.split(",")));
        listAnimals.add(0, "Назад");

        this.arr_genus = new String[listAnimals.size()];
        listAnimals.toArray(this.arr_genus);
    }

    public int getAction() {
        return this.action;
    }

    public int getAnimalType() {
        return this.animalType;
    }

    /**
     * Основной метод работы с меню
     * реализует выбор пользователем действия из меню и вид питомца
     */
    public void showMenu() {
        UserInterface.showText(arr_action);
        setAction();
        OutputSplitLine();
        if (action == 0) {
            System.out.println("Пока!");
        } else {
            if (action < arr_action.length - 1) {
                UserInterface.showText(arr_genus);
                setAnimalType();
                OutputSplitLine();
                if (animalType == 0) {
                    showMenu();
                }
            }
        }
    }

    /**
     * Метод для выбора пользователем пункта меню действий
     */
    private void setAction() {
        while (true) {
            action = UserInterface.InputInt(msgAction);
            // проверяем выход за пределы существующих действий ( смотри arr_action )
            if (action < arr_action.length && action >= 0) {
                break;
            }
        }
    }

    /**
     * Метод для выбора пользователем вида питомца в доп.меню
     */
    private void setAnimalType() {
        while (true) {
            animalType = UserInterface.InputInt(msgAnimalType);
            // проверяем выход за пределы существующих типов ( смотри enum AnimalType.AnimalSpecies )
            if (animalType < arr_genus.length && animalType >= 0) {
                break;
            }
        }
    }
}