package ru.mirea.task20.fourth;

import java.util.Arrays;

public class MinMax<E>{
    private E[] list;
    private E min;
    private E max;

    public MinMax(E[] list) {
        this.list = list;
        minMax();
    }
    private void minMax(){
        min = max = list[0];
        for (int i =1; i< list.length; i++){
            if(min.toString().compareTo(list[i].toString())<0){
                E temp = min;
                min = list[i];
                list[i] = min;
            }
            if(max.toString().compareTo(list[i].toString())>0){
                E temp = max;
                max = list[i];
                list[i] = max;
            }
        }
    }

    @Override
    public String toString() {
        return "MinMax{" +
                "list=" + Arrays.toString(list) +
                ", max=" + max +
                ", min=" + min +
                '}';
    }

    public static void main(String[] args) {
        String[] list1 = {"qweq","asd","123"};
        Integer[] list2 = {1,3,2,4,1};
        MinMax<String> mn1 = new MinMax<>(list1);
        System.out.println(mn1);
        MinMax<Integer> mn2 = new MinMax<>(list2);
        System.out.println(mn2);
    }
}
