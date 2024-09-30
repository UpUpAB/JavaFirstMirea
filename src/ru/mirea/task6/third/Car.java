package ru.mirea.task6.third;

public class Car implements Namable {
    private String name;
    private int speed;
    private int price;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int speed, int price) {
        this.name = name;
        this.speed = speed;
        this.price = price;
    }

    @Override
    public String getName() {
        return "Название машины: "+name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Namable car = new Car("Bugatti");
        System.out.println(car.getName());
    }
}
