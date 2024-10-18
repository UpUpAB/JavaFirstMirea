package ru.mirea.task11.third;

import java.text.SimpleDateFormat;
import java.util.Date;

/*Создать свой класс Student со всеми переменными экземпляра,
конструктором, включающим все переменные, предпочтительно
использовать геттеры и сеттеры для каждой переменной. Класс студент
имеет свойства: Имя, Фамилия, Специальность, Курс, Группа*/
public class Student {
    String name;
    String surname;
    String speciality;
    int course;
    String group;
    int gpa;
    SimpleDateFormat shortFormatter = new SimpleDateFormat("d-M-y");
    SimpleDateFormat middleFormatter = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat longFormatter = new SimpleDateFormat("d MMMM,yyyy");
    Date birthDate;
    String birthDateStr;


    public Student(String name, String surname, String speciality, int course, String group) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.course = course;
        this.group = group;
    }
    public Student(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        setBirthDateStr("middle");
    }
    public void setBirthDateStr(String format){
        if (format.equals("long")){
            birthDateStr = longFormatter.format(birthDate);
        } else if (format.equals("middle")) {
            birthDateStr = middleFormatter.format(birthDate);
        } else if (format.equals("short")) {
            birthDateStr = shortFormatter.format(birthDate);
        } else {
            System.out.println("Введённый формат не существует (Попробуйте long/middle/short)");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", speciality='" + speciality + '\'' +
                ", course=" + course +
                ", group='" + group + '\'' +
                ", gpa=" + gpa +
                ", birthDate=" + birthDateStr +
                '}';
    }

    public static void main(String[] args) {
        Date birth = new Date();
        Student student = new Student("Vova",birth);
        System.out.println(student);
        student.setBirthDateStr("long");
        System.out.println(student);

    }
}
