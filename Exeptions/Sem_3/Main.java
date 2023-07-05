package Exeptions.Sem_3;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Main
 */
public class Main {
    /* 
     *     1.  РЎРѕР·РґР°Р№С‚Рµ РєР»Р°СЃСЃ РёСЃРєР»СЋС‡РµРЅРёСЏ, РєРѕС‚РѕСЂС‹Р№ Р±СѓРґРµС‚ РІС‹Р±СЂР°СЃС‹РІР°С‚СЊСЃСЏ РїСЂРё РґРµР»РµРЅРёРё РЅР°
     *         0. РСЃРєР»СЋС‡РµРЅРёРµ РґРѕР»Р¶РЅРѕ РѕС‚РѕР±СЂР°Р¶Р°С‚СЊ РїРѕРЅСЏС‚РЅРѕРµ РґР»СЏ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ СЃРѕРѕР±С‰РµРЅРёРµ
     *         РѕР± РѕС€РёР±РєРµ.
     *     2.  РЎРѕР·РґР°Р№С‚Рµ РєР»Р°СЃСЃ РёСЃРєР»СЋС‡РµРЅРёР№, РєРѕС‚РѕСЂРѕРµ Р±СѓРґРµС‚ РІРѕР·РЅРёРєР°С‚СЊ РїСЂРё РѕР±СЂР°С‰РµРЅРёРё Рє
     *         РїСѓСЃС‚РѕРјСѓ СЌР»РµРјРµРЅС‚Сѓ РІ РјР°СЃСЃРёРІРµ СЃСЃС‹Р»РѕС‡РЅРѕРіРѕ С‚РёРїР°. РСЃРєР»СЋС‡РµРЅРёРµ РґРѕР»Р¶РЅРѕ
     *         РѕС‚РѕР±СЂР°Р¶Р°С‚СЊ РїРѕРЅСЏС‚РЅРѕРµ РґР»СЏ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ СЃРѕРѕР±С‰РµРЅРёРµ РѕР± РѕС€РёР±РєРµ
     *     3.  РЎРѕР·РґР°Р№С‚Рµ РєР»Р°СЃСЃ РёСЃРєР»СЋС‡РµРЅРёСЏ, РєРѕС‚РѕСЂРѕРµ Р±СѓРґРµС‚ РІРѕР·РЅРёРєР°С‚СЊ РїСЂРё РїРѕРїС‹С‚РєРµ РѕС‚РєСЂС‹С‚СЊ
     *         РЅРµСЃСѓС‰РµСЃС‚РІСѓСЋС‰РёР№ С„Р°Р№Р». РСЃРєР»СЋС‡РµРЅРёРµ РґРѕР»Р¶РЅРѕ РѕС‚РѕР±СЂР°Р¶Р°С‚СЊ РїРѕРЅСЏС‚РЅРѕРµ РґР»СЏ
     *         РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ СЃРѕРѕР±С‰РµРЅРёРµ РѕР± РѕС€РёР±РєРµ.
     * */
    
    public static void main(String[] args) {
        // try{
        //    task1(); 
        // }
        // catch (DivisionByZeroException e){
        //     System.out.println(e.getMessage());
        // }

        // try {
        //     task2(new String[]{"1", "2", "3", "4", null, "6"}, 2);
        // }
        // catch (NullElementArrayException e){
        //     System.out.printf("%s \nР•РіРѕ РёРЅРґРµРєСЃ: %d", e.getMessage(), e.getIndex());
        // }

        try {
            task3("C:\\test\\test.txt");
        }
        catch (MyFileNotFoundException e){
            System.out.printf("%s : %s", e.getMessage(), e.getFileName());
        }
    }

    public static void task1(){
        try{
            int a = 5/0;
        }
        catch (ArithmeticException e){
            throw new DivisionByZeroException("РћС€РёР±РєР° РґРµР»РµРЅРёСЏ РЅР° 0");
        }

    }

    public static void task2(String[] arr, int index){
        try {
            if (arr[index] == null){
                throw new NullElementArrayException("Р­Р»РµРјРµРЅС‚Р° РјР°СЃСЃРёРІР° РЅРµ РїСЂРѕРёРЅРёС†РёР°Р»РёР·РёСЂРѕРІР°РЅ", index);
            }          
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public static void task3(String fileName) throws MyFileNotFoundException{
        // FileReader fileReader = null;
        try (FileReader fileReader = new FileReader(fileName)){
            // fileReader = new FileReader(fileName);
            char[] buf = new char[4];
            fileReader.read(buf);
            for (int i = 0; i < buf.length; i++) {
                System.out.println(buf[i]);
            }
            // 1 2 3 4 5 6 7 8 9
            // buf = 1 2 3 4 5 6
            // buf = 
            // fileReader.read(buf);
            // System.out.println();
            // // buf = 7 8 9 4 5 6
            // for (int i = 0; i < buf.length; i++) {
            //     System.out.println(buf[i]);
            // }
        }
        catch (FileNotFoundException e){
            throw new MyFileNotFoundException("Р¤Р°Р№Р» РЅРµ РЅР°Р№РґРµРЅ", fileName);
        }
        catch (Exception e){
            System.out.println("РћС€РёР±РєР° С‡С‚РµРЅРёСЏ");
        }
        // finally{
        //     try {
        //         fileReader.close(); 
        //     }
        //     catch (Exception ex){
        //         System.out.println(ex.getMessage());
        //     } 
        // }


    }
}

class DivisionByZeroException extends ArithmeticException{
    public DivisionByZeroException(String mess){
        super(mess);
    }
}

class NullElementArrayException extends RuntimeException{
    private int index;

    public NullElementArrayException(String mess, int index){
        super(mess);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}

class MyFileNotFoundException extends Exception{
    private String fileName;

    public MyFileNotFoundException(String mess, String fileName){
        super(mess);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}