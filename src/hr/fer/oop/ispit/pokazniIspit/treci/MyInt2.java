package hr.fer.oop.ispit.pokazniIspit.treci;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyInt2 implements Iterable<Integer> {
    private int i;

    public MyInt2(int number) {
        this.i = number;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIntIterator();
    }


    private class MyIntIterator implements Iterator<Integer> {
            private int i;
            private int djelitelj = 2;

            public MyIntIterator() {
                this.i = i;
            }
            @Override
            public boolean hasNext() {
                return i != 1;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();

                while (i % djelitelj != 0) djelitelj++;

                i /= djelitelj;

                return djelitelj;
            }
    }

    public static void main(String[] args) {
        MyInt2 num = new MyInt2(55660);
        for(Integer i : num){
            System.out.print(" " + i);
        }
        System.out.println();
        MyInt2 num1 = new MyInt2(12);
        for(Integer i : num1){
            for(Integer j : num1){
                System.out.print(" " + i * j);
            }
        }
    }

}
