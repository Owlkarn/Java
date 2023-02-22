// Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
// Разность:
// A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
// B - A = все числа из второй коллекции, которые не содержатся в первой
// Симметрическая разность:
// A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой

package Homework.Sem_3;

import java.util.ArrayList;
import java.util.Random;

public class task4 {
    public static void main(String[] args) {
        ArrayList<Integer> numbersA = new ArrayList();
        ArrayList<Integer> numbersB = new ArrayList();
        Random rnd = new Random();

        for (int i = 0; i < 4; i++) {
            numbersA.add(rnd.nextInt(10));
            numbersB.add(rnd.nextInt(10));
        }
        System.out.println("Collection A: " + numbersA);
        System.out.println("Collection B: " + numbersB);

        ArrayList<Integer> numbersC = new ArrayList();

        for (int i = 0; i < numbersA.size(); i++) {
            if (!numbersB.contains(numbersA.get(i))) {
                numbersC.add(numbersA.get(i));
            }
        }
        System.out.println("A - B: " + numbersC);

        ArrayList<Integer> numbersD = new ArrayList();

        for (int i = 0; i < numbersB.size(); i++) {
            if (!numbersA.contains(numbersB.get(i))) {
                numbersC.add(numbersB.get(i));
                numbersD.add(numbersB.get(i));
            }
        }
        System.out.println("B - A: " + numbersD);
        System.out.println("A ^ B: " + numbersC);
    }
}
