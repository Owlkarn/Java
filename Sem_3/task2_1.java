package Sem_3;

import java.util.ArrayList;
import java.util.Random;

public class task2_1 {
    public static void main(String[] args) {
        String[] planets = { "Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун", "Плутон" };
        ArrayList<String> planetList = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 20; i++) {
            planetList.add(planets[rnd.nextInt(planets.length)]);
        }
        System.out.println(planetList);

        // for (int i = 0; i < planets.length; i++) {
        // int count = 0;
        // for (int j = 0; j < planetList.size(); j++) {
        // if (planets[i].equals(planetList.get(j))) {
        // count++;
        // }
        // }
        // System.out.printf("%s встречается %s раз(а)\n", planets[i], count);
        // }

        ArrayList<String> uniquePlanets = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        countRepeats(planetList, uniquePlanets, counts);
        printPlanetsCounts(uniquePlanets, counts);
    }

    private static void countRepeats(ArrayList<String> planetList, ArrayList<String> uniquePlanets,
            ArrayList<Integer> counts) {
        for (String planet : planetList) {
            int pos = uniquePlanets.indexOf(planet);
            if (pos >= 0) {
                counts.set(pos, counts.get(pos) + 1);
            } else {
                uniquePlanets.add(planet);
                counts.add(1);
            }
        }
    }

    private static void printPlanetsCounts(ArrayList<String> uniquePlanets, ArrayList<Integer> counts) {
        for (int i = 0; i < uniquePlanets.size(); i++) {
            System.out.printf("%-10s %3d \n", uniquePlanets.get(i), counts.get(i));
        }

    }

}
