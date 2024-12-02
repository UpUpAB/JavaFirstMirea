package ru.mirea.task23.second;

class QueueElement{
    int data;
    QueueElement next;
}
class LinkedQueue{
    QueueElement head;
    QueueElement tail;
    int size=0;
    public void enqueue(int data){
        QueueElement temp = new QueueElement();
        temp.data = data;
        if (tail == null){
            head = temp;
            tail = temp;

        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    public boolean isEmpty(){
        return (size == 0);
    }

    public int dequeue(){
        if (head == null) throw new IllegalStateException("Очередь пуста");

        int temp = head.data;
        head = head.next;
        return temp;
    }
    public void clear(){
        head = tail = null;
    }
    public int size(){
        return size;
    }
    public int element(){
        return head.data;
    }
    public void printQueue(){
        QueueElement temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}
public class Main {
    public static void main(String[] args) {
        LinkedQueue lq = new LinkedQueue();
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        lq.printQueue();
        System.out.println(lq.element());
        System.out.println(lq.size());
        lq.dequeue();
        lq.printQueue();


    }
}
