//Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
//каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. 
//Если длины массивов не равны, необходимо как-то оповестить пользователя.

package Exeptions.HW_1;

import java.util.Random;

public class Task_2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr1 = new int[rnd.nextInt(1, 5)];
        int[] arr2 = new int[rnd.nextInt(1, 5)];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rnd.nextInt(5);
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = rnd.nextInt(5);
        }
        
        if(arr1.length != arr2.length)
        throw new RuntimeException("Массивы разной длинны");
        else {
            System.out.println(arr1.length);
            for (int i = 0; i < arr1.length; i++) {
                System.out.print(getArrDif(arr1, arr2)[i]);
            }
        } 
    }
    public static int[] getArrDif(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i] - arr2[i];
        }
        return arr3;
    }

}
