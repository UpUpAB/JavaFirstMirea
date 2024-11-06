package ru.mirea.task13.frist;

public class StringMethods {
    public static void main(String[] args) {
        String stringTest = "I like Java!!!";
        System.out.println(stringTest.charAt(stringTest.length()-1));
        System.out.println("Строка заканчивается на '!!!': "+stringTest.endsWith("!!!"));
        System.out.println("Строка начинается на 'I like': "+stringTest.startsWith("I like"));
        System.out.println("Строка содержит слово 'Java': "+stringTest.contains("Java"));
        System.out.println("Позиция слова Java: "+(stringTest.indexOf("Java")+1)+"-"+(stringTest.indexOf("Java")+4));
        String[] stringJava = stringTest.split(" ");
        for (int i =0;i<stringJava.length;i++){
            if (stringJava[i].contains("Java")) System.out.println("Позиция слово Java среди слов: "+(i+1));
        }
        System.out.println("Замена всех а на о: "+stringTest.replaceAll("a","o"));
        System.out.println("Преобразование к нижнему регистру: "+stringTest.toLowerCase());
        System.out.println("Преобразование к верхнему регистру: "+stringTest.toUpperCase());
        System.out.println("Вырезанное слова Java: "+stringTest.substring(7,11));

    }
}
