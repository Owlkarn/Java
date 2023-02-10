package Sem_1_1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {

        System.out.print("Введите свое имя ");
        Scanner iScanner = new Scanner(System.in, "cp866"); //для русского языка
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!\n", name);
        System.out.println(String.format("Привет, %s!", name));
        iScanner.close();

    }
    
}
