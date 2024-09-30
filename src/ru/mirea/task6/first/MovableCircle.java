package ru.mirea.task6.first;

public class MovableCircle extends MovablePoint implements Movable{
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        super(x, y, xSpeed, ySpeed);
        this.radius = radius;
        center = new MovablePoint(x,y,xSpeed,ySpeed);
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                "} ";
    }

    @Override
    public void moveUp() {
        super.moveUp();
        center.moveUp();
    }

    @Override
    public void moveDown() {
        super.moveDown();
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        super.moveRight();
        center.moveRight();
    }

    public static void main(String[] args) {
        Movable c1 = new MovableCircle(1,1,1,1,1);
        c1.moveRight();
        System.out.println(c1);
    }
}
