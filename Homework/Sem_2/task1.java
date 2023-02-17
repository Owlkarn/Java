// В файле содержится строка с исходными данными в такой форме:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
// Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.

package Homework.Sem_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task1 {

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
        String line = readFile("hw2_task1.txt");
        line = line.substring(1, line.length() - 1);
        String[] lineParts = line.split(", ");

        StringBuilder finalLine = new StringBuilder("SELECT * FROM students WHERE");

        for (int i = 0; i < lineParts.length; i++) {

            if (!lineParts[i].contains("null")) {
                String[] part = lineParts[i].split(":");
                part[0] = part[0].substring(1, part[0].length() - 1);

                if (i == 0)
                    finalLine.append(" " + part[0] + " = " + part[1]);

                else
                    finalLine.append(" AND " + part[0] + " = " + part[1]);
            }
        }
        System.out.println(finalLine);
    }
}
