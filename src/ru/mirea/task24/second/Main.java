package ru.mirea.task24.second;
interface Chair{}
class FunctionalChair implements Chair{
    public int sum(int a,int b){
        return a+b;
    }
}
class MagicChair implements Chair{
    public void doMagic(){
        System.out.println("Магия сделана");
    }
}
class VictorianChair implements Chair{
    private int age;
    public int getAge(){
        return age;
    }

    public VictorianChair(int age) {
        this.age = age;
    }
}

interface AbstractChairFactory{
    public FunctionalChair createFunctionalChair();
    public VictorianChair createVictorianChair(int age);
    public MagicChair createMagicChair();
}
class ChairFactory implements AbstractChairFactory{
    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }

    @Override
    public VictorianChair createVictorianChair(int age) {
        return new VictorianChair(age);
    }

    @Override
    public MagicChair createMagicChair() {
        return new MagicChair();
    }
}
class Client{
    public Chair chair;
    public void sit(){
        System.out.println(chair);
    }
    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
public class Main {
    public static void main(String[] args) {
        ChairFactory cf = new ChairFactory();
        Client client = new Client();
        client.setChair(cf.createMagicChair());
        client.sit();
    }

}
