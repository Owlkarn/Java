// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, 
// необходимо повторно запросить у пользователя ввод данных.

package Exeptions.HW_2;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        processFloat();
    }

    public static void processFloat() {
        try {
            System.out.printf("Число %f преобразовано", parseElement());
        } catch (MyFloatException e) {
            System.out.printf("%s %s\n", e.getMessage(), e.getX());
            processFloat();
        }
    }

    public static String getFloatNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число типа Float: ");
        return scan.nextLine();
    }

    public static float parseElement() throws MyFloatException {
        String element = getFloatNumber();
        try {
            float number = Float.parseFloat(element);
            return number;
        } catch (NumberFormatException e) {
            throw new MyFloatException("Введено некорректное значение", element);
        }
    }
}

abstract class MyException extends Exception {
    private final String x;

    public MyException(String message, String x) {
        super(message);
        this.x = x;
    }

    public String getX() {
        return x;
    }
}

class MyFloatException extends MyException {
    public MyFloatException(String message, String x) {
        super(message, x);
    }
}