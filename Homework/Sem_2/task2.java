// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

package Homework.Sem_2;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class task2 {
    private static final Logger logger = Logger.getLogger(task2.class.getName());

    public static void main(String[] args) {

        int[] array = { 5, 2, 8, 4, 1 };

        try {
            FileHandler fileHandler = new FileHandler("logging.txt");
            logger.addHandler(fileHandler);

            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        StringBuilder arrayString = new StringBuilder();

                        for (int k = 0; k < array.length; k++) {

                            arrayString.append(Integer.toString((array[k])));
                        }
                        logger.log(Level.INFO, "Array " + arrayString);
                    }
                }
            }
        } catch (Exception e) {
            logger.severe("Error: " + e);
        }
    }
}
