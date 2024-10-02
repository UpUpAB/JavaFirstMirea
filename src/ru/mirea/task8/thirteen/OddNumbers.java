package ru.mirea.task8.thirteen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OddNumbers {
    public static void func(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> num = new ArrayList<>();
        int a=1;
        int errI = 1;
        System.out.println("Введите целые числа последовательности, чтобы закончить введите 0");
        do {
            try{
                a=scanner.nextInt();
                errI++;
                if (a<0) throw new Exception("");
            } catch (InputMismatchException e){
                System.out.println("Введённое значение на позиции "+errI+" не является числом");
                System.exit(0);
            } catch (Exception e){
                System.out.println("Введённое значение: "+ a +" не является положительным числом");
                System.exit(0);
            }
            num.add(a);
        } while (a!=0);
        num.remove(num.indexOf(0));

        for(int i=0;i<num.size();i=i+2){
            System.out.println(num.get(i));
        }
    }
    public static void main(String[] args) {
        func();
    }
}
