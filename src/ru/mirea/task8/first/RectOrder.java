package ru.mirea.task8.first;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RectOrder {
    private static int num=0;
    private static Scanner scanner = new Scanner(System.in);
    public static int setNum(){
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
    public static void func(int k){
        for (int i =1;i<=k;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

    }
}
