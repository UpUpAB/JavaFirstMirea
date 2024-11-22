package ru.mirea.task16.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialogExample {

    public static void main(String[] args) {
        // Создаем и отображаем диалоговое окно для входа
        JFrame frame = new JFrame("Login Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Создаем панель для компонентов
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Создаем GroupLayout и устанавливаем его для панели
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Создаем метки и текстовые поля
        JLabel userLabel = new JLabel("User:");
        JTextField userText = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField(20);

        JButton loginButton = new JButton("Login");

        // Устанавливаем вертикальное и горизонтальное размещение компонентов
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(userLabel)
                        .addComponent(userText))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(passwordLabel)
                        .addComponent(passwordText))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginButton))
        );

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(userLabel)
                        .addComponent(passwordLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(userText)
                        .addComponent(passwordText)
                        .addComponent(loginButton))
        );

        // Обработчик события нажатия на кнопку
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = new String(passwordText.getPassword());

                // Здесь можно добавить проверку пользователя и пароля
                if (user.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(panel, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}