package hr.fer.oop.work;

public class Utils {

    public static int checkPassword(String podatak) {
        if (podatak.length() >= 6) {
            int ocjena = podatak.length();
            int broj_znamenki = 0;
            int broj_Vslova = 0;
            for (char znak : podatak.toCharArray()) {
                if (Character.isDigit(znak)) {
                    broj_znamenki++;
                } else if (Character.isUpperCase(znak)) {
                    broj_Vslova++;
                }
            }
            ocjena += broj_Vslova*2 + broj_znamenki*3;
            if (ocjena < 10) throw new SecurityException("Preslaba šifra!");
            return ocjena;
        } else throw new IllegalArgumentException("Šifra je prekratka!");
    }
}
