package hr.fer.oop.predavanja.Rekapitulacija;

import java.util.function.Predicate;

public class QuadrantPredicate implements Predicate<Pair<? extends Number>> {
    private boolean first;
    private boolean second;
    private boolean third;
    private boolean fourth;

    public QuadrantPredicate(boolean first, boolean second, boolean third, boolean fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    @Override
    public boolean test(Pair<? extends Number> pair) {
        double x = pair.getX().doubleValue();
        double y = pair.getY().doubleValue();

        if (x > 0 && y > 0)
            return first ? true : false;
        else if (x < 0 && y > 0)
            return second ? true : false;
        else if (x < 0 && y < 0)
            return third ? true : false;
        else if (x > 0 && y < 0)
            return fourth ? true : false;

        return false;
    }

    @Override
    public String toString() {
        return "(" + first + " ," + second + " ," + third + " ," + fourth + " )";
    }
}
