package hr.fer.oop.work;

import java.util.Locale;

public class Samoglasnici {

    public static void main(String[] args) {
        System.out.println(brojSamoglasnika(args[0]));
    }

    public static int brojSamoglasnika(String str) {
        int rezultat = 0;
        String string = str.toLowerCase();
        String kandidati = "aeiou";

        char[] niz = string.toCharArray();

        for (char c : niz) {
            int broj_slova = (int) c;
            if (kandidati.indexOf(broj_slova) >= 0) rezultat++;
        }
        return rezultat;
    }
}
