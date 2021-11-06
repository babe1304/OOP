package hr.fer.oop.predavanja.Rekapitulacija;

import java.util.function.Function;

public class DistanceFromOrigin implements Function<Pair<? extends Number>, Double> {

    @Override
    public Double apply(Pair<? extends Number> pair) {
        return Math.sqrt(Math.pow(pair.getX().doubleValue() , 2) + Math.pow(pair.getY().doubleValue(), 2));
    }
}
