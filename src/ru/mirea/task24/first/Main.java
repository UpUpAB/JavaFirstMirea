package ru.mirea.task24.first;
class Complex{
    public int real;
    public int image;

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Complex = "+real+"+"+image+"i";
    }
}
interface ComplexAbstractFactory{
    public Complex createComplex();
    public Complex createComplex(int real, int image);
}
class ConcreteFactory implements ComplexAbstractFactory{
    @Override
    public Complex createComplex() {
        return new Complex(0,0);
    }

    @Override
    public Complex createComplex(int real, int image) {
        return new Complex(real, image);
    }
}
public class Main {
    public static void main(String[] args) {
        ComplexAbstractFactory cf = new ConcreteFactory();
        Complex c = cf.createComplex();
        Complex c2 = cf.createComplex(1,2);
        System.out.println(c);
        System.out.println(c2);
    }
}
