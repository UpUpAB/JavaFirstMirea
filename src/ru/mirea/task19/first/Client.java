package ru.mirea.task19.first;

public class Client {
    private String name;
    private String INN;

    public Client(String name, String INN) {
        this.name = name;
        this.INN = INN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }
}
