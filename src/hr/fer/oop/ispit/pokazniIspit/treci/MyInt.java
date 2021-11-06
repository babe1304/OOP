package hr.fer.oop.ispit.pokazniIspit.treci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyInt implements Iterable<Integer> {
    private int i;
    List<Integer> numbers = new ArrayList<>();

    public MyInt(int number) {
        this.i = number;

        int djelitelj = 2;
        while (number != 1) {
            while (number % djelitelj == 0) {
                number = number / djelitelj;
                numbers.add(djelitelj);
            }
            djelitelj++;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < numbers.size();
            }

            @Override
            public Integer next() {
                return numbers.get(index++);
            }
        };
    }

    public static void main(String[] args) {
        MyInt num = new MyInt(55660);
        for(Integer i : num){
            System.out.print(" " + i);
        }
        System.out.println();
        MyInt num1 = new MyInt(12);
        for(Integer i : num1){
            for(Integer j : num1){
                System.out.print(" " + i * j);
            }
        }

    }
}