package ru.mirea.task19.second;
/*Создать свой класс Student со всеми переменными экземпляра,
конструктором, включающим все переменные, предпочтительно
использовать геттеры и сеттеры для каждой переменной. Класс студент
имеет свойства: Имя, Фамилия, Специальность, Курс, Группа*/
public class Student implements Comparable<Student>{
    String fullName;
    double gpa;


    public Student(String fullName, double gpa) {
        this.fullName = fullName;
        this.gpa = gpa;
        if (fullName.trim().equals("") || fullName == null) throw new EmptyStringExeption();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        if (this.getGpa()>o.getGpa()){
            return 1;
        } else if (this.getGpa()<o.getGpa()){
            return -1;
        } else return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
