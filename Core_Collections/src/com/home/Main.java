package com.home;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) {
        //Collections
        //интерфейс Collection -> базовые интерфейсы наследники List, Set, Queue (хранят)
        //интерфейс Map ()
        //классы реализующие List могут хранить повторяющиеся объекты (некоторые реализации -> ArrayList, LinkedList, Vector)
        List<Integer> arrayList = new ArrayList<>();    //
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(1, 2);
        System.out.println("ArrayList: " + arrayList);
        
        List<Integer> linkedList = Arrays.asList(2, 4, 8, 16);
        System.out.println("LinkedList: " + linkedList);
        
        //List полученный с исп. метода asList() нельзя изменять (java.lang.UnsupportedOperationException)
        //linkedList.add(2);
        
        //классы реализующие Set не могут хранить повторяющиеся объекты (некоторые реализации -> HashSet, TreeSet, LinkedHashSet)
        Set<Integer> treeSet = new TreeSet<>();	//TreeSet самостоятельно сортирует коллекцию
        treeSet.add(32);
        treeSet.add(1);
        treeSet.add(10);
        System.out.println("TreeSet: " + treeSet);
        
       
        //классы реализующие Queue -> очереди, в том числе двунаправленные и т.д.
        Queue<Integer> queue = new ArrayBlockingQueue<>(5);
        queue.add(8);
        queue.add(4);
        queue.add(32);
        System.out.println("Queue: " + queue);
        System.out.println("Queue (head element): " + queue.poll());
        System.out.println("Queue (head element): " + queue.poll());
        System.out.println("Queue after 2 poll: " + queue);

        //Для изменения коллекции в цикле, для избежания ошибки java.util.ConcurrentModificationException следует использовать iterator
        try {
            System.out.print("\narrayList1: ");
            for (Integer i : arrayList) {
            	arrayList.remove(i);
            }
        }
        catch (ConcurrentModificationException ex){
            System.out.println(ex);
        }
        System.out.println("ArrayList (before modifications): " + arrayList);
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Integer nextInt = iterator.next();
            if(nextInt % 2 == 0) iterator.remove();
        }
        System.out.println("ArrayList (after modifications): " + arrayList);

        //Map -> для работы с данными вида «ключ — значение» (некоторые реализации -> HashMap, LinkedHashMap, TreeMap)
        //HashMap - порядок хранения определяется хешем ключа
        Map<String, Integer> hashMap = new HashMap<>(); 
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        System.out.println("HashMap: " + hashMap);
        
        //ThreeMap - порядок хранения по умолчанию определяется "natural ordering" хеша ключа
        Map<String, Integer> treeMap = new TreeMap<>(); 
        treeMap.put("One", 1);        
        treeMap.put("Two", 2);
        treeMap.put("Three", 3);
        System.out.println("TreeMap: " + treeMap);
        
        System.out.print("Keys: ");
        for(String key : treeMap.keySet()) {
        	System.out.print(String.format(" %s", key));
        }
        System.out.println();
        System.out.print("Values: ");
        for(Integer value : treeMap.values()) {
        	System.out.print(String.format(" %d", value));
        }
        System.out.println();    
    }
}
