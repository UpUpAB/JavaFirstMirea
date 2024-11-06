package ru.mirea.task9.first;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TestClass{
    List<Student> group= new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    //вопрос, пишет, что я не могу конвертировать объект в тип comparable, хотя объект расширяет этот же интерфейс
    public void insertion(List<Student> list){
        for (int i =0;i< list.size();i++){
            Student value = list.get(i);
            int j = i-1;
            for (;j>=0;j--){
                if (value.compareTo(list.get(j))<0){
                    list.set(j+1,list.get(j));
                } else {
                    break;
                }
            }
            list.set(j+1,value);
        }
    }
    public void setGroup(){
        System.out.println("Введите количество студентов в группе");
        int n = setNum();
        for (int i =0;i<n;i++){
            group.add(new Student(setName(),setID()));
        }
    }
    public int setNum(){
        int num;
        try {
            num = scanner.nextInt();
            if(num<0) throw new Exception();
        } catch (InputMismatchException e){
            System.out.println("Было введено не натуральное число");
            scanner.nextLine();
            return setNum();
        } catch (Exception e){
            System.out.println("Было введено не положительное значение");
            scanner.nextLine();
            return setNum();
        }
        return num;
    }
    public int setID(){
        System.out.println("Введите ID натуральными числом");
        return setNum();
    }
    public String setName(){
        System.out.println("Введите имя студента");
        String name;
        scanner.nextLine();
        try {
            name = scanner.nextLine();
        } catch (Exception e){
            System.out.println("Как это вообще получилось");
            return setName();
        }
        return name;
    }
    public TestClass(){
        setGroup();
        insertion(group);
        System.out.println(group.toString());
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
    }


}
