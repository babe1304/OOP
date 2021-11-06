package hr.fer.oop.labosi;

public class Peppa {
    static String[] names;

    public Peppa(String[] names) {
        this.names = names;
    }

    public static String[] getAllCharacters() {
        return names;
    }
}
