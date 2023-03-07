// 1. Напишите метод, который заполнит массив из 1000 элементов случайными числами от 0 до 24. 
// 1.5. Создайте метод, в который передайте заполненный выше массив, и с помощью Set вычислите процент уникальных значений 
// в данном массиве, и верните его в виде числа с плавающей запятой.
// Для вычисления процента используйте формулу:
// процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.

package Sem_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class task2 {

    private static float uniquePercent(Integer[] array) {

        Set<Integer> unique = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, array);
        unique.addAll(list);
        return unique.size() * 100f / array.length;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[1000];
        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(0, 25);
        }

        System.out.println(uniquePercent(array));
    }
}
