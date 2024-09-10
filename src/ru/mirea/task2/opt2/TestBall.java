package ru.mirea.task2.opt2;

import java.lang.*;
import java.util.Scanner;
public class TestBall {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double x=0;
        double y=0;
        System.out.println("Введите координату х:");
        if (sc.hasNextDouble()) {
            x = sc.nextDouble();
        } else {
            System.out.println("Было введено неправильное число");
            System.exit(0);
        }
        System.out.println("Введите координату y:");
        if (sc.hasNextDouble()) {
            y = sc.nextDouble();
        } else {
            System.out.println("Было введено неправильное число");
            System.exit(0);
        }
        Ball test1 = new Ball(x,y);
        System.out.println(test1);
        test1.move(10,20);
        System.out.println("Используем метод move:");
        System.out.println(test1);
        test1.setXY(1,1);
        System.out.println("Используем метод setXY:");
        System.out.println(test1);

    }
}
