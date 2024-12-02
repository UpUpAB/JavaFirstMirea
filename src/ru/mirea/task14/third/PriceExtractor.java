package ru.mirea.task14.third;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceExtractor {
    public static void main(String[] args) {
        String text = "25.98 USD, 100.0 RUB; 50.00 EUR.44 ERR 0.004EUR";

        String regex = "\\b\\d+(\\.\\d+)?\\s*(USD|RUB|EUR)\\b";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Извлеченные цены:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}