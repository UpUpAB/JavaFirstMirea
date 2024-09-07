package ru.mirea.task1.opt4;

import java.util.Scanner;

public class ShowArgs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину массива целым числом: ");
        int lenght=0;
        int sum1 = 0;
        int sum2 = 0;
        int max = -999;
        int min = 999;
        if (sc.hasNextInt()) {
            lenght = sc.nextInt();
        } else {
            System.out.println("Было введено неправильное число");
            System.exit(0);
        }
        int[] array = new int[lenght];

        System.out.println("Введите элементы целочисленного массива: ");
        for (int i = 0; i < lenght; i++) {
            if (sc.hasNextInt()) {
                array[i] = sc.nextInt();

                if (array[i] > max){
                    max = array[i];
                }

                if (array[i] < min){
                    min = array[i];
                }

            } else {
                System.out.println("Было введено неправильное число");
                System.exit(0);
            }
        }

        int i = 0;
        while (i < lenght){
            sum1 += array[i];
            i++;
        }
        i = 0;
        do {
            sum2 += array[i];
            i++;
        } while (i < lenght);

        System.out.format("Сумма массива через цикл do-while: %d\n" +
                "Сумма массива через цикл while: %d\n" +
                "Минимальный элемент:%d\n" +
                "Максимальный элемент:%d",sum2, sum1,min,max);
    }
}
