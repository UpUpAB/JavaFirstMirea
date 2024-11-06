package ru.mirea.task14.second;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringChecker {
    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuv18340";

        String regex = "^abcdefghijklmnopqrstuv18340$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("Строка совпадает с заданным шаблоном.");
        } else {
            System.out.println("Строка не совпадает с заданным шаблоном.");
        }
    }
}
