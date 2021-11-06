package hr.fer.oop.helping;

import java.util.*;

class LabTask {
    public static int count(Map<Integer, Integer> map, Set<Integer> set) {
        int rez = 0;

        for (int broj : set) {
            if (map.containsValue(broj)) rez++;
        }
        return rez;
    }

    public static Map<Integer, Set<String>> underpayed(Map<String, Map<Integer, List<Integer>>> salaries) {
        Map<Integer, Map<String, Integer>> prosjecnaPlacaRadnika = new HashMap<>();
        Map<Integer, Integer> poGodini = new HashMap<>();
        int brojOsoba = salaries.size();

        for (String osoba : salaries.keySet()) {
            Map<Integer, List<Integer>> vrijednosti = salaries.get(osoba);

            for (int godina : vrijednosti.keySet()) {
                int suma = 0;
                List<Integer> place = vrijednosti.get(godina);

                for (int i = 0; i < place.size(); i++) {
                    suma += place.get(i);
                }

                if (!poGodini.containsKey(godina)) poGodini.put(godina, suma);
                else poGodini.put(godina, poGodini.get(godina) + suma);


                Map<String, Integer> privremena = new HashMap<>();
                privremena.put(osoba, suma/12);
                prosjecnaPlacaRadnika.put(godina, privremena);

            }
        }

        Map<Integer, Set<String>> rezultat = new HashMap<>();

        for (int godina : prosjecnaPlacaRadnika.keySet()) {
            Map<String, Integer> vrijednosti = prosjecnaPlacaRadnika.get(godina);
            Set<String> underpaid = new HashSet<>();

            for (String name : vrijednosti.keySet()) {
                int prosjecnaPlaca = vrijednosti.get(name);
                if (prosjecnaPlaca < 0.7 * (poGodini.get(godina)/(12 * brojOsoba))) {
                    underpaid.add(name);
                }
            }
            rezultat.put(godina, underpaid);
        }
        return rezultat;

    }
}
