package Exeptions.HW_2;

public class Task_2 {
    public static void main(String[] args) {
        int[] intArray = {6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}; 
        try {
            int d = 2; // чтобы не выпадала ошибка, нужно изменить значение переменной d
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}
