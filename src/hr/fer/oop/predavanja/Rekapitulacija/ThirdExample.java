package hr.fer.oop.predavanja.Rekapitulacija;

import java.util.*;
import java.util.stream.Collectors;

public class ThirdExample {

    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(-5, 12));
        list.add(new Point(3, -4));
        list.add(new Point(12, 9));
        list.add(new Point(3, 4));
        list.add(new Point(4, 3));
        list.add(new Point(-9, 12));
        list.add(new Point(-5, -12));

        System.out.println(list);
        Comparator<Point> pc = new PointComparator();
        list.sort(((o1, o2) -> {
            double d1 = new DistanceFromOrigin().apply(o1);
            double d2 = new DistanceFromOrigin().apply(o2);

            if (Math.abs(d1 - d2) < 1e-8) return 0;
            else if (d1 < d2) return -1;
            else return 1;
        }));
        System.out.println(list);

        Set<Point> set = new TreeSet<>();
        set.add(new Point(-5, 12));
        set.add(new Point(3, -4));
        set.add(new Point(12, 9));
        set.add(new Point(3, 4));
        set.add(new Point(4, 3));
        set.add(new Point(-9, 12));
        set.add(new Point(-5, -12));
        System.out.println(set);

        Comparator<Point> npc = new PointComparator().thenComparing(Comparator.naturalOrder());
        list.sort(npc);
        System.out.println(list);

        List<String> list1 = list.stream().filter(new QuadrantPredicate(true, false, false, false))
                .sorted(new PointComparator().reversed())
                .map(p -> String.format("dist%s = %.2f", p, new DistanceFromOrigin().apply(p)))
                .collect(Collectors.toList());

        System.out.println(list1);

        double prosjek = list.stream().filter(new QuadrantPredicate(true, false, false, false))
                .mapToDouble(p -> new DistanceFromOrigin().apply(p)).average().getAsDouble();
        System.out.println(prosjek);
    }

}
