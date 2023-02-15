package Sem_2;

import java.util.Scanner;

public class task1 {
    private static String CreatealteratingString(char c1, char c2, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result.append(c1);
            } else {
                result.append(c2);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.print("Введите четное число число: ");
        Scanner iScanner = new Scanner(System.in);
        int n = iScanner.nextInt();

        System.out.print("Введите символ 1: ");
        char c1 = iScanner.next().charAt(0);

        System.out.print("Введите символ 2: ");
        char c2 = iScanner.next().charAt(0);

        System.out.println(CreatealteratingString(c1, c2, n));

        iScanner.close();
    }
}
