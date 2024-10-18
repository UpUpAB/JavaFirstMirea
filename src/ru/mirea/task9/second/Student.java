package ru.mirea.task9.second;

public class Student implements Comparable<Student>{
    private String name;
    private int iDNumber;
    private int grade;


    public Student(String name, int iDNumber, int grade) {
        this.name = name;
        this.iDNumber = iDNumber;
        this.grade = grade;
    }
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int iDNumber) {
        this.iDNumber = iDNumber;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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
                ", grade=" + grade +
                '}';
    }
}
