// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.

package Homework.Sem_3;

import java.util.ArrayList;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList();
        Random rnd = new Random();

        for (int i = 0; i < 5; i++) {
            numbers.add(rnd.nextInt(10));
        }
        System.out.println(numbers);

        int max = numbers.get(0);
        int min = numbers.get(0);
        double sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            } else if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }
        System.out.printf("Максимальное: %s, минимальное: %s, среднее арифметическое: %s", max, min, sum/numbers.size());
    }
}
