package hr.fer.oop.work;

import java.util.Arrays;

public class Loto {

    public static int[] izvlacenje(int kuglice, int izvlacenja) {
        int[] brojevi =  new int[izvlacenja];

        for (int i = 0; i < izvlacenja; i++) {
            brojevi[i] = (int) ((Math.random() * (kuglice -1)) + 1);
        }

        Arrays.sort(brojevi);
        return brojevi;
    }
}
