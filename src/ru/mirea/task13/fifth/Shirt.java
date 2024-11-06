package ru.mirea.task13.fifth;

public class Shirt {
    private String number;
    private String color;
    private String model;
    private String size;

    public Shirt(String number,  String model, String color, String size) {
        this.number = number;
        this.color = color;
        this.model = model;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "number='" + number + '\'' +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };
        Shirt[] shirt = new Shirt[shirts.length];
        for (int i=0;i<shirt.length;i++){
            String[] parts = shirts[i].split(",");
            shirt[i] = new Shirt(parts[0],parts[1],parts[2],parts[3]);
        }
        for(Shirt s : shirt){
            System.out.println(s);
        }
    }
}
