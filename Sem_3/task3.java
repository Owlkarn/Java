package Sem_3;

import java.util.ArrayList;

public class task3 {
    public static void main(String[] args) {
     ArrayList mixed = new ArrayList<String>();
     mixed.add("hello");
     mixed.add(234);
     mixed.add("abc");
     mixed.add(736);
     mixed.add(736);
     mixed.add("hi");
     System.out.println(mixed);

     for (int i = 0; i < mixed.size(); i++) {
        if (mixed.get(i) instanceof Integer){
            mixed.remove(i);
            i--;
        }
     }
     System.out.println(mixed);
    }
}
