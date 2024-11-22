package ru.mirea.task19.first;

public class INNCheck {
    private Client[] dataBase = new Client[2];

    public INNCheck(){
        dataBase[0] = new Client("Vika","1234567890");
        dataBase[1] = new Client("Vova","1234567890");
        checkForSimilar("Vova","0");
        validateINN("12345690");
    }
    private void validateINN(String INN){
        if (!(INN.length() >=10 && INN.length()<=12)){
            throw new WrongINNInput("wrong INN: "+INN);
        }
    }
    private void checkForSimilar(String name,String INN){
        for (int i =0;i<dataBase.length;i++){
            if(dataBase[i].getName().equals(name)){
                if (!dataBase[i].getINN().equals(INN)) throw new WrongINNInput("wrong INN: "+INN);
            }
        }
    }

    public static void main(String[] args) {
        new INNCheck();
    }
}
