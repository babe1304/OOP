package hr.fer.oop.labosi.PetiLabos;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.BiFunction;

public class CollectionUtil {

    public static <T, R, S> LinkedList<S> myZip(Collection<T> colla, Collection<R> collb, BiFunction<T,R,S> zipper) {
        if (colla == null || collb == null) throw new NullPointerException();

        LinkedList<S> lista = new LinkedList<>();
        Iterator<T> iteratorA = colla.iterator();
        Iterator<R> iteratorB = collb.iterator();

        while (iteratorA.hasNext() && iteratorB.hasNext()) {
            lista.add(zipper.apply(iteratorA.next(), iteratorB.next()));
        }
        return lista;
    }

    public static void main(String[] args) {
        LinkedList<String> niz = myZip(Arrays.asList("a", "b","c"),
                Arrays.asList("d","e","f"),
                (a,b) -> a+b);
        System.out.println(niz);
        LinkedList<Double> niz2 = myZip(Arrays.asList("fer", "oop", "java", "javadoc"),
                Arrays.asList(2,3,5),
                (a,b) -> a.length() / b.doubleValue());
        System.out.println(niz2);
    }
}
