package Sem_2;

import java.util.Scanner;

public class task2 {
    public static Boolean palindromString(String normalString) {
        normalString = normalString.replaceAll(" ", "");
        String reverseString = new StringBuilder(normalString).reverse().toString();
        return normalString.equalsIgnoreCase(reverseString);
    }
    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        Scanner iScanner = new Scanner(System.in, "cp866");
        String normalString = iScanner.nextLine();

        System.out.println(palindromString(normalString));

        iScanner.close();

    }
}

// public static void main(String[] args) {
//     Scanner scanner = new Scanner(System.in);
//     System.out.println("Введите строку: ");
//     String str = scanner.nextLine();
    
//     System.out.println(isPalindrome(str));
    
//     scanner.close();
//     }
    
//     private static boolean isPalindrome(String str) {
//     for (int i = 0; i < str.length() - i; i++) {
//     if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
//     return false;
//     }
//     }
//     return true;
//     }
