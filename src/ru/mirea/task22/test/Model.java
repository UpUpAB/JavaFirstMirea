package ru.mirea.task22.test;

// Model.java
public class Model {
    private double result;
    private String operator;
    private double firstOperand;

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate(double secondOperand) {
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    throw new ArithmeticException("Деление на ноль!");
                }
                break;
            default:
                throw new UnsupportedOperationException("Операция не поддерживается");
        }
        return result;
    }
}