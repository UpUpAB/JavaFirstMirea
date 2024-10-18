package ru.mirea.task11.second;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DateCompare {
    public static Scanner scanner = new Scanner(System.in);
    //на отрицательное значение не проверяю, т.к. это будет отсчёт года до рождения Христа
    public static int setYear(){
        System.out.println("Введите год (числом)");
        int number;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Было введено не натуральное число");
            scanner.nextLine();
            return setYear();
        }
        return number;
    }
    private static int setMonth(){
        System.out.println("Введите месяц (числом)");
        int number;
        try {
            number = scanner.nextInt();
            if(number<1||number>12) throw new Exception();
        } catch (InputMismatchException e){
            System.out.println("Было введено не натуральное число");
            scanner.nextLine();
            return setMonth();
        } catch (Exception e){
            System.out.println("Такого месяца не существует");
            scanner.nextLine();
            return setMonth();
        }
        return number;
    }
    private static int setDay(int year,int month){
        System.out.println("Введите день (числом)");
        int number;
        try {
            number = scanner.nextInt();
            if((year % 4 == 0)&&(month == 2)){
                if(number<1||number>29) throw new Exception();
            } else if (month == 2){
                if(number<1||number>28) throw new Exception();
            }

            if (month<8){
                if (month % 2 == 0){
                    if(number<1||number>30) throw new Exception();
                } else {
                    if(number<1||number>31) throw new Exception();
                }
            } else {
                if (month % 2 == 0){
                    if(number<1||number>31) throw new Exception();
                } else {
                    if(number<1||number>30) throw new Exception();
                }
            }

        } catch (InputMismatchException e){
            System.out.println("Было введено не натуральное число");
            scanner.nextLine();
            return setDay(year,month);
        } catch (Exception e){
            System.out.println("Такого дня в месяце не существует");
            scanner.nextLine();
            return setDay(year,month);
        }
        return number;
    }
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int yearInput = setYear();
        int monthInput = setMonth();
        int dayInput = setDay(yearInput,monthInput);

        if (yearInput==year){
            if (monthInput==month){
                if(day==dayInput){
                    System.out.printf("Ваша дата %02d-%02d-%d совпадает с нынешней %02d-%02d-%d",dayInput,monthInput,yearInput,day,month,year);
                } else if(day<dayInput){
                    System.out.printf("Ваша дата %02d-%02d-%d позже нынешней %02d-%02d-%d",dayInput,monthInput,yearInput,day,month,year);
                } else {
                    System.out.printf("Ваша дата %02d-%02d-%d раньше нынешней %02d-%02d-%d",dayInput,monthInput,yearInput,day,month,year);
                }
            }else if(month<monthInput){
                System.out.printf("Ваша дата %02d-%02d-%d позже нынешней %02d-%02d-%d",dayInput,monthInput,yearInput,day,month,year);
            } else {
                System.out.printf("Ваша дата %02d-%02d-%d раньше нынешней %02d-%02d-%d",dayInput,monthInput,yearInput,day,month,year);
            }
        } else if(year < yearInput){
            System.out.printf("Ваша дата %02d-%02d-%d позже нынешней %02d-%02d-%d",dayInput,monthInput,yearInput,day,month,year);
        } else {
            System.out.printf("Ваша дата %02d-%02d-%d раньше нынешней %02d-%02d-%d",dayInput,monthInput,yearInput,day,month,year);
        }
    }
}
