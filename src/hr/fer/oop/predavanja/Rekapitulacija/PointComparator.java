package hr.fer.oop.predavanja.Rekapitulacija;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
    private static DistanceFromOrigin DFO = new DistanceFromOrigin();

    @Override
    public int compare(Point o1, Point o2) {
        double d1 = DFO.apply(o1);
        double d2 = DFO.apply(o2);

        if (Math.abs(d1 - d2) < 1e-8) return 0;
        else if (d1 < d2) return -1;
        else return 1;
    }
}
