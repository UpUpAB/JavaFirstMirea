package ru.mirea.task26.second;

import java.util.ArrayList;
import java.util.List;

public class Iterator<E> implements java.util.Iterator<E> {
    private final List<E> list;
    private int currentPosition = 0;

    public Iterator(List<E> list) {
        this.list = list;
    }

    @Override
    public void remove() {
        list.remove(currentPosition - 1);
        currentPosition--;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new ArrayIndexOutOfBoundsException("Нет следующего элемента");
        }
        E el = list.get(currentPosition);
        currentPosition++;
        return el;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < list.size();
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        System.out.println("Ваш массив: " + list1);
        Iterator<Integer> itr = new Iterator<>(list1);
        while (itr.hasNext()) {
            Integer i = itr.next();
            System.out.print(i + " ");
            if (i % 2 != 0) {
                itr.remove();
            }
        }
        System.out.println("\nВаш массив: " + list1);
    }
}
