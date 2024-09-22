package ru.mirea.task4.shape;

public class Shape {
    public String type;
    public double area;
    public double perimetr;

    public Shape(String type) {
        this.type = type;
    }

    public Shape() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getArea(){
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetr(){
        return perimetr;
    }

    public void setPerimetr(double perimetr) {
        this.perimetr = perimetr;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "type='" + type + '\'' +
                ", area=" + area +
                ", perimetr=" + perimetr +
                '}';
    }
}
