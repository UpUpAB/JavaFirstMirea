package ru.mirea.task11.first;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        String surname = "Mezentsev";
        String dateTaskRecived = "23-09-2024 12:30:49";
        Date dateTaskSubmitted = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        System.out.println("Фамилия разработчика: "+surname);
        System.out.println("Дата и время выдачи задания: "+ dateTaskRecived);
        System.out.println("Дата и время сдачи задания: "+dateFormat.format(dateTaskSubmitted));
    }
}
