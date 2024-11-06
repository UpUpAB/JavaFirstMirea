package ru.mirea.task1.opt5;

public class ArgsFounder {
    public static void main(String[] args) {
        System.out.println("Общее количество аргументов: " + args.length);
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
// java ru/mirea/task1/opt5/ArgsFounder
