// Вычислить n! (произведение чисел от 1 до n)

package Homework.Sem_1;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        System.out.print("Введите число: ");
        Scanner iScanner = new Scanner(System.in);
        Integer n = iScanner.nextInt();
        int multProg = 1;

        for (int i = 1; i <= n; i++) {
            multProg *= i; 
        }
        System.out.println(multProg);
        iScanner.close();

    }
}
