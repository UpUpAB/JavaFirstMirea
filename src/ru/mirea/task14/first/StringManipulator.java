package ru.mirea.task14.first;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для обработки:");
        String input = scanner.nextLine();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Найти слова по шаблону");
            System.out.println("2. Выход");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите регулярное выражение для поиска: ");
                    String patternString = scanner.nextLine();
                    Pattern pattern = Pattern.compile(patternString);
                    Matcher matcher = pattern.matcher(input);
                    boolean found = false;

                    System.out.println("Найденные слова:");
                    while (matcher.find()) {
                        System.out.println(matcher.group());
                        found = true;
                    }
                    if (!found) {
                        System.out.println("Слова не найдены по заданному шаблону.");
                    }
                    break;

                case 2:
                    System.out.println("Выход из приложения.");
                    return;

                default:
                    System.out.println("Некорректный ввод. Пожалуйста, попробуйте снова.");
            }
        }
    }
}
