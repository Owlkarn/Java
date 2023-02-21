package Sem_3;

import java.util.ArrayList;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        ArrayList<Integer> collection = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            collection.add(rnd.nextInt(0, 10));
        }
        System.out.println(collection);
        collection.sort(new MyComparator());
        System.out.println(collection);
    }
}
