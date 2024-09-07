package ru.mirea.task1.opt3;

import java.util.Scanner;
public class ArraySum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину массива целым числом: ");
        int lenght = 1;
        if (sc.hasNextInt()) {
            lenght = sc.nextInt();
        } else {
            System.out.println("Было введено неправильное число");
            System.exit(0);
        }
        int[] array = new int[lenght];
        int arraySum = 0;
        System.out.println("Введите элементы целочисленного массива: ");
        for (int i = 0; i < lenght; i++){
            if (sc.hasNextInt()) {
                array[i] = sc.nextInt();
                arraySum += array[i];
            } else {
                System.out.println("Было введено неправильное число");
                System.exit(0);
            }
        }
        double mean = (float)arraySum / lenght;
        System.out.format("Сумма элементов целочисленного массива = %d \nСреднее арифметическое его элементов: %.3f", arraySum, mean);

    }
}
