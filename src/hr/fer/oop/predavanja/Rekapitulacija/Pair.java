package hr.fer.oop.predavanja.Rekapitulacija;

public class Pair<T extends Comparable<T>> extends Ntuple<T> {

    public Pair(T first, T second) {
        super(first, second);
    }

    public T getX() {
        return this.get(1);
    }

    public T getY() {
        return this.get(2);
    }

    public void setX(T x) {
        set(1, x);
    }

    public void setY(T y) {
        set(2, y);
    }
}
