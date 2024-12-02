package ru.mirea.task17.nodeSecond;

class NodeStr {
    String data;

    NodeStr prev;
    NodeStr next;

    public NodeStr(String data) {
        this.data = data;

    }
}
class StringList {
    private NodeStr head;

    public void add(String data) {
        NodeStr newNode = new NodeStr(data);


        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            NodeStr current = head;
            boolean added = false;

            do {
                if (current.data.length() > newNode.data.length() ||
                        (current.data.length() == newNode.data.length() && current.data.compareTo(newNode.data) > 0)) {
                    NodeStr prevNode = current.prev;
                    prevNode.next = newNode;
                    newNode.prev = prevNode;
                    newNode.next = current;
                    current.prev = newNode;

                    if (current == head) {
                        head = newNode;
                    }
                    added = true;
                    break;
                }

                current = current.next;
            } while (current != head);

            if (!added) {
                NodeStr tail = head.prev;
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = head;
                head.prev = newNode;
            }
        }
    }

    public void printList() {
        if (head == null) return;

        NodeStr current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}



public class StringListCompare {
    public static void main(String[] args) {
        StringList list = new StringList();
        list.add("banana");
        list.add("apple");
        list.add("kiwi");
        list.add("pear");
        list.add("grape");
        list.add("apricot");

        System.out.println("Список строк в порядке длины и алфавиту:");
        list.printList();

    }
}
