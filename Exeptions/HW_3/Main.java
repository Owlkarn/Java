// Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
// Фамилия Имя Отчество номертелефона

// Форматы данных:
// фамилия, имя, отчество - строки
// номертелефона - целое беззнаковое число без форматирования

// Ввод всех элементов через пробел

// Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, 
// обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
// Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, 
// пользователю выведено сообщение с информацией, что именно неверно.

// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
// в него в одну строку должны записаться полученные данные, вида

// <Фамилия><Имя><Отчество><номер_телефона>

// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

// Не забудьте закрыть соединение с файлом.

// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
// пользователь должен увидеть стектрейс ошибки.

package Exeptions.HW_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        finalTask();
    }

    public static void finalTask() {
        boolean getCorrectData = false;
        String[] fiot = getArray();
        while (!getCorrectData) {
            if (countCheck(fiot) == -1) {
                System.out.println("Введено больше 4 элементов");
                fiot = getArray();
            } else if (countCheck(fiot) == -2) {
                System.out.println("Введено меньше 4 элементов");
                fiot = getArray();
            } else
                getCorrectData = true;
        }

        try {
            fileWriteFioNum(telephoneTypeCheck(fiot), fioTypeCheck(fiot));
        } catch (WrongTypeException e) {
            System.out.println(e.getMessage() + " " + e.getNum());
            finalTask();
        } catch (MyFileNotFoundException e) {
            System.out.println(e.getMessage() + " " + e.getFileName());
            finalTask();
        }
    }

    public static String[] getArray() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ФИО и номер телефона через пробел: ");
        return scan.nextLine().split(" ");
    }

    public static int countCheck(String[] arr) {
        if (arr.length > 4)
            return -1;
        if (arr.length < 4)
            return -2;

        return 0;
    }

    public static int telephoneTypeCheck(String[] arr) throws WrongTypeException {
        try {
            return Integer.parseInt(arr[3]);
        } catch (NumberFormatException e) {
            throw new WrongTypeException("Введено некорректное значение", arr[3]);
        }
    }

    public static String[] fioTypeCheck(String[] arr) throws WrongTypeException {
        boolean containsNumber = false;
        int n = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (char c : arr[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    containsNumber = true;
                    n = i;
                    break;
                }
            }
        }

        if (containsNumber) {
            throw new WrongTypeException("Введено некорректное значение", arr[n]);
        } else {
            String[] fio = new String[3];
            for (int i = 0; i < arr.length - 1; i++) {
                fio[i] = arr[i];
            }
            return fio;
        }
    }

    public static boolean fileExists(String surname) {
        String fileName = surname + ".txt";
        File file = new File(fileName);
        if (file.exists())
            return true;
        return false;

    }

    public static void fileWriteFioNum(int telNum, String[] fio) throws MyFileNotFoundException {
        if (fileExists(fio[0])) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fio[0] + ".txt", true))) {
                bufferedWriter.write("<" + fio[0] + ">" + "<" + fio[1] + ">" + "<" + fio[2] + ">" + "<" + telNum + ">");
                bufferedWriter.newLine();
                System.out.println("Файл дополнен!");
            } catch (IOException e) {
                throw new MyFileNotFoundException("Нет доступа к файлу ", fio[0] + ".txt");
            }
        } else {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fio[0] + ".txt"))) {
                bufferedWriter.write("<" + fio[0] + ">" + "<" + fio[1] + ">" + "<" + fio[2] + ">" + "<" + telNum + ">");
                bufferedWriter.newLine();
                System.out.println("Файл создан!");
            } catch (IOException e) {
                throw new MyFileNotFoundException("Нет доступа к файлу ", fio[0] + ".txt");
            }
        }
    }
}

class WrongTypeException extends Exception {
    private String num;

    public WrongTypeException(String message, String num) {
        super(message);
        this.num = num;
    }

    public String getNum() {
        return num;
    }
}

class MyFileNotFoundException extends IOException {
    private String fileName;

    public MyFileNotFoundException(String mess, String fileName) {
        super(mess);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
