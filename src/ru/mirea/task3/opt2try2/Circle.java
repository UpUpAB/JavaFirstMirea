package ru.mirea.task3.opt2try2;

public class Circle {
    private Point xy;
    private double r;

    public Circle(Point xy, double r) {
        this.xy = xy;
        this.r = r;
    }

    public double getX() {
        return xy.getX();
    }
    public double getY() {
        return xy.getY();
    }
    public double getR() {
        return r;
    }
    public void setX(double x) {
        this.xy.setX(x);
    }
    public void setY(double y) {
        this.xy.setX(y);
    }
    public void setR(double r) {
        this.r = r;
    }

    public double getPerimetr(){
        return Math.PI*r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "xy=" + xy +
                ", r=" + r +
                '}';
    }
}
