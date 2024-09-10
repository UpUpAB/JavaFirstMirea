package ru.mirea.task2.opt1;

import java.lang.*;
import java.util.Scanner;
public class TestAuthor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name ="";
        String email = "";
        char gender = '0';
        System.out.println("Введите имя:");
        if (sc.hasNextLine()) {
            name = sc.nextLine();
        } else {
            System.out.println("Было введено неправильное число");
            System.exit(0);
        }
        System.out.println("Введите почту:");
        if (sc.hasNextLine()) {
            email = sc.nextLine();
        } else {
            System.out.println("Было введено неправильное число");
            System.exit(0);
        }
        System.out.println("Введите пол одним символом м/ж:");
        gender = sc.next().charAt(0);
        Author n1 = new Author(name,email,gender);
        System.out.println(n1);
    }
}
