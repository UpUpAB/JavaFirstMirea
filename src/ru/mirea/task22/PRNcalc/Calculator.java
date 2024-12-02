package ru.mirea.task22.PRNcalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

class CalculatorModel{
    Stack<Double> operands = new Stack<>();

    public void addOperand(Double d){
        operands.push(d);
    }
    public double showEl(){
        return operands.peek();
    }
    public int size(){
        return operands.size();
    }


    public void calculation(String s){
        if(operands.peek() == 0 && s.charAt(0)=='/'){
            throw new ArithmeticException();
        } else {
            Double temp = operands.pop();
            switch (s){
               case "+" -> operands.push( operands.pop() + temp);
               case "-" -> operands.push( operands.pop() - temp);
               case "/" -> operands.push( operands.pop() / temp);
               case "*" -> operands.push( operands.pop() * temp);
            }
        }


    }
}
class CalculatorView extends JFrame {
    JTextField display = new JTextField(30);
    JPanel[] panel = new JPanel[2];
    JButton[] buttons = new JButton[16];
    JPanel helpButtonsPanel = new JPanel(new GridLayout(1,2));
    JButton clearButton = new JButton("Clear");
    JButton spaceButton = new JButton("Space");




    public CalculatorView(){
        this.setTitle("После каждого числа вводите пробел!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        display.setEditable(false);

        helpButtonsPanel.add(clearButton);
        helpButtonsPanel.add(spaceButton);
        helpButtonsPanel.setBackground(Color.GRAY);

        panel[0] = new JPanel();
        panel[0].setLayout(new GridLayout(2,1));
        panel[0].add(display);
        panel[0].add(helpButtonsPanel);
        panel[0].setFocusable(true);
        //panel[0].addKeyListener(keyCalculations); - добавил


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
        String[] buttonStr = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };
        for (int i =0;i<buttons.length;i++) {
            buttons[i] = new JButton(buttonStr[i]);
            //buttons[i].addActionListener(displayCalculation); - добавил
            panel[1].add(buttons[i]);
        }

    }
    public void addButtonsAction(ActionListener actionListener){
        for (int i =0;i<buttons.length;i++) {
            buttons[i].addActionListener(actionListener);
        }
        clearButton.addActionListener(actionListener);
        spaceButton.addActionListener(actionListener);
    }
    public void requestFocusForKeyboard(){
        panel[0].requestFocusInWindow();
    }
    public void addKeyboardController(KeyAdapter keyAdapter){
        panel[0].addKeyListener(keyAdapter);
    }
    public void setDisplayText(String s){
        display.setText(display.getText() + s );
    }
    public String getDisplayText(){
        return display.getText();
    }
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public void addDisplayMouseListener(MouseAdapter mouseAdapter){
        display.addMouseListener(mouseAdapter);
    }
}
class CalculatorController{
    private CalculatorModel model;
    private CalculatorView view;
    private String a ="";
    ActionListener displayCalculation = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            String s = e.getActionCommand();
            input(s);
            view.requestFocusForKeyboard();
        }
    };
    MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            view.requestFocusForKeyboard();
        }
    };
    KeyAdapter keyCalculation = new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            System.out.println(KeyEvent.getKeyText(code));
            if(e.isShiftDown()){
                switch (code){
                    case KeyEvent.VK_8 -> input("*");
                    case KeyEvent.VK_EQUALS -> input("+");
                }
            } else {
                if ((code>=45 && code<= 57)){
                    input(KeyEvent.getKeyText(code));
                } else {
                    switch (code) {
                        case 61 -> input("+");
                        case 10 -> input("=");
                        case 8 -> input("Clear");
                        case 32 -> input("Space");
                    }
                }
            }

        }
    };

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        view.addButtonsAction(displayCalculation);
        view.addKeyboardController(keyCalculation);
        view.addDisplayMouseListener(mouseAdapter);
    }
    public void input(String s){
        if (s.charAt(0)>='0' && s.charAt(0)<='9'){
            if (a.length()<=10){
            a=a+s;
            view.setDisplayText(s);
            }
        } else if (s.charAt(0) == 'C'){
            a="";
            view.display.setText("");
            model.operands.clear();
        } else if (s.charAt(0) == 'S'){
            String tmp = view.getDisplayText();
            if (tmp.charAt(tmp.length()-1) != ' '){
            if (!a.isEmpty()) model.addOperand(Double.parseDouble(a));
            a = "";
            view.setDisplayText(" ");
            }
            //System.out.println(view.display.getText());
        } else if (model.size()>1&&
                (s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/')) {
            try{
                model.calculation(s);
                a="";
                view.setDisplayText(s);
            } catch (ArithmeticException e){
                view.showError("Нельзя делить на 0");
                System.out.println(model.operands);
            }

        } else if (s.charAt(0) == '='){
            a = String.valueOf(model.operands.pop());
            if (Double.parseDouble(a) % 1 == 0) { //ОБЯЗАТЕЛЬНО ПОКАЗАТЬ УМНОЕ ФОРМАТИРОВАНИЕ
                a = a.substring(0,a.indexOf("."));
            } else {
                System.out.println("Попал");
                if (!a.contains("E") && a.length()>=10){
                    String temp = a.substring(0,a.indexOf(".")+1);
                    temp = String.valueOf(10-temp.length());
                    a = String.format("%."+temp+"f",Double.parseDouble(a));
                    a= a.replace(",",".");
                }
            }

            view.display.setText(a);
        } else if(s.charAt(0) == '.'){
            if (a.length()<10 && !a.contains(".") && !a.isEmpty()) {
                a = a + s;
                view.setDisplayText(s);
            }
        }
    }

}
public class Calculator {
    public static void main(String[] args) {
        CalculatorModel clm = new CalculatorModel();
        CalculatorView clv = new CalculatorView();
        CalculatorController cc = new CalculatorController(clm,clv);
    }
}
