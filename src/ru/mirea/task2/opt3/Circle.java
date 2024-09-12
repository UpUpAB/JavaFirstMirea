package ru.mirea.task2.opt3;

public class Circle {
    private Point xy;
    private double r;
    private String color;

    public Circle(Point xy, double r, String color) {
        this.xy = xy;
        this.r = r;
        this.color = color;
    }

    public Point getXy() {
        return xy;
    }

    public void setXy(Point xy) {
        this.xy = xy;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getPerimetr(){
        return Math.PI*this.getR();
    }
    public void setX(double x){
        xy.setX(x);
    }
    public double getX(){
        return xy.getX();
    }
    public void setY(double y){
        xy.setX(y);
    }
    public double getY(){
        return xy.getY();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "xy=" + xy +
                ", r=" + r +
                ", color='" + color + '\'' +
                '}';
    }
}
