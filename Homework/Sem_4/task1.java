// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

package Homework.Sem_4;

import java.util.LinkedList;

public class task1 {
    private static void revList(LinkedList lList) {

        int n = lList.size()/2;
        for (int i = 0; i < n; i++) {
            lList.add(i, lList.get(lList.size()-1-i));
            lList.add(lList.size()-1-i, lList.get(i+1));
            lList.remove(i+1);
            lList.remove(lList.size()-1-i);
        }
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
        revList(lList);
        System.out.println(lList);
    }
}
