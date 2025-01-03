package ru.mirea.task28.hashSetTask;

import java.util.*;

class HashSetToTreeSet{
    public HashSetToTreeSet() {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(4);
        hashSet.add(2);
        System.out.println("Элементы HashSet: " + hashSet);
        TreeSet<Integer> treeSet = new TreeSet<>(hashSet);
        System.out.println("Элементы TreeSet: " + treeSet);
    }
}
class SameNames {
    public SameNames() {
        System.out.println(getSameFirstNameCount());
        //System.out.println(getSameLastNameCount());

    }
        public  Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Иванов", "123");
        map.put("Петров", "123");
        map.put("Сидоров", "123");
        map.put("Смирнов", "321");
        map.put("Кузнецов", "1");
        map.put("Попов", "2");
        map.put("Громов", "3");
        map.put("Морозов", "4");
        map.put("Гномов", "4");
        map.put("Попов", "5");
        return map;
    }
    public  int getSameFirstNameCount() {
         Map<String, String> map = createMap();
         HashMap<String, Integer> firstNameCount = new HashMap<>();


         for (String firstName : map.values()) {
             firstNameCount.put(firstName, firstNameCount.getOrDefault(firstName, 0) + 1);
             
         }
         System.out.println(firstNameCount);
         int count = 0;
         for (int occurrence : firstNameCount.values()) {
             if (occurrence > 1) {
                 count += occurrence;
             }
         }
         return count;
    }




/*
    public  int getSameLastNameCount() {
        Map<String, String> map = createMap();
        HashMap<String, Integer> lastNameCount = new HashMap<>();

        for (String lastName : map.keySet()) {
            lastNameCount.put(lastName, lastNameCount.getOrDefault(lastName, 0) + 1);
        }

        int count = 0;
        for (int occurrence : lastNameCount.values()) {
            if (occurrence > 1) {
                count += occurrence;
            }
        }
        return count;
    }*/

}
public class Main {
    public static void main(String[] args) {
        new HashSetToTreeSet();
        new SameNames();
    }
}
