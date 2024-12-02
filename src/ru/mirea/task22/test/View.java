package ru.mirea.task22.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// View.java
public class View {
    private JFrame frame;
    private JTextField firstOperandField;
    private JTextField secondOperandField;
    private JTextField resultField;
    private JComboBox<String> operatorBox;
    private JButton calculateButton;

    public View() {
        frame = new JFrame("Калькулятор");
        firstOperandField = new JTextField(10);
        secondOperandField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);
        String[] operators = {"+", "-", "*", "/"};
        operatorBox = new JComboBox<>(operators);
        calculateButton = new JButton("Вычислить");

        JPanel panel = new JPanel();
        panel.add(firstOperandField);
        panel.add(operatorBox);
        panel.add(secondOperandField);
        panel.add(calculateButton);
        panel.add(resultField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public String getFirstOperand() {
        return firstOperandField.getText();
    }

    public String getSecondOperand() {
        return secondOperandField.getText();
    }

    public String getOperator() {
        return (String) operatorBox.getSelectedItem();
    }

    public void setResult(double result) {
        resultField.setText(Double.toString(result));
    }

    public void addCalculateListener(ActionListener listenForCalculateButton) {
        calculateButton.addActionListener(listenForCalculateButton);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
}