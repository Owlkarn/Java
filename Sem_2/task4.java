// Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла:
// 4 Расширение файла: jpg

package Sem_2;

import java.io.File;

public class task4 {
    private static void fileExtension(String[] fileNames) {
        for (int i = 0; i < fileNames.length; i++) {
            if (fileNames[i].contains(".")) {
                int j = fileNames[i].lastIndexOf('.');
                System.out.println(fileNames[i].substring(j));
            }
        }
    }
    
    public static void main(String[] args) {
        File dir = new File(".");
        dir.list();
        fileExtension(dir.list());
    }
}
