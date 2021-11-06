package hr.fer.oop.work;

public class Triple<T>  {
    private T first;
    private T second;
    private T third;

    public Triple(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getElement(int broj) {
        if (broj == 1) return first;
        else if (broj == 2) return second;
        else if (broj == 3) return third;
        else {
            throw new IllegalArgumentException("Broj između 1, 2 i 3.");
        }
    }

    public void setElement(int broj, T element) {
        if (broj == 1) this.first = first;
        else if (broj == 2) this.second = second;
        else if (broj == 3) this.third = third;
        else {
            throw new IllegalArgumentException("Broj između 1, 2 i 3.");
        }
    }
}
