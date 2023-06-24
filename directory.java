package task5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class directory {
    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);

        printinfo();
        System.out.print("Введите число: ");
        int a = iScanner.nextInt();

        Map<String, String> newDirectory = new HashMap<String, String>();
        {

        }
        while (a != 0) {

            switch (a) {
                case 1:
                    createHashMap(newDirectory);
                    printinfo();
                    break;
                case 2:
                    searchDirectory(newDirectory);
                    printinfo();
                    break;
                case 3:
                    addDirectory(newDirectory);
                    System.out.println("Данные добавлены");
                    printinfo();
                    break;
                case 4:
                    dellDirectory(newDirectory);
                    printinfo();
                    break;

                default:
                    System.out.println("Данные не верны, попробуйте еще раз");
                    printinfo();
                    break;
            }
            System.out.print("Введите число: ");
            a = iScanner.nextInt();
        }
        System.out.println("Конец");

    }

    public static void createHashMap(Map<String, String> newDirectory) {

        for (Map.Entry<String, String> item : newDirectory.entrySet()) {
            StringBuilder numbers = new StringBuilder();
            String[] values = item.getValue().split(", ");
            for (String value : values) {
                numbers.append(value);
            }
            System.out.printf("Имя: %s  Номер: %s \n", item.getKey(), numbers.toString());
        }
    }

    public static void addDirectory(Map<String, String> newDirectory) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите Имя");
        String name = iScanner.next();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        System.out.println("Введите Номер");
        String number = iScanner.next();
        if (newDirectory.containsKey(name)) {
            newDirectory.merge(name, number, (oldValue, newValue) -> oldValue + " , " + newValue);

        } else {
            newDirectory.put(name, number);
        }
    }

    public static void searchDirectory(Map<String, String> newDirectory) {

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите Имя");
        String name = iScanner.next();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        System.out.print(name);
        String value = newDirectory.get(name);
        if (value != null) {
            String[] numbers = value.split(", ");
            for (String number : numbers) {
                System.out.print(" " + number);

            }
        } else {
            System.out.println("Контакт не найден");
        }
        System.out.println();
    }

    public static void printinfo() {
        System.out.println("Введите 1 для вывода всего списка справочника");
        System.out.println("Введите 2 для поиска контакта в справочнике");
        System.out.println("Введите 3 для добавления контакта в справочник");
        System.out.println("Введите 4 для удаления контакта из справочник");
        System.out.println("Введите 0 для выхода из справочника");
    }

    public static void dellDirectory(Map<String, String> newDirectory) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите Имя");
        String name = iScanner.next();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        if (newDirectory.containsKey(name)) {
            newDirectory.remove(name);
            System.out.println("Удален " + name);
        } else {
            System.out.println("Контакт не найден");
        }
    }
}
