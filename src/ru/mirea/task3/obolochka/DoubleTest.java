package ru.mirea.task3.obolochka;
import java.util.*;
import java.util.Scanner;
public class DoubleTest {
    public static void main(String[] args) {
        Double x = Double.valueOf(5);
        Double a = Double.parseDouble("100");
        System.out.println(a);
        double z=x;
        byte b= x.byteValue();
        short s = x.shortValue();
        int i = x.intValue();
        long l = x.longValue();
        float f = x.floatValue();
        boolean b1 = x.isInfinite();
        char c = (char)x.intValue();
        System.out.printf("%f, %d, %d, %d, %d, %f, %b, %c\n",z,b,s,i,l,f,b1,c);
        String d = Double.toString(3.14);
        System.out.println(d+"asdasd");
    }
}
