package ru.mirea.task3.opt2try2;

import java.util.Random;
import java.util.Comparator;
import java.util.Arrays;

public class Tester {
    private Circle[] cr;
    private int n;

    public Tester(Circle[] cr, int n) {
        this.cr = cr;
        this.n = n;
        iniz();
    }

    public void iniz(){
        Random rand = new Random();
        for ( int i=0; i<n; i++){
            double x = rand.nextDouble(10);
            double y = rand.nextDouble(10);
            double r = rand.nextDouble(10);
            cr[i] = new Circle(new Point(x,y),r);
        }
    }

    public Circle[] getCr() {
        return cr;
    }

    public Circle getSmallest(){
        return Arrays.stream(cr).min(Comparator.comparingDouble(Circle::getR)).orElse(null);
    }

    public Circle getLargest(){
        return Arrays.stream(cr).max(Comparator.comparingDouble(Circle::getR)).orElse(null);
    }

    public Circle[] getSort(){
        Circle[] sortedCr = Arrays.copyOf(cr,n);
        Arrays.sort(sortedCr,Comparator.comparing(Circle::getR));
        return sortedCr;
    }

    public static void main(String[] args) {
        int n = 5;
        Circle[] cr = new Circle[n];
        Tester test = new Tester(cr,n);
        Circle[] unsort = test.getCr();
        Circle smallest = test.getSmallest();
        Circle largest = test.getLargest();
        Circle[] sorted = test.getSort();
        System.out.println(Arrays.toString(unsort));
        System.out.println(Arrays.toString(sorted));
        System.out.println(smallest.toString());
        System.out.println("Длина наименьшей окружности: "+smallest.getPerimetr());
        System.out.println(largest.toString());
        System.out.println("Длина наибольшей окружности: "+largest.getPerimetr());

    }

}
