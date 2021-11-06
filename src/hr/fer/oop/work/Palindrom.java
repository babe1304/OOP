package hr.fer.oop.work;

public class Palindrom {

    public static void main(String[] args) {
        System.out.println(jePalindrom(args[0]));
    }

    public static boolean jePalindrom(String s) {
        StringBuilder novi_s = new StringBuilder();
        s = s.toLowerCase().trim().replace(" ", "");

        for (int i = s.length() - 1; i >= 0; i--) {
            novi_s.append(s.charAt(i));
        }

        String uspordni = novi_s.toString();
        return (s.compareTo(uspordni) == 0);
    }
}
