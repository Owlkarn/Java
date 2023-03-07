package Sem_6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class task1 {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(List.of(4, 5, 6, 1, 2, 3, 2, 4, 5, 6, 3));
        //hashSet.addAll(List.of(1, 2, 3, 2, 4, 5, 6, 3));
        System.out.println(hashSet);

        Set<Integer> linkedHashSet = new LinkedHashSet<>(List.of(4, 5, 6, 1, 2, 3, 2, 4, 5, 6, 3));
        System.out.println(linkedHashSet);

        Set<Integer> treeSet = new TreeSet<>(List.of(4, 5, 6, 1, 2, 3, 2, 4, 5, 6, 3));
        System.out.println(treeSet);
    }
}
