package hr.fer.oop.predavanja.Rekapitulacija;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ntuple<T extends Comparable<T>> implements Comparable<Ntuple<T>>{
    private ArrayList<T> nTuple;

    public Ntuple(T first, T second,T... elements) {
        this.nTuple = new ArrayList<>();
        nTuple.add(first);
        nTuple.add(second);
        
        for (T element: elements) nTuple.add(element);
    }

    public T get(int index) {
        return nTuple.get(index - 1);
    }

    public void set(int index, T element) {
        nTuple.set(index - 1, element);
    }

    public int size() {
        return nTuple.size();
    }

    @Override
    public String toString() {
        return nTuple.stream()
                .map(t -> t.toString())
                .collect(Collectors.joining(", ", "(", ")"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ntuple<?> ntuple = (Ntuple<?>) o;

        return Objects.equals(this.nTuple, ntuple.nTuple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nTuple);
    }


    @Override
    public int compareTo(Ntuple<T> o) {
        int min = Math.min(size(), o.size());

        for (int i = 1; i < min + 1; i++) {
            if (get(i).compareTo(o.get(i)) != 0)
                return get(i).compareTo(o.get(i));
        }

        return size() - o.size();
    }

    public static void main(String[] args) {
        List<Ntuple<Integer>> list = new ArrayList<>();
        list.add(new Ntuple<>(4, 5, 8, 9));
        list.add(new Ntuple<>(4, 5, 9, 2));
        list.add(new Ntuple<>(3, 6, 2, 7));
        list.add(new Ntuple<>(3, 6, 2, 1));
        list.add(new Ntuple<>(4, 4, 6, 5));
        Ntuple<Integer> tuple = new Ntuple<>(0, 0, 0);
        tuple.set(1, 4);
        tuple.set(2, 4);
        tuple.set(3, 2);
        list.add(tuple);
        list.add(new Ntuple<>(3, 9));
        // list is now: [(4, 5, 8, 9), (4, 5, 9, 2), (3, 6, 2, 7), (3, 6, 2, 1), (4, 4,
        // 6, 5), (4, 4, 2), (3, 9)]
        System.out.println("Before: " + list);
        Collections.sort(list);
        // list is [(3, 6, 2, 1), (3, 6, 2, 7), (3, 9), (4, 4, 2), (4, 4, 6, 5), (4, 5,
        // 8, 9), (4, 5, 9, 2)]
        System.out.println("After: " + list);
        Ntuple<Integer> first = list.get(0);
        System.out.println(new Ntuple<>(3, 6, 2, 1).equals(first)); // true
        System.out.println(first.equals(list.get(1))); // false
        first.set(4, 7);
        System.out.println(first.equals(list.get(1))); // true
        first.set(1, 8); // what would happen in case of first = ...
        Collections.sort(list);
        // [(3, 6, 2, 7), (3, 9), (4, 4, 2), (4, 4, 6, 5), (4, 5, 8, 9), (4, 5, 9, 2),
        // (8, 6, 2, 7)]
        System.out.println("Sorted after the first element was changed:\n " + list);
    }
}
