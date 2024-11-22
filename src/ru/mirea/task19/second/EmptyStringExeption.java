package ru.mirea.task19.second;

public class EmptyStringExeption extends RuntimeException{
    public EmptyStringExeption(String message){
        super(message);
    }
    public EmptyStringExeption(){
        super("Empty String in input");
    }
}
