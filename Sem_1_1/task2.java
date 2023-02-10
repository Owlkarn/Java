package Sem_1_1;

public class task2 {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 1, 0, 1, 1, 1 };
        int count = 0;
        int maxLength = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count++;
            } else {
                if (maxLength < count) {
                    maxLength = count;
                }
                count = 0;
            }
        }
        if (maxLength < count) {
            maxLength = count;
        }
        System.out.println(maxLength);
    }
}
