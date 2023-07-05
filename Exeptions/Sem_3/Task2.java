package Exeptions.Sem_3;

public class Task2 {
    /**
        РЎРѕР·РґР°Р№С‚Рµ РєР»Р°СЃСЃ РЎС‡РµС‚С‡РёРє, Сѓ РєРѕС‚РѕСЂРѕРіРѕ РµСЃС‚СЊ РјРµС‚РѕРґ add(), СѓРІРµР»РёС‡РёРІР°СЋС‰РёР№
        Р·РЅР°С‡РµРЅРёРµ РІРЅСѓС‚СЂРµРЅРЅРµР№ int РїРµСЂРµРјРµРЅРЅРѕР№ РЅР° 1. РЎРґРµР»Р°Р№С‚Рµ С‚Р°Рє, С‡С‚РѕР±С‹ СЃ РѕР±СЉРµРєС‚РѕРј
        С‚Р°РєРѕРіРѕ С‚РёРїР° РјРѕР¶РЅРѕ Р±С‹Р»Рѕ СЂР°Р±РѕС‚Р°С‚СЊ РІ Р±Р»РѕРєРµ try-with-resources. РџРѕРґСѓРјР°Р№С‚Рµ, С‡С‚Рѕ
        РґРѕР»Р¶РЅРѕ РїСЂРѕРёСЃС…РѕРґРёС‚СЊ РїСЂРё Р·Р°РєСЂС‹С‚РёРё СЌС‚РѕРіРѕ СЂРµСЃСѓСЂСЃР°? 
        РќР°РїРёС€РёС‚Рµ РјРµС‚РѕРґ РґР»СЏ РїСЂРѕРІРµСЂРєРё, Р·Р°РєСЂС‹С‚ Р»Рё СЂРµСЃСѓСЂСЃ. 
        РџСЂРё РїРѕРїС‹С‚РєРµ РІС‹Р·РІР°С‚СЊ add() Сѓ Р·Р°РєСЂС‹С‚РѕРіРѕ СЂРµСЃСѓСЂСЃР°, РґРѕР»Р¶РµРЅ РІС‹Р±СЂРѕСЃРёС‚СЊСЃСЏ IOException.
    */

    public static void main(String[] args) {
        try (Counter counter1 = new Counter()){
            System.out.printf("РўРµРєСѓС‰РµРµ Р·РЅР°С‡РµРЅРёРµ СЃС‡С‘С‚С‡РёРєР° %s \n", counter1);
            counter1.add();
            System.out.printf("РўРµРєСѓС‰РµРµ Р·РЅР°С‡РµРЅРёРµ СЃС‡С‘С‚С‡РёРєР° %s \n", counter1);
            counter1.closeCounter();
            counter1.add();
        }
        catch (CloseCounterException e) {
            System.out.printf("РћС€РёР±РєР°: %s", e.getMessage());
        }
    }
}

class Counter implements AutoCloseable{
    private int counter;
    private boolean isOpen;

    public Counter (){
        this.isOpen = true;
        this.counter = 0;
    }

    public Counter (int count){
        this.isOpen = true;
        this.counter = count;
    }

    public int add() throws CloseCounterException{
        if (!isOpen){
            throw new CloseCounterException("РЎС‡С‘С‚С‡РёРє Р·Р°РєСЂС‹С‚");
        }
        return ++counter; // counter++;
    }

    public void closeCounter(){
        this.isOpen = false;
    }

    @Override
    public void close(){
        closeCounter();
    }

    @Override
    public String toString(){
        return "" + this.counter;
    }
}

class CloseCounterException extends Exception{
    public CloseCounterException(String mess){
        super(mess);
    }
}
