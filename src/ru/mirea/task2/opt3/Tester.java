package ru.mirea.task2.opt3;


import java.lang.*;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координату х:");
        double x=0;
        double y=0;
        double r=0;
        String color="";
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
        Point pn1 = new Point(x,y);
        System.out.println("Введите радиус:");

        if (sc.hasNextDouble()) {
            r = sc.nextDouble();
        } else {
            System.out.println("Было введено неправильное число");
            System.exit(0);
        }
        sc.nextLine();
        System.out.println("Введите цвет:");

        if (sc.hasNextLine()) {
            color = sc.nextLine();
        } else {
            System.out.println("Было введено неправильное число");
            System.exit(0);
        }
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
