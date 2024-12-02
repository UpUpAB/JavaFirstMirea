package ru.mirea.task22.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controller.java
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        this.view.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double firstOperand = Double.parseDouble(view.getFirstOperand());
                double secondOperand = Double.parseDouble(view.getSecondOperand());
                String operator = view.getOperator();

                model.setFirstOperand(firstOperand);
                model.setOperator(operator);
                double result = model.calculate(secondOperand);
                view.setResult(result);
            } catch (NumberFormatException ex) {
                view.showError("Пожалуйста, введите корректные числа!");
            } catch (ArithmeticException ex) {
                view.showError(ex.getMessage());
            } catch (UnsupportedOperationException ex) {
                view.showError(ex.getMessage());
            }
        }
    }
}
