// Вычислить n-ое треугольного число(сумма чисел от 1 до n)

package Homework.Sem_1;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        System.out.print("Введите число: ");
        Scanner iScanner = new Scanner(System.in);
        Integer n = iScanner.nextInt();
        int sumAr = (n*(n+1))/2;
        System.out.println(sumAr);
        iScanner.close();
    }
}
