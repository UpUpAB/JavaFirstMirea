package ru.mirea.task16.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordApplication {

    public static void main(String[] args) {
        // Создаем основное окно
        JFrame frame = new JFrame("Password Verification");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Создаем панель для компонентов
        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Установка SpringLayout для панели
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        // Создаем метки и текстовые поля
        JLabel userLabel = new JLabel("User:");
        JTextField userText = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField(15);

        JButton loginButton = new JButton("Login");

        // Добавляем компоненты на панель
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);

        // Устанавливаем ограничения для компонентов с помощью SpringLayout
        layout.putConstraint(SpringLayout.WEST, userLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, userText, 10, SpringLayout.EAST, userLabel);
        layout.putConstraint(SpringLayout.NORTH, userText, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, passwordLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 10, SpringLayout.SOUTH, userLabel);

        layout.putConstraint(SpringLayout.WEST, passwordText, 10, SpringLayout.EAST, passwordLabel);
        layout.putConstraint(SpringLayout.NORTH, passwordText, 10, SpringLayout.SOUTH, userLabel);

        layout.putConstraint(SpringLayout.WEST, loginButton, 10, SpringLayout.EAST, passwordText);
        layout.putConstraint(SpringLayout.NORTH, loginButton, 10, SpringLayout.SOUTH, passwordText);

        // Обработчик события нажатия на кнопку
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = new String(passwordText.getPassword());

                // Проверка имени пользователя и пароля
                if (user.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(panel, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}