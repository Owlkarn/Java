package Homework.Sem_1;

import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {
        System.out.print("Введите уравнение в формате x+y=z (пример 2?+?3=67): ");
        Scanner iScanner = new Scanner(System.in);
        String equation = iScanner.next();
        String[] splitEquation = equation.split("");
        
        Integer x = 0;
        Integer posX = 0;
        for (int i = 0; i < 2; i++) {
            try { 
                x = Integer.valueOf(splitEquation[i]);
                posX = i;
            }catch (NumberFormatException e) {}   
        }

        Integer y = 0;
        Integer posY = 0;
        for (int i = 3; i < 5; i++) {
            try { 
                y = Integer.valueOf(splitEquation[i]);
                posY = i;
            }catch (NumberFormatException e) {}   
        }

        Integer z1 = Integer.valueOf(splitEquation[6]);
        Integer z2 = Integer.valueOf(splitEquation[7]);
        Integer z = z1*10+z2;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (posX == 0 && posY == 3){
                    if ((x*10 + i + y*10 + j)==z){
                        System.out.printf("%s + %s = %s", x*10 + i, y*10 + j, z);
                    }
                    else if (i==9 && j==9) {
                        System.out.println("Решения нет");
                    }
                }
                else if (posX == 0 && posY == 4){
                    if ((x*10 + i + y + j*10)==z){
                        System.out.printf("%s + %s = %s", x*10 + i, y + j*10, z);
                    }
                    else if (i==9 && j==9) {
                        System.out.println("Решения нет");
                    }
                }
                else if (posX == 1 && posY == 4){
                    if ((x + i*10 + y + j*10)==z){
                        System.out.printf("%s + %s = %s", x + i*10, y + j*10, z);
                    }
                    else if (i==9 && j==9) {
                        System.out.println("Решения нет");
                    }
                }
                else {
                    if ((x + i*10 + y*10 + j)==z){
                        System.out.printf("%s + %s = %s", x + i*10, y*10 + j, z);
                    }
                    else if (i==9 && j==9) {
                        System.out.println("Решения нет");
                    }
                }
            }
        }
        iScanner.close();
    }
}
