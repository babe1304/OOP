package hr.fer.oop.labosi.samostalni;

import java.util.Iterator;

public class FactorialIterator implements Iterator<Integer> {
    private int factorial;
    private int counter;
    private int end;

    public FactorialIterator() {
        this.factorial = 1;
        this.counter = 0;
        this.end = 0;
    }
    public FactorialIterator(int end) throws IllegalArgumentException {
        if (end >= 0) {
            this.end = end;
            this.counter = 0;
            this.factorial = 1;
        } else throw new IllegalArgumentException();
    }

    @Override
    public boolean hasNext() {
        if (end == 0 && counter == 0) return true;
        return counter < end;
    }

    @Override
    public Integer next() {
        if (counter != 0) this.factorial = factorial * counter;

        this.counter++;
        return factorial;
    }
}
