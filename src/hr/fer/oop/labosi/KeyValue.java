package hr.fer.oop.labosi;

public class KeyValue<K, V> {
    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static <T extends Comparable<T>> KeyValue<T, Integer> min(T[] polje) {
        if (polje.length == 0 || polje == null) return null;

        T najmanji = polje[0];
        int brojPojavljivanja = 0;
        for (int i = 1; i < polje.length; i++) {
            if (najmanji.compareTo(polje[i]) > 0) {
                najmanji = polje[i];
            }
        }
        for (int i = 0; i < polje.length; i++) {
            if (najmanji.compareTo(polje[i]) == 0) brojPojavljivanja++;
        }
        return new KeyValue<>(najmanji, brojPojavljivanja);
    }
}
