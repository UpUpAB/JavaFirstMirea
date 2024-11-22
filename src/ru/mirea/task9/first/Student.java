package ru.mirea.task9.first;

import ru.mirea.task19.second.EmptyStringExeption;

public class Student implements Comparable<Student>{
    private String name;
    private int iDNumber;


    public Student(String name, int iDNumber) {
        this.name = name;
        this.iDNumber = iDNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(int iDNumber) {
        this.iDNumber = iDNumber;
    }
    //видел что можно заменить student на object и должно работать, но у меня не так
    @Override
    public int compareTo(Student o) {
        if (this.getIDNumber() == o.getIDNumber()){
            return this.getName().compareToIgnoreCase(o.getName());
        } else {return this.getIDNumber() - o.getIDNumber();}
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", iDNumber=" + iDNumber +
                '}';
    }
}
