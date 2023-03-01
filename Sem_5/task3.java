package Sem_5;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task3 {

    private static boolean isValid(String term) {
        Map<Character, Character> hooksDict = new HashMap<>();

        hooksDict.put('(', ')');
        hooksDict.put('{', '}');
        hooksDict.put('[', ']');
        hooksDict.put('<', '>');

        ArrayDeque<Character> hooks = new ArrayDeque<>();

        for (char ch : term.toCharArray()) {
            if (hooksDict.containsKey(ch))
                hooks.add(ch);
            else if (hooksDict.containsValue(ch)) {
                if (hooks.size() == 0)
                    return false;
                else {
                    char hookLast = hooks.removeLast();
                    if (hooksDict.get(hookLast) != ch)
                        return false;
                }
            }
        }
        if (hooks.size() != 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        System.out.print("Введите выражение: ");
        Scanner iScanner = new Scanner(System.in);
        String term = iScanner.next();

        System.out.println(isValid(term));

        iScanner.close();
    }
}
