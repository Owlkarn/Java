package Sem_4;

import java.util.ArrayList;
import java.util.LinkedList;

public class task0 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        ArrayList<Integer> iArrayList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            iArrayList.add((int) (Math.random() * 100));
        }
        System.out.println("Заполнение ArrayList заняло " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();

        LinkedList<Integer> iLinkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            iLinkedList.add((int) (Math.random() * 100));
        }
        System.out.println("Заполнение LinkedList заняло " + (System.currentTimeMillis() - time));
    }
}
