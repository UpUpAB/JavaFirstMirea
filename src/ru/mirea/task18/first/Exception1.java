package ru.mirea.task18.first;

public class Exception1 {
    public void exceptionDemo() {
        try{
            System.out.println( 2/0 );
        } catch ( ArithmeticException e ) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
       new Exception1().exceptionDemo();
    }
}
