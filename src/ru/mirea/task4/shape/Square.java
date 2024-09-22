package ru.mirea.task4.shape;

public class Square extends Shape {
    public double a;
    public double b;

    public Square(double a, double b) {
        type = "SQUARE";
        this.a = a;
        this.b = b;
        area = a*b;
        perimetr=2*a+2*b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimetr() {
        return super.getPerimetr();
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                ", b=" + b +
                "} " + super.toString();
    }
}
