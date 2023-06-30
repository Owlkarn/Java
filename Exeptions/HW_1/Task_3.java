//Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
//каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. 
//Если длины массивов не равны, необходимо как-то оповестить пользователя.
//Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.

package Exeptions.HW_1;

import java.util.Random;

public class Task_3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr1 = new int[rnd.nextInt(1, 5)];
        int[] arr2 = new int[rnd.nextInt(1, 5)];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rnd.nextInt(50);
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = rnd.nextInt(50);
        }

        if (arr1.length != arr2.length)
            throw new RuntimeException("Массивы разной длинны");
        else {
            double[] arrFinal = getArrDif(arr1, arr2);
            System.out.println(arrFinal.length);
            for (int i = 0; i < arrFinal.length; i++) {
                System.out.print(arrFinal[i] + " ");
            }
        }
    }

    public static double[] getArrDif(int[] arr1, int[] arr2) {
        double[] arr3 = new double[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0)
                throw new RuntimeException("Деление на 0");

            arr3[i] = (double) arr1[i] / arr2[i];
        }
        return arr3;
    }

}
