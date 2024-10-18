package ru.mirea.task9.second;

import ru.mirea.task9.second.Student;

import java.util.*;


public class TestClass{
    List<Student> group= new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Comparator ssbg = new SortingStudentsByGPA();
    int n;

    //сортировка
    public void quickSort(List<Student> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    private int partition(List<Student> arr, int low, int high) {
        Student pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (ssbg.compare(arr.get(j), pivot)>0) {
                i++;


                Student temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
            }
        }
        Student temp = arr.get(i + 1);
        arr.set(i + 1,arr.get(high));
        arr.set(high,temp);
        return i + 1;
    }


    //ввод -------------------------------------------------------------------------------
    public void setGroup(){
        System.out.println("Введите количество студентов в группе");
        n = setNum();
        for (int i =0;i<n;i++){
            group.add(new Student(setName(),setGrade()));
        }
    }
    public int setNum(){
        int num;
        try {
            num = scanner.nextInt();
            if(num<0||num>100) throw new Exception();
        } catch (InputMismatchException e){
            System.out.println("Было введено не натуральное число");
            scanner.nextLine();
            return setNum();
        } catch (Exception e){
            System.out.println("Было введено значение не из диапазона");
            scanner.nextLine();
            return setNum();
        }
        return num;
    }

    public int setGrade(){
        System.out.println("Введите оценку натуральными числом от 0 до 100");
        return setNum();
    }
    public String setName(){
        System.out.println("Введите имя студента");
        String name;
        scanner.nextLine();
        try {
            name = scanner.nextLine();
        } catch (Exception e){
            System.out.println("Как это вообще получилось");
            return setName();
        }
        return name;
    }
    //----------------------------------------------------------------------------

    public TestClass(){
        setGroup();
        quickSort(group,0,n-1);
        System.out.println(group.toString());
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
    }
}
