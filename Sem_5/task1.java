package Sem_5;

import java.util.HashMap;
import java.util.Map;

public class task1 {
    public static void main(String[] args) {
        Map<Integer, String> passportToName = new HashMap<>();
        passportToName.put(123456, "Иванов");
        passportToName.put(654321, "Васильев");
        passportToName.put(345216, "Петрова");
        passportToName.put(645312, "Иванов");
        passportToName.put(874563, "Петрова");
        passportToName.put(567843, "Иванов");

        System.out.println(passportToName);

        for (Map.Entry<Integer, String> entry : passportToName.entrySet())
            if (entry.getValue().equals("Иванов"))
                System.out.println(entry);
    }
}
