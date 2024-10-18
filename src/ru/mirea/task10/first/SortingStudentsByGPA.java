package ru.mirea.task10.first;

import java.util.*;

/*Напишите класс SortingStudentsByGPA (может у вас называться
Tester или Main, так как содержит функцию main()) создайте поле как
массив объектов Student с названием iDNumber, вы можете использовать
как массив, так и и ArrayList или TreeSet для хранения данных о студентах
Добавьте методы класса:
1) заполнения массива setArray()
2) метод для сортировки по среднему баллу студентов quicksort() который реализует
интерфейс Comparator таким образом, чтобы он сортировал студентов с их
итоговым баллом в порядке убывания. В качестве алгоритма сортировки
использовать методы сортировок: слиянием и быструю сортировку
(добавьте в класс еще один метод).
3)метод для вывода массива студентов
outArray()
4)Добавьте в класс возможность сортировать список студентов по другому
полю*/
public class SortingStudentsByGPA {
    Comparator<Student> studentComparator = new StudentGPAComparator().thenComparing(new StudentNameComparator());
    List<Student> iDNumber = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    List<Student> secondOne = new ArrayList<>();

//ввод----------------------------------------------------------------------------------
    public void setArray(){
        System.out.println("Для окончания ввода данных введите N, или Y чтобы продолжить (когда попросят)");

        String name;
        String surname;
        String speciality;
        int course;
        String group;
        while (true){
            System.out.println("Введите имя студента");

            name = setString();
            System.out.println("Введите фамилию студента");

            surname = setString();
            System.out.println("Введите специальность студента");

            speciality = setString();
            System.out.println("Введите цифрой курс студента(1-8)");

            course = setCourse();
            System.out.println("Введите группу студента");
            scanner.nextLine();
            group = setString();
            iDNumber.add(new Student(name,surname,speciality,course,group));
            System.out.println("Хотите окончить ввод? y/n");
            if(setChar()=='y'){
                break;
            }
        }
    }
    private String setString(){
        String string;
        try{
            string = scanner.nextLine();
            if (string == null || string.trim().isEmpty()) throw new Exception();
        }catch (InputMismatchException e){
            System.out.println("Что-то неверно со входным значением");
            return setString();
        } catch (Exception e) {
            System.out.println("Введена нулевая или пустая строка");
            return setString();
        }
        return string;
    }
    private char setChar(){
        char input;
        String inputString;
        try {
            inputString = scanner.nextLine();
            if (inputString == null || inputString.trim().isEmpty()) throw new InputMismatchException();
            input=inputString.charAt(0);
            if(!(input == 'y') && !(input == 'n')) throw new InputMismatchException();

        } catch (InputMismatchException e){
            System.out.println("Было введено непонятное значение, принимается только y/n");
            return setChar();
        }
        return input;
    }
    private int setCourse(){
        int number;
        try {
            number = scanner.nextInt();
            if(number<1||number>8) throw new Exception();
        } catch (InputMismatchException e){
            System.out.println("Было введено не натуральное число");
            scanner.nextLine();
            return setCourse();
        } catch (Exception e){
            System.out.println("Было введено значение не из диапазона");
            scanner.nextLine();
            return setCourse();
        }
        return number;
    }
    private int setGrade(){
        int number;
        try {
            number = scanner.nextInt();
            if(number<0||number>100) throw new Exception();
        } catch (InputMismatchException e){
            System.out.println("Было введено не натуральное число");
            scanner.nextLine();
            return setCourse();
        } catch (Exception e){
            System.out.println("Было введено значение не из диапазона");
            scanner.nextLine();
            return setCourse();
        }
        return number;
    }
    public void setStGr(){
        for (int i =0;i<iDNumber.size();i++){
            System.out.println("Введите оценку студента "+iDNumber.get(i).getName()+" "+iDNumber.get(i).getSurname()+" с ID "+i);
            iDNumber.get(i).setGpa(setGrade());
        }
    }
    //сортировка вставками--------------------------------------------------------------------------------
    public void insertion(List<Student> list){
        for (int i =0;i< list.size();i++){
            Student value = list.get(i);
            int j = i-1;
            for (;j>=0;j--){
                if (studentComparator.compare(value,list.get(j))>0){
                    list.set(j+1,list.get(j));
                } else {
                    break;
                }
            }
            list.set(j+1,value);
        }
    }
    //быстрая сортировка-------------------------------------------------------------------------------------------
    public void quick(List<Student> list){
        quickSort(list,0,list.size()-1);
    }

    private void quickSort(List<Student> arr, int low, int high) {
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
            if (studentComparator.compare(arr.get(j), pivot)>0) {
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
    //вывод-----------------------------------------------------------------------
    public void outArray(List<Student> list){
        for (Student l : list){
            System.out.println(l.getName()+" "+l.getGpa());
        }
        System.out.println(" ");
    }
    //объединение листов--------------------------------------
    public void mergeArray(List<Student>list1,List<Student>list2){
        list1.addAll(list2);
        quick(list1);
        outArray(list1);
    }

    public SortingStudentsByGPA(){
        secondOne.add(new Student("vova","first","prog",3,"KVBO",10));
        secondOne.add(new Student("vika","second","prog",3,"KVBO",10));
        secondOne.add(new Student("artem","third","prog",3,"KVBO",99));

        setArray();
        System.out.println(iDNumber.toString());
        setStGr();
        System.out.println(iDNumber.toString());
        insertion(secondOne);
        outArray(secondOne);
        quick(iDNumber);
        outArray(iDNumber);
        mergeArray(iDNumber,secondOne);
    }

    public static void main(String[] args) {
        new SortingStudentsByGPA();
    }
}
