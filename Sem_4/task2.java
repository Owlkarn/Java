package Sem_4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class task2 {
    public static void main(String[] args) {
        String string = "";
        Deque<String> dq = new ArrayDeque<>() {

        };
        while (true) {
            System.out.print("Введите текст: ");
            Scanner iScanner = new Scanner(System.in, "cp866"); // для русского языка
            string = iScanner.nextLine();
            if (!string.equals("exit")) {

                if (string.equals("print")) {
                    System.out.println(dq);
                } else if (string.equals("revert")) {
                    dq.pop();
                } else
                    dq.push(string);
            } else
                break;
        }

    }

}
