// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

package Exeptions.HW_2;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        processGetString();
    }

    public static void processGetString() {
        try {
            String str = getString();
            System.out.printf("Спасибо, вы ввели: %s", str);
        } catch (MyEmptyStringException e) {
            System.out.printf("%s", e.getMessage());
        }
    }

    public static String getString() throws MyEmptyStringException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = scan.nextLine();
        if (str == "")
        throw new MyEmptyStringException("Введена пустая строка");
        else
        return str;
    }
}

class MyEmptyStringException extends Exception {
    public MyEmptyStringException(String message) {
        super(message);
    }
}
