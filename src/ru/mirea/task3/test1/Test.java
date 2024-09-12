package ru.mirea.task3.test1;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Test {
    public static void main(String args[]){
        Random rand = new Random();
// создаем случ. целые числа в диапазоне 0 to 999
        int rand_int1 =
                ThreadLocalRandom.current().nextInt(0,999);
        int rand_int2 =
                ThreadLocalRandom.current().nextInt();
// печатаем случайные целые числа
        System.out.println("Random Integers: " +
                rand_int1);
        System.out.println("Random Integers: " +
                rand_int2);
// Генерируем рандомно double
        double rand_dub1 =
                ThreadLocalRandom.current().nextDouble();
        double rand_dub2 =
                ThreadLocalRandom.current().nextDouble();
// печатаем случайные целые числа double
        System.out.println("Random Doubles: " +
                rand_dub1);
        System.out.println("Random Doubles: " +
                rand_dub2);
// Генерируем рандомно boolean
        boolean rand_bool1 =
                ThreadLocalRandom.current().nextBoolean();
        boolean rand_bool2 =
                ThreadLocalRandom.current().nextBoolean();
// печатаем случайные числа Boolean
        System.out.println("Random Booleans: " +
                rand_bool1);
        System.out.println("Random Booleans: " +
                rand_bool2);
        int RandInt = rand.nextInt(1000,2000);
        System.out.println(RandInt);
    }
}
