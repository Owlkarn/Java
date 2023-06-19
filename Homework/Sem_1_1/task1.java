// Реализовать алгоритм пирамидальной сортировки (сортировка кучей).

package Homework.Sem_1_1;

public class task1 {
    public static void sort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapSort(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSort(array, i, 0);
        }
    }

    private static void heapSort(int[] arr, int n, int i) {

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapSort(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 9, 1, 2, 3, 5, 7, 2, 4, 8 };
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
