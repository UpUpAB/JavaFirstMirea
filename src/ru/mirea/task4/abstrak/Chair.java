package ru.mirea.task4.abstrak;

public class Chair extends Furniture{
    private boolean hasArms;

    public Chair(String material, double price, boolean hasArms) {
        super(material, price);
        this.hasArms = hasArms;
    }

    public boolean isHasArms() {
        return hasArms;
    }

    @Override
    public void description() {
        System.out.println("Chair made of " + getMaterial() + ", price: $" + getPrice()
                + ", has armrest: " + hasArms);
    }

}

