package Exeptions.Sem_2;

import java.util.Random;

/**
 * Main
 */
public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("РС‚РµСЂР°С†РёСЏ " + (i + 1));
            processArray();
        }
    }

    public static void processArray(){
        try{
            System.out.printf("РЎСѓРјРјР° РІСЃРµС… СЌР»РµРјРµРЅС‚РѕРІ РјР°СЃСЃРёРІР°: %d", processArrayInternal(generateArray()));
        }
        catch (MyArrayDataException e){
            System.out.printf("%s \nР­Р»РµРјРµРЅС‚ РїРѕРґ РёРЅРґРµРєСЃРѕРј [%d][%d]\n", e.getMessage(), e.getX(), e.getY());
        }
        catch (MyArraySizeException e){
            System.out.printf("%s \nРўСЂРµР±СѓРµС‚СЃСЏ РІРІРµСЃС‚Рё РјР°СЃСЃРёРІ 4x4, РїРѕР»СѓС‡РёР»Рё %d x %d", e.getMessage(), e.getX(), e.getY());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println();
            System.out.println("Р—Р°РІРµСЂС€РµРЅРёРµ РѕР±СЂР°Р±РѕС‚РєРё ---------------");
            System.out.println();
            System.out.println();
        }
    }

    public static String[][] generateArray(){
        int add = random.nextInt(2);
        String[][] arr = new String[4][4 + add];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (random.nextInt(35) == 1){
                    arr[i][j] = "aaa";
                }
                else{
                    arr[i][j] = Integer.toString(random.nextInt(10));
                }
                System.out.printf("%s ", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }

    public static int processArrayInternal(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        if (arr.length != 4 || arr[0].length != 4){
            throw new MyArraySizeException("РќРµРєРѕСЂСЂРµРєС‚РЅС‹Р№ СЂР°Р·РјРµСЂ РјР°СЃСЃРёРІР°", arr.length, arr[0].length);
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum += parseElement(arr[i][j], i, j);
            }
        }
        return sum;
    }

    public static int parseElement(String stroka, int i, int j) throws MyArrayDataException{
        try{
            return Integer.parseInt(stroka);
        }
        catch (NumberFormatException e){
            throw new MyArrayDataException("РќРµРєРѕСЂСЂРµРєС‚РЅС‹Р№ С„РѕСЂРјР°С‚ РґР°РЅРЅС‹С…", i, j);
        }
    }
}

abstract class MyException extends Exception{
    private final int x;
    private final int y;

    public MyException(String message, int x, int y){
        super(message);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class MyArraySizeException extends MyException{
    public MyArraySizeException(String message, int x, int y){
        super(message, x, y);
    }
}

class MyArrayDataException extends MyException{
    public MyArrayDataException(String message, int x, int y){
        super(message, x, y);
    }
}