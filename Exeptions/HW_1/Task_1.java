//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
package Exeptions.HW_1;

public class Task_1 {
    public static void main(String[] args) {
        Task_1 example = new Task_1();
        example.method1();
        example.method2();
        example.method3();
    }

    public void method1() {
        try {
            // Генерация исключения типа ArithmeticException
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Поймано исключение: " + e);
        }
    }

    public void method2() {
        try {
            // Генерация исключения типа NullPointerException
            String str = null;
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println("Поймано исключение: " + e);
        }
    }

    public void method3() {
        try {
            // Генерация собственного исключения типа CustomException
            throw new CustomException("Это мое собственное исключение");
        } catch (CustomException e) {
            System.out.println("Поймано исключение: " + e);
        }
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}