package ru.mirea.task20.first;

import java.io.Serializable;

class Animal  {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Monkey extends Animal implements Serializable{
    public Monkey(String type) {
        super(type);
    }

    @Override
    public String toString() {
        return "Monkey{ " + super.toString()+"}";
    }
}

public class Common <T extends Comparable<T>,V extends Animal & Serializable,K>{
    private T commonType;
    private V value;
    private K key;

    public Common(T commonType, V value, K key) {
        this.commonType = commonType;
        this.value = value;
        this.key = key;
        getTypesAndValues();
    }
    public void getTypesAndValues(){
        System.out.println("Название первого типа и его значение:"+commonType.getClass().getName()+", "+commonType);
        System.out.println("Название второго типа и его значение:"+value.getClass().getName()+", "+value);
        System.out.println("Название третьего типа и его значение:"+key.getClass().getName()+", "+key);

    }

    public static void main(String[] args) {
        new Common<>(1,new Monkey("miha"),2.3);
    }
}
