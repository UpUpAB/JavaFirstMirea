package ru.mirea.task8.test;

import java.util.Scanner;

public class MonotonicSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number n: ");
        int n = scanner.nextInt();

        int count = 0;
        int currentNumber = 1;
        int currentRepetitions = 1;

        for (int i = 1; count < n; i++) {
            if (currentRepetitions <= currentNumber) {
                System.out.print(currentNumber + " ");
                count++;
                currentRepetitions++;
            } else {
                currentNumber++;
                currentRepetitions = 1;
            }
        }

    }
}