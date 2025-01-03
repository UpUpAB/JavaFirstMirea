package ru.mirea.task23.third;
interface Expression {
    double evaluate(double x);
}

class Const implements Expression {
    private final double value;

    public Const(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(double x) {
        return value;
    }
}

class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(double x) {
        return x;
    }
}

abstract class BinaryOperation implements Expression {
    protected final Expression left;
    protected final Expression right;

    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}

class Add extends BinaryOperation {
    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate(double x) {
        return left.evaluate(x) + right.evaluate(x);
    }
}

class Subtract extends BinaryOperation {
    public Subtract(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate(double x) {
        return left.evaluate(x) - right.evaluate(x);
    }
}

class Multiply extends BinaryOperation {
    public Multiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate(double x) {
        return left.evaluate(x) * right.evaluate(x);
    }
}

class Divide extends BinaryOperation {
    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate(double x) {
        return left.evaluate(x) / right.evaluate(x);
    }
}

public class Main {
    public static void main(String[] args) {
        Expression expression = new Subtract(
                new Add(new Multiply(new Variable("x"), new Variable("x")), new Const(1)),
                new Multiply(new Const(2), new Variable("x"))
        );

        double result = expression.evaluate(3);
        System.out.println("при x = -3: " + result);
    }
}