package ru.mirea.task23.first;



class CycleQueue<E>{
    private E[] elements;
    private int size;
    private int head;
    private int tail;
    private int count;

    public CycleQueue(int size) {
        this.size = size;
        elements = (E[]) new Object[size];
        head = 0;
        tail = -1;
        count =0;
    }
    public boolean isEmpty() {
        return (count == 0);
    }
    public boolean isFull() {
        return (count == size);
    }
    public void enqueue(E item) {
        if (isFull()) throw new IllegalStateException("Очередь полна");

        tail = (tail + 1) % size;
        elements[tail] = item;
        count++;
    }
    public E dequeue() {
        if (isEmpty()) throw new IllegalStateException("Очередь пуста");

        E item = elements[head];
        head = (head + 1) % size;
        count--;
        return item;
    }

    public int size() {
        return count;
    }

    public void printQueue() {
        for (int i = 0; i < count; i++) {
            System.out.print(elements[(head + i) % size] + " ");
        }
        System.out.println();
    }
    public void clear(){
        elements = (E[]) new Object[size];
    }
    public E element(){
        return elements[head];
    }
}
public class Main {
    public static void main(String[] args) {
        CycleQueue<Integer> cq = new CycleQueue<>(2);
        //ВОПРОС почему не даёт возможность оставить пустой дженерик?
        cq.enqueue(1);
        cq.enqueue(2);
        cq.printQueue();
        cq.dequeue();
        cq.enqueue(3);
        cq.printQueue();
        System.out.println(cq.element());

    }
}
