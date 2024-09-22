package ru.mirea.task4.shape;

public class Circle extends Shape{
    public double radius;

    public Circle(double radius) {
        type = "STRING";
        this.radius = radius;
        area = radius*radius*Math.PI;
        perimetr = 2*Math.PI*radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }
}
