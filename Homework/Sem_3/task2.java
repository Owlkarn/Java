// Пусть дан произвольный список целых чисел. Удалить из него чётные числа.

package Homework.Sem_3;

import java.util.ArrayList;
import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList();
        Random rnd = new Random();

        for (int i = 0; i < 20; i++) {
            numbers.add(rnd.nextInt(100));
        }
        System.out.println(numbers);
   
        for (int i = 0; i < numbers.size(); i++) {
           if (numbers.get(i)%2 == 0){
               numbers.remove(i);
               i--;
           }
        }
        System.out.println(numbers);
       }
}
