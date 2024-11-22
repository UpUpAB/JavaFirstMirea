package ru.mirea.task15.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Calculator extends JFrame {
    JPanel[] panel = new JPanel[2];
    JTextField display = new JTextField(30);
    JMenuBar menuBar = new JMenuBar();
    JMenuItem menuItem = new JMenuItem("Clear");


    String a = "", b = "", operation = "";
    ActionListener displayCalculation = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());

            String s = e.getActionCommand();
            Calculation(s);
            panel[0].requestFocusInWindow();

        }
    };
    KeyAdapter keyCalculations = new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            System.out.println(KeyEvent.getKeyText(code));
            if(e.isShiftDown()){
                switch (code){
                    case KeyEvent.VK_8 -> Calculation("*");
                    case KeyEvent.VK_EQUALS -> Calculation("+");
                }
            } else {
                if ((code>=45 && code<= 57)){
                    Calculation(KeyEvent.getKeyText(code));
                } else {
                    switch (code) {
                        case 61 -> Calculation("+");
                        case 10 -> Calculation("=");
                    }
                }

            }
        }
/*
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SHIFT) isShiftPressed = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }*/
    };

    private void Calculation(String s){
        if (s.charAt(0)>='0' && s.charAt(0)<='9'){
            if (operation.isEmpty()){
                if (a.length()<=10) a = a + s;

            } else {
                if(b.length()<=10) b = b + s;
            }
            display.setText(a + operation + b);
        } else if (s.charAt(0) == '=' && !b.isEmpty()){
            try{
                if (operation.equals("/")&&b.equals("0")) throw new ArithmeticException();
                switch (operation){
                    case "+" -> a = String.valueOf( Double.parseDouble(a) + Double.parseDouble(b));
                    case "-" -> a = String.valueOf( Double.parseDouble(a) - Double.parseDouble(b));
                    case "/" -> a = String.valueOf( Double.parseDouble(a) / Double.parseDouble(b));
                    case "*" -> a = String.valueOf( Double.parseDouble(a) * Double.parseDouble(b));
                    default -> display.setText("Введите арифметическую операцию");
            }
            //if (a.length()>=10 && a.contains(".")) a=a.substring(0,10);
            if (a.length()>=10){
                int temp = a.indexOf(".")+1;
                while (true){
                    if (a.contains("E")) break;
                    if(a.charAt(temp) != '0'){
                        if (temp <= 10){
                            a=a.substring(0,10);
                            break;
                        } else {
                            a=a.substring(0,temp);
                            break;
                        }

                    } else {
                        temp+=1;
                    }
                }
            }
            display.setText(a);
            operation = b ="";
            } catch (ArithmeticException e){
                display.setText("Так нельзя");
                b="";
            }
        } else if (s.charAt(0) == '.'){
            if (operation.isEmpty()){
                if (a.length()<10 && !a.contains(".") && !a.isEmpty()) a = a + s;

            } else {
                if(b.length()<10 && !b.contains(".") && !b.isEmpty()) b = b + s;
            }
            display.setText(a+operation+b);
        } else {
            if (operation.isEmpty() && s.charAt(0) != '=' && a.charAt(a.length()-1) != '.'){
                operation = s;
            }
            display.setText(a+operation+b);
        }
    }

    public Calculator(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        setJMenuBar(menuBar);
        menuBar.add(menuItem);
        display.setEditable(false);

        menuItem.addActionListener(e -> {
            display.setText("");
            a = operation = b = "";
        });
        menuItem.setBackground(Color.GRAY);

        /*menuItem.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                menuItem.setBackground(Color.GRAY); // Меняем фон при наведении
            }
            public void mouseExited(MouseEvent evt) {
                menuItem.setBackground(Color.LIGHT_GRAY); // Возвращаем фон при выходе
            }});*/


        panel[0] = new JPanel();
        panel[0].setLayout(new GridLayout(2,1));
        panel[0].add(display);
        panel[0].add(new Label());
        panel[0].setFocusable(true);
        panel[0].addKeyListener(keyCalculations);


        panel[1] = new JPanel();
        panel[1].setLayout(new GridLayout(4,4));
        panel[1].setBackground(Color.GRAY);
        buttonsDeclaration();

        add(panel[0]);
        add(panel[1]);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void buttonsDeclaration(){
        JButton[] buttons = new JButton[16];
        String[] buttonStr = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };
        for (int i =0;i<buttons.length;i++) {
            buttons[i] = new JButton(buttonStr[i]);
            buttons[i].addActionListener(displayCalculation);
            panel[1].add(buttons[i]);
        }

    }

    public static void main(String[] args) {
        new Calculator();
    }
}
