package hr.fer.oop.work;

import java.util.Scanner;

public class Ucitavanje {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder odabrane_rijeci = new StringBuilder();
        String string;

        while (!(string = sc.nextLine()).equalsIgnoreCase("quit")) {
            System.out.println("Upisi liniju rijeci ");
            string = string.trim();

            String[] skup_rijeci = string.split(" ");
            if (skup_rijeci.length != 0) {
                int random = (int) (Math.random() * skup_rijeci.length);
                odabrane_rijeci.append(skup_rijeci[random].toUpperCase()).append(" ");
                System.out.println(skup_rijeci[random]);
            }

        }

        System.out.println(odabrane_rijeci);
    }

}
