package Sem_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task2 {
    private static Boolean isomorf(String word1, String word2) {
        Map<Character, Character> words = new HashMap<>();

        if (word1.length() != word2.length())
            return false;
        else {
            for (int i = 0; i < word1.length(); i++)
                if (!words.containsKey(word1.charAt(i)))
                    words.put(word1.charAt(i), word2.charAt(i));
                else if (words.get(word1.charAt(i)) != word2.charAt(i))
                    return false;
        }
        return true;
    }

public static void main(String[] args) {
    System.out.print("Введите слово 1: ");
    Scanner iScanner = new Scanner(System.in);
    String word1 = iScanner.next();

    System.out.print("Введите слово 2: ");
    String word2 = iScanner.next();

    System.out.println(isomorf(word1, word2));
    iScanner.close();
}
}