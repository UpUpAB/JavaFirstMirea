package ru.mirea.task8.fourteen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberChars {
    private static int num=0;
    private static Scanner scanner = new Scanner(System.in);
    public static int setNum(){
        System.out.println("Введите ваше натуральное число:");
        try {
            num = scanner.nextInt();
            if(num<0) throw new Exception();
        } catch (InputMismatchException e){
            System.out.println("Было введено не натуральное число");
            scanner.nextLine();
            return setNum();


        } catch (Exception e){
            System.out.println("Было введено не положительное значение");
            scanner.nextLine();
            return setNum();
        }
        return num;
    }
    public static int func(int num){
        if (num / 10 != 0){
            System.out.printf("%d ", num % 10);
            return func(num / 10);
        } else {
            System.out.println(num);
            return num;
        }
    }

    public static void main(String[] args) {
        func(setNum());
    }
}
