// Вывести все простые числа от 1 до 1000

package Homework.Sem_1;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        System.out.print("Введите число: ");
        Scanner iScanner = new Scanner(System.in);
        Integer n = iScanner.nextInt();
        System.out.print("2 ");
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                if (i%j==0 && j!=i){
                    break;
                }
                else if (j==i){
                    System.out.printf("%s ", i);
                }
            }
        }
        iScanner.close();
    }
}
