package ru.mirea.task27.hashtab;

import java.util.ArrayList;

class HashNode<K,V>{
    K key;
    V value;
    HashNode<K,V> next;

    @Override
    public String toString() {
        return "key=" + key +
                ", value=" + value;
    }
}
public class Map <K,V>{
    private int size;
    private ArrayList<HashNode<K,V>> bucket;
    public Map(int size){
        this.size = size;
        hashtabInit();
    }
    public void hashtabInit(){
        bucket = new ArrayList<>();
        for (int i =0;i<size;i++){
            bucket.add(null);
        }
    }
    public int hashtabHash(K key){
        return Math.abs(key.hashCode()) % size;
    }
    public void hashtabAdd(K key,V value){
        int tempIndex = hashtabHash(key);
        HashNode<K,V> temp = new HashNode<>();
        temp.key = key;
        temp.value = value;
        HashNode<K,V> head = bucket.get(tempIndex);
        if (head == null){
            head = temp;
            bucket.set(tempIndex, head);
            return;
        }
        while (head.next !=null){
            head = head.next;
        }
        head.next = temp;
    }
    public void printHashtab(){
        HashNode<K,V> help = bucket.get(3);

        //System.out.println(help);
        //System.out.println(help.next);


        for (int i =1 ;i<=size;i++){
            System.out.print(i+") ");
            HashNode<K,V> temp = bucket.get(i-1);
            if (temp == null) System.out.print("null");
            while (temp != null){
                System.out.print("Key: "+temp.key+"; Value: "+ temp.value+"; ");
                temp= temp.next;
            }
            System.out.println();
        }

    }
    public HashNode<K,V> hashtabLookUp(K key){
        int tempIndex = hashtabHash(key);

        HashNode<K,V> temp = bucket.get(tempIndex);
        while (temp != null){
            if (temp.key.equals(key)){
                return temp;
            }
            temp= temp.next;
        }
        System.out.println("Данного ключа не было найдено");
        return null;
    }

    public void hashtabRemove(K key){
        int tempIndex = hashtabHash(key);
        HashNode<K,V> temp = bucket.get(tempIndex);
        if (temp.key.equals(key)) {
            bucket.set(tempIndex,temp.next);
            return;
        }
        while (temp.next!= null){
            if (temp.next.key.equals(key)){
                temp.next = temp.next.next;
                return;
            }
            temp= temp.next;

        }
        System.out.println("Данного ключа не было найдено");

    }

    public static void main(String[] args) {
        Map<String, Integer> m = new Map<>(10);
        m.hashtabAdd("qwe",12);
        m.hashtabAdd("qwe",34);
        m.hashtabAdd("rty",34);
        m.hashtabAdd("ed",1);
        m.hashtabAdd("ab",2);
        System.out.println("qwe".hashCode()%10);
        System.out.println("rty".hashCode()%10);
        System.out.println(m.hashtabLookUp("rty"));
        m.printHashtab();
        System.out.println();
        m.hashtabRemove("ed");
        m.printHashtab();
    }

}
