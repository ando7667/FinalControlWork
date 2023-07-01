package UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Models.AnimalsType.getStringEnumAnimalType;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    // массив строк меню выбора опреции c питомцами
    private final String[] arr_action = new String[] {
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
    String msgAction = "\nВыбирите действие: ";
    String msgAnimalType = "\nВыберите вид животного:";

    // хранит выбранное действие в меню
    private int action;

    // хранит выбранный тип животного в меню
    private int animalType;

    // конструктор
    public Menu() {
        this.action = 0;
        this.animalType = 0;

        // переносим содержимое enum AnimalType.animalType в массив arr_genus, который используется
        //  для построения подменю выбора типа животного
        String str = getStringEnumAnimalType();
        ArrayList<String>listAnimals = new ArrayList<String>(Arrays.asList(str.split(",")));
        listAnimals.add(0,"Назад");

        this.arr_genus =  new String[ listAnimals.size() ];
        listAnimals.toArray (this.arr_genus);

    }

    public int getAction() {
        return this.action;
    }

    public int getAnimalType() { return this.animalType;
    }

    // вывод массива строк на экран в виде меню
    private void showText(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " - " + arr[i]);
        }
    }

    // получить число от пользователя
    public double getNumber() {
        double num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            //рекурсия до правильного ввода
            num = getNumber();
        }
        return num;
    }

    // установка действия
    private void setAction() {
        while (true) {
            System.out.println(msgAction);
            showText(arr_action);
            action = (int) getNumber();
            // проверяем выход за пределы существующих действий
            if (action < arr_action.length && action >= 0) {
                break;
            }
        }
    }

    private void setAnimalType() {
        while (true) {
            System.out.println(msgAnimalType);
            showText(arr_genus);
            animalType = (int) getNumber();
            // проверяем выход за пределы существующих типов ( смотри enum AnimalType.animalType )
            if (animalType < arr_genus.length && animalType >= 0) {
                break;
            }
        }
    }

    // пройтись по меню и выбрать операцию и тип животного
    public void showMenu() {
        setAction();
        if (action == 0) {
            System.out.println("Пока!");
        }else {
            if (action < arr_action.length - 1) {
                setAnimalType();
                if (animalType == 0) {
                    showMenu();
                }
            }
        }
    }
}