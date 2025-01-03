package ru.mirea.task26.first;

import java.util.Stack;

public class Inventor {
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7};
        Stack<Integer> stack = new Stack<>();
        int size = list.length;
        for (int i =0;i< size;i++){
            stack.push(list[i]);
        }
        for (int i =0; i<(size+1)/2;i++){
            for(int temp:list){
                System.out.print(temp+" ");
            }
            stack.push(list[i]);
            list[size -i - 1] = stack.pop();
            list[i] = stack.pop();

            System.out.println();
        }
        System.out.println();
        for(int temp:list){
            System.out.print(temp+" ");
        }
    }
}
