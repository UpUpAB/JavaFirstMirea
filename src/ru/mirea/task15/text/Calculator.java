package ru.mirea.task15.text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    // Поля
    private JTextField display;
    private String operator;
    private double firstOperand;

    public Calculator() {
        // Установка заголовка и базовых параметров окна
        setTitle("Калькулятор");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создание текстового поля для отображения
        display = new JTextField();
        display.setEditable(false);
        display.setBackground(Color.white);
        add(display, BorderLayout.NORTH);

        // Создание кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Добавление кнопок
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            // Если нажата кнопка числа
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            // Если нажата кнопка "C" (очистка)
            display.setText("");
            operator = "";
            firstOperand = 0;
        } else if (command.equals("=")) {
            // Если нажата кнопка "=" (равно)
            double secondOperand = Double.parseDouble(display.getText());
            double result = calculate(firstOperand, secondOperand, operator);
            display.setText(String.valueOf(result));
            operator = "";
        } else {
            // Если нажата кнопка операции
            if (!operator.isEmpty()) {
                // Если оператор уже установлен, игнорировать
                return;
            }
            firstOperand = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        }
    }

    private double calculate(double first, double second, String operator) {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                if (second != 0) {
                    return first / second;
                } else {
                    // Обработка деления на ноль
                    JOptionPane.showMessageDialog(this, "Ошибка: Деление на ноль");
                    return 0;
                }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        // Создание и отображение калькулятора
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
