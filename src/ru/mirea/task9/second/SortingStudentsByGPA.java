package ru.mirea.task9.second;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGrade()- o2.getGrade();
    }
    /*
    public void quickSort (List<Student> arr,int low,int high){
        if (low<high){
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    private int partition(List<Student> arr,int low,int high){
        Student pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(arr.get(j), pivot)<0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    private void swap(List<Student> arr,int i, int j){
        Student temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    public SortingStudentsByGPA(List<Student> arr) {
        quickSort(arr,1,arr.size());
        System.out.println(arr.toString());
    }
     */
}
