package ru.mirea.task8.first;

import java.util.*;


public class RectOrder {
    private static int num=0;
    private static Scanner scanner = new Scanner(System.in);
    public static int setNum(){
        System.out.println("Введите натуральным числом кол-во значений, которое требуется вывести необходимо вывести:");
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
        int count=0;
        int currentNum = 1;
        int numCount = 1;
        for (; count < k;) {
            if (numCount<=currentNum){
                System.out.print(currentNum +" ");
                count++;
                numCount++;
            } else {
                currentNum++;
                numCount =1;
            }
        }

    }

    public static void main(String[] args) {
        func(setNum());
    }
}
