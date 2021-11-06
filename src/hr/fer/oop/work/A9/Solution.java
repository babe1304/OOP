package hr.fer.oop.work.A9;

import java.util.*;

public class Solution {

    public static List<List<String>> groupAnagrams(String[] input) {
        Set<String> anagrami = new HashSet<>();
        List<List<String>> rez = new ArrayList<>();

        for (String rijec : input) {
            Set<Character> slova = new TreeSet<>();

            for (Character c : rijec.toCharArray()) slova.add(c);

            StringBuilder anagram = new StringBuilder();
            for (Character c : slova) anagram.append(c);

            anagrami.add(anagram.toString());
        }

        for (String anagram1 : anagrami) {
            List<String> skup = new ArrayList<>();

            for (int i = 0; i < input.length; i++) {
                Set<Character> slova = new TreeSet<>();

                for (Character c : input[i].toCharArray()) slova.add(c);

                StringBuilder anagram = new StringBuilder();
                for (Character c : slova) anagram.append(c);

                String usporedni = anagram.toString();

                if (usporedni.equals(anagram1)) skup.add(input[i]);
            }
            rez.add(skup);
        }

        return rez;
    }

}
