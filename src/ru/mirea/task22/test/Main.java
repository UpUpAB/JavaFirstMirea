package ru.mirea.task22.test;

import javax.swing.*;
import java.util.Stack;

// Main.java
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        Stack<Double> op = new Stack<>();
        JTextField tf = new JTextField(" 123 123");
        System.out.println(tf.getText());
        tf.setText("1\s2");
        System.out.println(tf.getText());
    }
}
