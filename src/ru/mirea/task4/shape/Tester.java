package ru.mirea.task4.shape;

public class Tester {
    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        System.out.println(c1.toString());
        System.out.printf("%.3f\n",c1.getArea());
        System.out.printf("%.3f\n",c1.getPerimetr());
        System.out.println(c1.getType());
        Square s1 = new Square(5,5);
        System.out.println(s1.toString());
        System.out.printf("%.3f\n",s1.getArea());
        System.out.printf("%.3f\n",s1.getPerimetr());
        System.out.println(s1.getType());
        Recatangle r1 = new Recatangle(2,2,2);
        System.out.println(r1.toString());
        System.out.printf("%.3f\n",r1.getArea());
        System.out.printf("%.3f\n",r1.getPerimetr());
        System.out.println(r1.getType());

    }
}
