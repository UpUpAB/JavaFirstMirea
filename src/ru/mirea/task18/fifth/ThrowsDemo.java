package ru.mirea.task18.fifth;



public class ThrowsDemo {
    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println( message );
        } catch (NullPointerException e ){
            System.out.println("ERROR");
        }

    }
    public String getDetails(String key) {
        if(key == null) {
            throw new NullPointerException( "null key in getDetails" );
        }
        return "data for " + key;
    }


    public static void main(String[] args) {

        new ThrowsDemo().printMessage(null);

        new ThrowsDemo().printMessage("a");
    }
}

