package ru.mirea.task4.abstrak;
import java.util.ArrayList;
public class FurnitureShop {
    private ArrayList<Furniture> furnList;

    public FurnitureShop() {
        this.furnList = new ArrayList<>();
    }
    public void addFurniture(Furniture furniture){
        furnList.add(furniture);
    }
    public void displayFurniture() {
        for (Furniture furniture : furnList) {
            furniture.description();
        }
    }

    public static void main(String[] args) {
        FurnitureShop shop = new FurnitureShop();
        shop.addFurniture(new Chair("wood",100,true));
        shop.addFurniture(new Table("glass",400,4));
        shop.displayFurniture();
    }

}
