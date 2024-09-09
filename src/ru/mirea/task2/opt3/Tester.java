package ru.mirea.task2.opt3;

import ru.mirea.task2.opt2.Ball;

import java.lang.*;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координату х:");
        double x = sc.nextDouble();
        System.out.println("Введите координату y:");
        double y = sc.nextDouble();
        Point pn1 = new Point(x,y);
        System.out.println("Введите радиус:");
        double r = sc.nextDouble();
        sc.nextLine();
        System.out.println("Введите цвет:");
        String color = sc.nextLine();
        Circle cr1 = new Circle(pn1,r,color);
        System.out.println(cr1);
        System.out.println("Введите радиус:");
        r = sc.nextDouble();
        if (r != 0){
            cr1.setR(r);
            System.out.println("Длина окружности = " + cr1.getPerimetr()+"см");
        } else {
            System.out.println("Длина окружности = 0 см");
        }
    }
}
