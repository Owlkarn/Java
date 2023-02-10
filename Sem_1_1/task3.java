package Sem_1_1;

import java.util.Arrays;

public class task3 {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 2, 3, 2, 3, 3, 3, 2, 2 };
        int val = 3;
        int pos = arr.length - 1;
        for (int i = 0; i < pos; i++) {
            if (arr[i] == val) {
                while (arr[pos] == 3 && pos > i) {
                    pos--;
                }
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
                pos--;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
