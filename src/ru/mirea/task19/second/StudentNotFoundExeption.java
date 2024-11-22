package ru.mirea.task19.second;

public class StudentNotFoundExeption extends RuntimeException{
    public StudentNotFoundExeption(String message){
        super(message);
    }
    public StudentNotFoundExeption(){
        super("Student not found");
    }

}
