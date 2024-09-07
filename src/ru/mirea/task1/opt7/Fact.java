package ru.mirea.task1.opt7;

import java.util.Scanner;

public class Fact {
    public static int factor(int n){
        for (int i=(n-1); i>0; i--){
            n*=i;
        }
        return n;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите факториал целым числом: ");
        int num = 1;
        if (sc.hasNextInt()) {
            num = sc.nextInt();
        } else {
            System.out.println("Было введено неправильное число");
            System.exit(0);
        }
        int ans = factor(num);
        System.out.format("Факториал числа %d - число %d",num,ans);
    }
}
