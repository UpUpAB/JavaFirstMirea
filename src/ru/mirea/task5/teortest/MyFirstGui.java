package ru.mirea.task5.teortest;
//пример из теории
import javax.swing.*;
public class MyFirstGui {
    public static void main(String[] args) {
        //создаем фрейм окна с помощью конструктора
        //Конструктор берет параметр – назаъвание окна – это строка
        JFrame frame = new JFrame("My First GUI");
        // устанавливаем реакцию окна на закрытие по умолчанию
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //задаем свойства окна – его размеры в пискселях
        frame.setSize(300,300);
        //создаем кнопку с помощью конструктора класса JButton
        //конструктор берет параметр строку – название на кнопке
        JButton button = new JButton("Press");
        //добавляем кнопку ук окну
        frame.getContentPane().add(button);
        //делаем окно видимым
        frame.setVisible(true);
    }

}
