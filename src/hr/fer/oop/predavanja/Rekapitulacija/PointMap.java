package hr.fer.oop.predavanja.Rekapitulacija;

import java.util.*;

public class PointMap {

    public static Map<Integer, Set<Point>> mapPoints(List<Point> list) {
        Map<Integer, Set<Point>> rez = new TreeMap<>();
        QuadrantPredicate first = new QuadrantPredicate(true, false, false , false);
        QuadrantPredicate second = new QuadrantPredicate(false, true, false , false);
        QuadrantPredicate thrid = new QuadrantPredicate(false, false, true , false);
        QuadrantPredicate fourth = new QuadrantPredicate(false, false, false , true);

        for (Point point : list) {
            if (first.test(point)) {
                if (!rez.containsKey(1)) {
                    Set<Point> points = new TreeSet<>(new PointComparator().thenComparing(Comparator.naturalOrder()));
                    points.add(point);
                    rez.put(1, points);
                } else {
                    Set<Point> points = rez.get(1);
                    points.add(point);
                    rez.put(1, points);
                }
            } else if (second.test(point)) {
                if (!rez.containsKey(2)) {
                    Set<Point> points = new TreeSet<>(new PointComparator().thenComparing(Comparator.naturalOrder()));
                    points.add(point);
                    rez.put(2, points);
                } else {
                    Set<Point> points = rez.get(2);
                    points.add(point);
                    rez.put(2, points);
                }
            } else if (thrid.test(point)) {
                if (!rez.containsKey(3)) {
                    Set<Point> points = new TreeSet<>(new PointComparator().thenComparing(Comparator.naturalOrder()));
                    points.add(point);
                    rez.put(3, points);
                } else {
                    Set<Point> points = rez.get(3);
                    points.add(point);
                    rez.put(3, points);
                }
            } else if (fourth.test(point)) {
                if (!rez.containsKey(4)) {
                    Set<Point> points = new TreeSet<>(new PointComparator().thenComparing(Comparator.naturalOrder()));
                    points.add(point);
                    rez.put(4, points);
                } else {
                    Set<Point> points = rez.get(4);
                    points.add(point);
                    rez.put(4, points);
                }
            }
        }
        return rez;
    }

    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(-5, 12));
        list.add(new Point(3, -4));
        list.add(new Point(12, 9));
        list.add(new Point(3, 4));
        list.add(new Point(4, 3));
        list.add(new Point(-9, 12));
        list.add(new Point(-5, -12));

        Map<Integer, Set<Point>> map = mapPoints(list);
        System.out.println(map);

        Map<Integer, Set<Point>> map1 = new TreeMap<>();
        Comparator<Point> comp = new PointComparator().thenComparing(Comparator.naturalOrder());

        map1.put(1, new TreeSet<>(comp));
        map1.put(2, new TreeSet<>(comp));
        map1.put(3, new TreeSet<>(comp));
        map1.put(4, new TreeSet<>(comp));

        for (Point p : list) {
            int quadrant = DetectQuadrant(p);
            if (quadrant != 0)
                map1.getOrDefault(quadrant, new TreeSet<>(comp)).add(p);
        }

        System.out.println(map1);
    }

    public static int DetectQuadrant(Point p) {
        if (p.getX().doubleValue() > 0 && p.getY().doubleValue() > 0) return 1;
        else if (p.getX().doubleValue() < 0 && p.getY().doubleValue() > 0) return 2;
        else if (p.getX().doubleValue() < 0 && p.getY().doubleValue() < 0) return 3;
        else if (p.getX().doubleValue() > 0 && p.getY().doubleValue() < 0) return 4;

        return 0;
    }
}
