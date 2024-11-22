package ru.mirea.task19.first;

public class WrongINNInput extends RuntimeException{
    public WrongINNInput(String message, Throwable err) {
        super(message, err);
    }
    public WrongINNInput(String message) {
        super(message);
    }
}
