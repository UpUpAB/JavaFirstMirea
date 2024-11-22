package ru.mirea.task18.third;

import java.util.Scanner;

public class Exception2 {
    Scanner myScanner = new Scanner( System.in);
    public void exceptionDemo() {
        try {
            System.out.print("Enter an integer ");
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e){
            System.out.println("Some problems");
            exceptionDemo();
        } /*catch (NumberFormatException e){
            System.out.println("Wrong input, must be Integer");
            exceptionDemo();
        } catch (ArithmeticException e){
            System.out.println("Attempted division by zero");
            exceptionDemo();
        }*/
    }
    public static void main(String[] args) {
        new Exception2().exceptionDemo();
    }
}
