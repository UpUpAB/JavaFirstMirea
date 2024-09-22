package ru.mirea.task4.abstrak;

public class Table extends Furniture{
    private int tableLegs;

    public Table(String material, double price, int tableLegs) {
        super(material, price);
        this.tableLegs = tableLegs;
    }

    public int getTableLegs() {
        return tableLegs;
    }

    @Override
    public void description() {
        System.out.println("Table made of " + getMaterial() + ", price: $" + getPrice() + ", number of legs: " + tableLegs);
    }

}

