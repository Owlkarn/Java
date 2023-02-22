// Реализовать алгоритм сортировки слиянием.

package Homework.Sem_3;

public class task1 {
    private static void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftPart(array);
            int[] right = rightPart(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }

    }

    private static int[] leftPart(int[] array) {
        int[] leftHalf = new int[array.length/2];

        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = array[i];
        }
        return leftHalf;
    }

    private static int[] rightPart(int[] array) {
        int[] rightHalf = new int[array.length - array.length/2];

        for (int i = 0; i < rightHalf.length; i++) {
            rightHalf[i] = array[i + array.length/2];
        }
        return rightHalf;
    }

    private static void merge(int[] result, int[] leftArray, int[] rightArray) {
        int iL = 0;
        int iR = 0;
        for (int i = 0; i < result.length; i++) {

            if ((iR >= rightArray.length) || ((iL < leftArray.length) && (leftArray[iL] <= rightArray[iR]))){
                result[i] = leftArray[iL];
                iL++;
            }
            else {
                result[i] = rightArray[iR];
                iR++;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {5, 8, 2, 6, 4, 0, 5, 6, 3, 9, 1};
        mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
