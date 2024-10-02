package ru.mirea.task7.fifth;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StringFunc implements StringWork{
    private String oldS;
    private char[] oldC;
    private char[] newC;
    private String newS="";
    private int n=0;

    public StringFunc(String oldS) {
        this.oldS = oldS;
        oldC = oldS.toCharArray();
        count();
    }

    @Override
    public int count() {
        n=0;
        for (char s:oldC){
            n++;
        }
        return n;
    }

    @Override
    public String getNewString() {
        newS="";
        for (int i=1;i<n;i=i+2){
            newS=newS.concat(String.valueOf(oldC[i]));
        }
        return newS;
    }

    @Override
    public String getInvert() {
        newC = new char[n];
        int i = count();
        for(char c:oldC){
            i--;
            newC[i]=c;
        }
        newS="";
        newS = newS.concat(String.valueOf(newC));
        return newS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        try{
            s = scanner.nextLine();
        } catch (InputMismatchException e){
            System.out.println("Неверное значение. Попробуйте ещё раз");
        }
        StringWork s1 = new StringFunc(s);
        System.out.println(s1.count());
        System.out.println(s1.getNewString());
        System.out.println(s1.getInvert());
    }
}
