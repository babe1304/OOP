package hr.fer.oop.work;

public class StringFloss {

    public static void main(String[] args){
        System.out.println(StringFloss.stringFloss(args));
    }

    static String stringFloss(String[] elements) {
        StringBuilder kandidat = new StringBuilder();
        int naj = 0;

        for (String string : elements) {
            if (string.length() > naj) {
                naj = string.length();
            }
        }

        for (int i = 0; i < naj; i++) {
            for (String string : elements) {
                if (string.length() > i) kandidat.append(string.charAt(i));
            }
        }
        String rezultat = kandidat.toString();
        return rezultat;
    }
}
