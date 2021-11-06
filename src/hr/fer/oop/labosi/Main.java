package hr.fer.oop.labosi;

public class Main {

    public static void main(String[] args) {
        KeyValue<Integer, Integer> rez = KeyValue.min(new Integer[] { 2, 5, 7, -4, -4, 4, 6, -4, 22, 1, 2, 2, 2});
        System.out.println(rez.getKey());
        System.out.println(rez.getValue());
    }
}
