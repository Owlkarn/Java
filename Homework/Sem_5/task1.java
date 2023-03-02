// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.

package Homework.Sem_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class task1 {

    private static void insertNumbers(ArrayList name) {
        Random rnd = new Random();

        for (int i = 0; i < rnd.nextInt(1, 4); i++) {
            name.add(rnd.nextInt(100000, 999999));
        }
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();

        ArrayList<Integer> ivan = new ArrayList<>();
        insertNumbers(ivan);

        ArrayList<Integer> petr = new ArrayList<>();
        insertNumbers(petr);

        ArrayList<Integer> sveta = new ArrayList<>();
        insertNumbers(sveta);

        ArrayList<Integer> kolia = new ArrayList<>();
        insertNumbers(kolia);

        ArrayList<Integer> lena = new ArrayList<>();
        insertNumbers(lena);

        phoneBook.put("иван", ivan);
        phoneBook.put("петр", petr);
        phoneBook.put("светлана", sveta);
        phoneBook.put("николай", kolia);
        phoneBook.put("елена", lena);

        System.out.print("Введите имя: ");
        Scanner iScanner = new Scanner(System.in, "cp866");
        String name = iScanner.next();

        System.out.println(phoneBook.get(name.toLowerCase()));
    }
}
