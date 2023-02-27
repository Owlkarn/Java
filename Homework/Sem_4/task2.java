// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя.

package Homework.Sem_4;

import java.util.LinkedList;

public class task2 {
    private static void enqueue(LinkedList lList, String el) {
        lList.add(lList.size(), el);
    }

    private static Object dequeue(LinkedList lList) {
        Object l = lList.get(0);
        lList.remove(0);
        return l;
    }

    private static Object first(LinkedList lList) {
        Object l = lList.get(0);
        return l;
    }

    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<>();
        lList.add("h");
        lList.add("e");
        lList.add("l");
        lList.add("l");
        lList.add("o");
        lList.add("3");
        lList.add("2");
        lList.add("1");
        System.out.println(lList);
        enqueue(lList, "!!!");
        System.out.println(lList);
        System.out.println(first(lList));
        System.out.println(dequeue(lList));
        System.out.println(lList);
    }
}
