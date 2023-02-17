// В файле содержится строка с данными:
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package Homework.Sem_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task3 {

    private static String readFile(String fileName) {
        String line = null;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);

            line = reader.readLine();

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static void main(String[] args) {
        String line = readFile("hw2_task3.txt");
        line = line.substring(1, line.length() - 1);
        String[] lineParts = line.split(", ");

        for (int i = 0; i < lineParts.length; i++) {
            lineParts[i] = lineParts[i].substring(1, lineParts[i].length() - 1);
            String[] linePartsPares = lineParts[i].split(",");
            StringBuilder finalLine = new StringBuilder("Студент");

            for (int j = 0; j < linePartsPares.length; j++) {
                String[] linePartsSolo = linePartsPares[j].split(":");
                if (j == 0) {
                    linePartsSolo[1] = linePartsSolo[1].substring(1, linePartsSolo[1].length() - 1);
                    finalLine.append(" " + linePartsSolo[1] + " получил");
                }
                if (j == 1) {
                    linePartsSolo[1] = linePartsSolo[1].substring(1, linePartsSolo[1].length() - 1);
                    finalLine.append(" " + linePartsSolo[1] + " по предмету");
                }
                if (j == 2) {
                    linePartsSolo[1] = linePartsSolo[1].substring(1, linePartsSolo[1].length() - 1);
                    finalLine.append(" " + linePartsSolo[1]);
                }
            }
            System.out.println(finalLine);
        }
    }
}
