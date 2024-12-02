package ru.mirea.task21.first;

class NoSuchElementException extends RuntimeException{
    public NoSuchElementException(String message) {
        super(message);
    }

    public NoSuchElementException() {
        super("no such element found");
    }
}

class ListElement<E> {
    E data;
    ListElement<E> next;
    ListElement<E> prev;

    @Override
    public String toString() {
        String output;
        output = "Node data" + data;
        return output;
    }
}

class List<E extends Number> {
    private ListElement<E> head;
    private ListElement<E> tail;
    private int listCount = 0;
    void add(E data){
        ListElement<E> temp = new ListElement<>();
        temp.data = data;
        if (tail == null){
            head = temp;
            tail = temp;

        } else {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
        listCount++;
    }
    void printList(){
        ListElement<E> temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }
    void addM(E[] data){
        for (int i =0;i<data.length;i++){
            add(data[i]);

        }
    }

    void deliteAll(E data)
    {
        if(head == null) return;

        if (head == tail && head.data == data) {
            head = null;
            tail = null;
            listCount=0;
            return;
        }

        if (head.data == data) {
            head = head.next;
            head.prev=null;
            listCount--;
            deliteAll(data);
            return;
        }

        ListElement<E> temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                if(tail == temp.next)
                {
                    tail = temp;
                }
                temp.next = temp.next.next;
                temp.prev = temp;
                listCount--;
                deliteAll(data);
                return;
            }
            temp = temp.next;
        }
    }

    void delite(int index){
        //System.out.println(listCount);
        if (index < 0 || index >= listCount) return;
        ListElement<E> current = head;
        if (index == 0) head = head.next;
        for (int i =1; i < index; i++){
            if (current.next == null) return;
            current = current.next;
        }
        current.next = (current.next.next);
        listCount--;

    }

    Object dataAt(int index){
        if (index < 0 || index >= listCount) throw new NoSuchElementException();
        ListElement<E> current = head;
        for (int i = 0; i < index; i++){
            if (current.next == null) return null;
            current = current.next;
        }

        return current.data;
    }


    boolean isListEmpty(){
        return head == null;
    }
    void listClear(){
        head = null;
        tail = null;
        listCount =0;
    }

    @Override
    public String toString() {
        ListElement<E> temp = head;
        String output = "";
        while (temp != null){
            output = output + temp.data + " ";
            temp = temp.next;
        }
        System.out.print("\n");
        return output;
    }
}

public class Tester {
    public static void main(String[] args) {
        List list = new List();
        Integer[] m = {1,2,3,4};
        list.add(6);
        list.add(7);
        list.addM(m);


        list.printList();
        System.out.println(list);
    }
}
