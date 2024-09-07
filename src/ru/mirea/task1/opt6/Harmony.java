package ru.mirea.task1.opt6;

public class Harmony {
    public static void main(String[] args){
        double harmCounter = 0;
        for (int i = 1; i <= 10; i++){
            harmCounter += 1.0 / i;
            System.out.format("Число гармонического ряда №%d: %.3f\n",i,harmCounter);
        }
    }
}
