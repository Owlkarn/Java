// Реализовать простой калькулятор Введите число 2 Введите операцию 1 + 2 - 3 * 4 / Введите число 2 2 + 2 = 4

package Homework.Sem_1;

import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        System.out.print("Введите число x: ");
        Scanner iScanner = new Scanner(System.in);
        Integer x = iScanner.nextInt();

        System.out.print("Введите оператор: ");
        String oper = iScanner.next();

        System.out.print("Введите число y: ");
        Integer y = iScanner.nextInt();

        switch (oper){
            case "+":
            System.out.printf("%s + %s = %s", x, y, x + y);
            break;

            case "-":
            System.out.printf("%s - %s = %s", x, y, x - y);
            break;

            case "*":
            System.out.printf("%s * %s = %s", x, y, x * y);
            break;

            case "/":
            System.out.printf("%s / %s = %s", x, y, x / y);
            break;

            default:
            System.out.println("Введен неверный оператор");
        }
        iScanner.close();
    }
}
