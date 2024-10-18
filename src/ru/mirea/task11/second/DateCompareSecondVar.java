package ru.mirea.task11.second;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateCompareSecondVar {
    static Scanner scanner = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static LocalDate input(){
        System.out.print("Введите дату (dd.mm.yyyy): ");
        String inputDateStr;
        LocalDate inputDate;
        try {
            inputDateStr = scanner.nextLine();
            inputDate = LocalDate.parse(inputDateStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Некорректный формат даты. Введите дату в формате dd.MM.yyyy.");
            return input();
        }
        return inputDate;
    }
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate inputDate = input();

        if (inputDate.isAfter(currentDate)) {
            System.out.println("Введенная дата " + inputDate + " позже текущей даты " + currentDate);
        } else if (inputDate.isBefore(currentDate)) {
            System.out.println("Введенная дата " + inputDate + " раньше текущей даты " + currentDate);
        } else {
            System.out.println("Введенная дата " + inputDate + " совпадает с текущей датой " + currentDate);
        }

    }
}
