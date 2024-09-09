package ru.mirea.task2.opt2;

import java.lang.*;
import java.util.Scanner;
public class TestBall {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координату х:");
        double x = sc.nextDouble();
        System.out.println("Введите координату y:");
        double y = sc.nextDouble();
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
