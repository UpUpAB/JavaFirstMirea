package ru.mirea.task8.fifthteen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OpositeNumberChars {
    private static int num=0;
    private static Scanner scanner = new Scanner(System.in);
    public static int setI(){
        try {
            num = scanner.nextInt();
            if(num<0) throw new Exception();
        } catch (InputMismatchException e){
            System.out.println("Было введено не натуральное число");
            scanner.nextLine();
            return setI();


        } catch (Exception e){
            System.out.println("Было введено не положительное значение");
            scanner.nextLine();
            return setI();
        }
        return num;
    }
    public static int func(int num){
        if (num / 10 != 0){
            func(num/10);
            System.out.printf("%d ", num % 10);
            return num;
        } else {
            System.out.printf("%d ",num);
            return num;
        }
    }

    public static void main(String[] args) {
        func(setI());
    }
}
