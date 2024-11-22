package ru.mirea.task16.third;

import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordApplication extends JFrame {
    private SpringLayout layout = new SpringLayout();
    JPanel panel = new JPanel();

    JLabel service = new JLabel("Service:",JLabel.TRAILING);
    JTextField serviceText = new JTextField(15);

    JLabel userName = new JLabel("User:",JLabel.TRAILING);
    JTextField userNameText = new JTextField(15);

    JLabel password = new JLabel("Password:",JLabel.TRAILING);
    JTextField passwordText = new JTextField(15);

    JButton loginButton = new JButton("Login");

    public PasswordApplication(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        panel.setLayout(layout);

        panel.add(service);
        panel.add(serviceText);
        panel.add(userName);
        panel.add(userNameText);
        panel.add(password);
        panel.add(passwordText);
        setPlaces();
        buttonDeclaration();


        add(panel);
        setLocationRelativeTo(null);

        setVisible(true);
    }
    private void setPlaces(){

        layout.putConstraint(SpringLayout.NORTH, serviceText,10 ,SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, serviceText,-10 ,SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.WEST, serviceText,100 ,SpringLayout.WEST, panel);

        layout.putConstraint(SpringLayout.EAST, service,-5 ,SpringLayout.WEST, serviceText);
        layout.putConstraint(SpringLayout.NORTH, service,15 ,SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.NORTH, userNameText,10 ,SpringLayout.SOUTH, serviceText);
        layout.putConstraint(SpringLayout.EAST, userNameText,-10 ,SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.WEST, userNameText,100 ,SpringLayout.WEST, panel);

        layout.putConstraint(SpringLayout.EAST, userName,-5 ,SpringLayout.WEST, userNameText);
        layout.putConstraint(SpringLayout.NORTH, userName,20 ,SpringLayout.SOUTH, service);

        layout.putConstraint(SpringLayout.NORTH, passwordText,10 ,SpringLayout.SOUTH, userNameText);
        layout.putConstraint(SpringLayout.EAST, passwordText,-10 ,SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.WEST, passwordText,100 ,SpringLayout.WEST, panel);

        layout.putConstraint(SpringLayout.EAST, password,-5 ,SpringLayout.WEST, passwordText);
        layout.putConstraint(SpringLayout.NORTH, password,20 ,SpringLayout.SOUTH, userName);

        layout.putConstraint(SpringLayout.EAST, loginButton,-5 ,SpringLayout.WEST, passwordText);
        layout.putConstraint(SpringLayout.NORTH, loginButton,20 ,SpringLayout.SOUTH, password);

    }

    private void buttonDeclaration(){
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String service = serviceText.getText();
                String user = userNameText.getText();
                String password = new String(passwordText.getText());

                // Проверка имени пользователя и пароля
                if (user.equals("admin") && password.equals("password") && service.equals("edu")) {
                    JOptionPane.showMessageDialog(panel, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);
    }

    public static void main(String[] args) {
        new PasswordApplication();
    }
}
