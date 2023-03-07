package Sem_6;

import java.time.LocalDate;

public class task3 {
    public static void main(String[] args) {
        Vaccination vaccination = new Vaccination(LocalDate.of(2023, 2, 28), "Bayer", "столбняк");
        System.out.println(vaccination);
        // vaccination.setDate(LocalDate.of(2000, 1, 1));
        System.out.println(vaccination.getDate());

        Cat cat = new Cat("Барсик", "Виктория", "Британец", LocalDate.of(2001, 1, 20), "Белый");
        cat.addVaccination(vaccination);
        cat.addVaccination(new Vaccination(LocalDate.of(2008, 1, 5), "Bayer", "корь"));
        System.out.println(cat);
    }
}
