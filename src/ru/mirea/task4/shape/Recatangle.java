package ru.mirea.task4.shape;

public class Recatangle extends Shape {
    public double a;
    public double b;
    public double c;
    public double h;

    public Recatangle(double a, double b, double c) {
        type = "RECTANGLE";
        this.a = a;
        this.b = b;
        this.c = c;
        h=Math.sqrt(a*a-(b/2 + (a*a-c*c)/(2*b))*((a*a-c*c)/(2*b)+b/2));
        area= a*h/2;
        perimetr=a+b+c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getHight() {
        return h;
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
        return "Recatangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", h=" + h +
                "} " + super.toString();
    }
}
