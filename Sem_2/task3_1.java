package Sem_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task3_1 {
    private static String repeatString(String part) {
        StringBuilder fullString = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            fullString.append(part);
        }
        return fullString.toString();
    }

    private static void writeFullString(String fullString) {
        try (FileWriter file = new FileWriter("test.txt")) {
            file.append(fullString);
            System.out.println("Файл создан");
        } catch (IOException ex) {
            System.err.printf("Ошибка: %s", ex);
        }
    }

    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        Scanner iScanner = new Scanner(System.in, "cp866");
        String word = iScanner.nextLine();
        writeFullString(repeatString(word));
        iScanner.close();
    }
}
