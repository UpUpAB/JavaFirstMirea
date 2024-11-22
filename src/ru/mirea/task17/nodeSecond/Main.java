package ru.mirea.task17.nodeSecond;
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
class CircularDoublyLinkedList {
    Node head = null;
    Node tail = null;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = tail;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
    }

    public void bubbleSort() {
        if (head == null) return; // Если список пуст

        boolean swapped;
        do {
            swapped = false;
            Node current = head;

            do {
                if (current.data > current.next.data) {

                    //System.out.println(current.data + " " + current.next.data);
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                    //System.out.print(0+" ");
                    //System.out.println(current.data + " " + current.next.data);
                    //display();

                }
                current = current.next;
                //System.out.print(1+" ");
            } while (current.next != head);
            //System.out.println(2);
        } while (swapped);
        //System.out.println(3);
    }


    public void display() {
        if (head == null) return;
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.add(4);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);

        System.out.println("Список до сортировки:");
        list.display();

        list.bubbleSort();

        System.out.println("Список после сортировки:");
        list.display();
    }
}
