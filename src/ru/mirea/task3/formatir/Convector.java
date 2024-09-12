package ru.mirea.task3.formatir;
import java.util.Scanner;


public class Convector {
    private String prevName;
    private String lastName;
    private double value;
    private double ans;
    private static double USD = 91.29;
    private static double EUR = 100.68;
    private static double CNY = 12.82;
    private static double RUB = 1;
    private double first;
    public Convector(String prevName, String lastName, double value, double ans) {
        this.prevName = prevName;
        this.lastName = lastName;
        this.value = value;
        this.ans = ans;
    }
    public Convector() {}



    public void choosePrevCurrency(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите валюту, из которой хотите перевести:");
        System.out.println("RUB\nUSD\nEUR\nCNY\nEXIT");
        prevName=sc.nextLine();
        if (!(prevName.equals("RUB") || prevName.equals("EUR") || prevName.equals("USD") || prevName.equals("CNY")||prevName.equals("EXIT")) ){
            System.out.println("Было введено несуществующее значение");
            choosePrevCurrency();
        }

    }
    public void chooseLastCurrency(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите валюту, в которую хотите перевести:");
        System.out.println("RUB\nUSD\nEUR\nCNY\nEXIT");
        lastName=sc.nextLine();
        if (!(lastName.equals("RUB") || lastName.equals("EUR") || lastName.equals("USD") || lastName.equals("CNY")||lastName.equals("EXIT")) ){
            System.out.println("Было введено несуществующее значение");
            chooseLastCurrency();
        }
    }
    public void valueScan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите сумму, которую хотите перевести:");
        boolean start = false;
        if (sc.hasNextInt()) {
            this.first = sc.nextInt();

        } else {
            System.out.println("Было введено неправильное число");
            start = true;
        }
        if (this.first<0){
            System.out.println("Было введено недопустимое значение, попробуйте ещё раз");
            start = true;
        }
        if (start){
            valueScan();
        }
    }
    public void rubConvector() {
        boolean stay = true;
        while (stay) {
            stay = false;
            switch (prevName) {
                case ("USD"):
                    this.value = first * USD;
                    break;
                case ("EUR"):
                    this.value = first * EUR;
                    break;
                case ("CNY"):
                    this.value = first * CNY;
                    break;
                case ("RUB"):
                    this.value = first * RUB;
                    break;
                case ("EXIT"):
                    System.exit(0);
                default:
                    System.out.println("Было введено неправильное значение валюты, попробуйте ещё раз");
                    choosePrevCurrency();
                    stay = true;
                    break;

            }
        }
    }
    public void curConvector() {
        boolean stay = true;
        while (stay) {
            stay = false;
            switch (lastName) {
                case ("USD"):
                    this.ans = (value / USD);
                    break;
                case ("EUR"):
                    this.ans = (value / EUR);
                    break;
                case ("CNY"):
                    this.ans = (value / CNY);
                    break;
                case ("RUB"):
                    this.ans = (value / RUB);
                    break;
                case ("EXIT"):
                    System.exit(0);
                default:
                    System.out.println("Было введено неправильное значение валюты, попробуйте ещё раз");
                    chooseLastCurrency();
                    stay = true;
                    break;

            }
        }
    }
    public void body(){
        choosePrevCurrency();
        valueScan();
        rubConvector();
        chooseLastCurrency();
        curConvector();
        System.out.printf("%.3f %s ---> %.3f %s",first,prevName,ans,lastName);

    }


    public static void main(String[] args) {
        Convector cn = new Convector();
        Scanner sc = new Scanner(System.in);
        while (true){
            cn.body();
            System.out.print("\nДля выхода напишите 0 для выхода или любой другой символ для продолжения\n");
            if (sc.nextLine().equals("0")){
                break;
            }



        }

    }
}
