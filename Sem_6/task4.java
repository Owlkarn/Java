package Sem_6;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class task4 {
    public static void main(String[] args) {
        Set<Cat> myCats = new HashSet<>();

        myCats.add(new Cat("Барсик", "Артем", "Дворняга",
                LocalDate.of(2000, 6, 15), "Рыжий"));
        myCats.add(new Cat("Барсик", "Артем", "Дворняга",
                LocalDate.of(2000, 6, 15), "Рыжий"));
        myCats.add(new Cat("Тайсон", "Артем", "Дворняга",
                LocalDate.of(2000, 6, 15), "Рыжий"));
        myCats.add(new Cat("Пушистик", "Ярослав", "Шотландская",
                LocalDate.of(2022, 1, 11), "Черно-белый"));

        System.out.println(myCats);
    }
}
