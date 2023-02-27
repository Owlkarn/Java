package Sem_4;

import java.util.LinkedList;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        String string = "";
        LinkedList<String> lList = new LinkedList<>();
        while (true) {
            System.out.print("Введите текст в виде text~num: ");
            Scanner iScanner = new Scanner(System.in, "cp866"); // для русского языка
            string = iScanner.nextLine();
            if (!string.equals("exit")) {
                String[] aList = string.split("~");
                int num = 0;
                try {
                    num = Integer.valueOf(aList[1]);
                } catch (NumberFormatException e) {
                }

                while (lList.size() < num+1) {
                    lList.add(null);
                }

                if (!aList[0].equals("print")) {
                    lList.add(num, aList[0]);
                } else if (lList.get(num) == null) {
                    System.out.println("Данная позиция пуста");
                } else {
                    System.out.println(lList.get(num));
                    lList.add(num, null);
                    lList.remove(num+1);
                }
            } else
                break;
            System.out.println(lList);
            iScanner.close();
        }

    }

}
