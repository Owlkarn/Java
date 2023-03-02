// Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. 
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности.

package Homework.Sem_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class task2 {
    private static void employeesList(ArrayList aList) {
        Random rnd = new Random();
        String[] employees = { "Иван", "Елена", "Андрей", "Светлана", "Анна", "Ирина", "Павел", "Сергей", "Петр",
                "Николай" };

        for (int i = 0; i < rnd.nextInt(10, 30); i++) {
            aList.add(employees[rnd.nextInt(0, employees.length - 1)]);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<>();

        employeesList(employees);

        System.out.println(employees);

        Map<String, Integer> employeeRepeat = new HashMap<>();

        for (int i = 0; i < employees.size(); i++) {
            if (employeeRepeat.containsKey(employees.get(i))) {
                int count = employeeRepeat.get(employees.get(i));
                count++;
                employeeRepeat.put(employees.get(i), count);
            } else {
                employeeRepeat.put(employees.get(i), 1);
            }
        }

        System.out.println(employeeRepeat);

        LinkedHashMap<String, Integer> sortedEmployees = new LinkedHashMap<>();

        employeeRepeat.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> sortedEmployees.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> emp : sortedEmployees.entrySet()) {
            System.out.println(emp.getKey() + " - " + emp.getValue());
        }
    }
}
