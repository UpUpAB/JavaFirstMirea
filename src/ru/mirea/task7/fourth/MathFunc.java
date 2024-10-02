package ru.mirea.task7.fourth;

public class MathFunc implements MathCalculable{
    private double x;
    private int p;

    public MathFunc(double x) {
        this.x = x;
    }

    @Override
    public double getPow(int p) {
        this.p=p;
        double power=1;
        for (int i=0;i<p;i++){
            power=power*x;
        }
        x=power;
        return x;
    }

    @Override
    public double getAbs() {
        if (x>=0){
            return x;
        } else {
            return -x;
        }
    }
    public double lenght(){
        return 2*PI*x;
    }

    public static void main(String[] args) {
        MathCalculable m1 = new MathFunc(-10);
        System.out.println(m1.getPow(3));
        System.out.println(m1.getAbs());
        MathFunc m2 = new MathFunc(5.0);
        System.out.println(m2.lenght());
    }
}
