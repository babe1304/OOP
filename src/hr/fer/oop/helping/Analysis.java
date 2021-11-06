package hr.fer.oop.helping;

import java.util.function.Predicate;

public class Analysis {

    public static Predicate<Earthquake> newerThan(int year) {
        return (earthquake -> {
          String[] date = earthquake.getDate().split("-");

          if (Integer.valueOf(date[0]) <= year) return false;
          return true;
        });
    }

    public static Predicate<Earthquake> byCityName(String cityName) {
        return (earthquake ->
           cityName.equals(earthquake.getCityName())
        );
    }

    public static Predicate<Earthquake> byMagnitudeAndDepth(int depth, double magnitude) {
        return (earthquake ->
           earthquake.getMagnitude() > magnitude && earthquake.getDepth() > depth
        );
    }
}
