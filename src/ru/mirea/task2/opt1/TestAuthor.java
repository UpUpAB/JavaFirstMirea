package ru.mirea.task2.opt1;

import java.lang.*;
import java.util.Scanner;
public class TestAuthor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = sc.nextLine();
        System.out.println("Введите почту:");
        String email = sc.nextLine();
        System.out.println("Введите пол одним символом м/ж:");
        char gender = sc.next().charAt(0);
        Author n1 = new Author(name,email,gender);
        System.out.println(n1);
    }
}
