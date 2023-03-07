// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.

// Создать множество ноутбуков.

// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
// Критерии фильтрации можно хранить в Map. Например:

// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

package Homework.Sem_6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class task {
    private static Set<Notebook> filterNotebooks(Set<Notebook> notebooks) {
        Map<String, Object> filter = new HashMap<>();

        System.out.println("Введите номера параметров для фильтрации через пробел:\n" +
                "1 - производитель\n" +
                "2 - объем жесткого диска\n" +
                "3 - оперативная память\n" +
                "4 - операционная система\n" +
                "5 - цвет\n" +
                "6 - процессор");
        Scanner iScanner = new Scanner(System.in, "cp866");
        String parameters = iScanner.next();

        if (parameters.contains("1")) {
            Map<Integer, String> breeds = new HashMap<>();
            int i = 1;
            for (Notebook notebook : notebooks) {
                if (!breeds.containsValue(notebook.getBreed())) {
                    breeds.put(i, notebook.getBreed());
                    i++;
                }
            }
            System.out.println("В наличии есть ноутбуки следующих производителей, введите номер нужного:\n" + breeds);
            int filterBreeds = iScanner.nextInt();

            filter.put("breed", breeds.get(filterBreeds));
        }
        else filter.put("breed", null);

        if (parameters.contains("2")) {
            Map<Integer, Integer> memories = new HashMap<>();
            int i = 1;
            for (Notebook notebook : notebooks) {
                if (!memories.containsValue(notebook.getMemory())) {
                    memories.put(i, notebook.getMemory());
                    i++;
                }
            }
            System.out.println("В наличии есть ноутбуки со следующими объемами жесткого диска, введите номер минимально необходимого объема:\n"
            + memories);
            int filterMemory = iScanner.nextInt();

            filter.put("memory", memories.get(filterMemory));
        }
        else filter.put("memory", null);

        if (parameters.contains("3")) {
            Map<Integer, Integer> rams = new HashMap<>();
            int i = 1;
            for (Notebook notebook : notebooks) {
                if (!rams.containsValue(notebook.getRam())) {
                    rams.put(i, notebook.getRam());
                    i++;
                }
            }
            System.out.println("В наличии есть ноутбуки со следующими объемами оперативной памяти, введите номер минимально необходимого объема:\n"
            + rams);
            int filterRam = iScanner.nextInt();

            filter.put("ram", rams.get(filterRam));
        }
        else filter.put("ram", null);

        if (parameters.contains("4")) {
            Map<Integer, String> oss = new HashMap<>();
            int i = 1;
            for (Notebook notebook : notebooks) {
                if (!oss.containsValue(notebook.getOs())) {
                    oss.put(i, notebook.getOs());
                    i++;
                }
            }
            System.out.println("В наличии есть ноутбуки следующими операционными системами, введите номер необходимой ОС:\n"
            + oss);
            int filterOs = iScanner.nextInt();

            filter.put("os", oss.get(filterOs));
        }
        else filter.put("os", null);
        
        if (parameters.contains("5")) {
            Map<Integer, String> colours = new HashMap<>();
            int i = 1;
            for (Notebook notebook : notebooks) {
                if (!colours.containsValue(notebook.getColour())) {
                    colours.put(i, notebook.getColour());
                    i++;
                }
            }
            System.out.println("В наличии есть ноутбуки следующих цветов, введите номер необходимого цвета:\n"
            + colours);
            int filterColour = iScanner.nextInt();

            filter.put("colour", colours.get(filterColour));
        }
        else filter.put("colour", null);

        if (parameters.contains("6")) {
            Map<Integer, String> procs = new HashMap<>();
            int i = 1;
            for (Notebook notebook : notebooks) {
                if (!procs.containsValue(notebook.getProc())) {
                    procs.put(i, notebook.getProc());
                    i++;
                }
            }
            System.out.println("В наличии есть ноутбуки со следующими процессорами, введите номер необходимого процессора:\n"
            + procs);
            int filterProc = iScanner.nextInt();

            filter.put("proc", procs.get(filterProc));
        }
        else filter.put("proc", null);

        Set<Notebook> filterNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            if ((filter.get("breed") == null || notebook.getBreed().equals(filter.get("breed"))) &&
            ((filter.get("memory") == null) || (notebook.getMemory() >= ((int) filter.get("memory")))) &&
            (filter.get("ram") == null || (notebook.getRam() >= ((int) filter.get("ram")))) &&
            (filter.get("os") == null || notebook.getOs().equals(filter.get("os"))) &&
            (filter.get("colour") == null || notebook.getColour().equals(filter.get("colour"))) &&
            (filter.get("proc") == null || notebook.getProc().equals(filter.get("proc")))) {
                filterNotebooks.add(notebook);
            }
        }
        iScanner.close();
        return filterNotebooks;
    }

    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();

        notebooks.add(new Notebook("lenovo", 256, 8, "linux", "black", "intel core i3"));
        notebooks.add(new Notebook("lenovo", 512, 16, "windows", "white", "i core i5"));
        notebooks.add(new Notebook("lenovo", 1024, 32, "windows", "metall", "i core i7"));
        notebooks.add(new Notebook("apple", 256, 8, "macos", "metall", "apple m1"));
        notebooks.add(new Notebook("apple", 512, 16, "macos", "metall", "apple m1 pro"));
        notebooks.add(new Notebook("apple", 1024, 32, "macos", "metall", "apple m2"));
        notebooks.add(new Notebook("huawei", 256, 8, "linux", "black", "amd ryzen 3"));
        notebooks.add(new Notebook("huawei", 512, 16, "windows", "white", "amd ryzen 5"));
        notebooks.add(new Notebook("huawei", 1024, 32, "windows", "metall", "amd ryzen 7"));
        notebooks.add(new Notebook("hp", 256, 8, "linux", "black", "i core i3"));
        notebooks.add(new Notebook("hp", 512, 16, "windows", "white", "i core i5"));
        notebooks.add(new Notebook("hp", 1024, 32, "windows", "metall", "i core i7"));
        notebooks.add(new Notebook("acer", 256, 8, "linux", "black", "amd ryzen 3"));
        notebooks.add(new Notebook("acer", 512, 16, "windows", "white", "amd ryzen 5"));
        notebooks.add(new Notebook("acer", 1024, 32, "windows", "metall", "amd ryzen 7"));

        System.out.println(filterNotebooks(notebooks));
    }

}
