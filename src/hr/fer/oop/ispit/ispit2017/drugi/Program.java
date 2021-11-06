package hr.fer.oop.ispit.ispit2017.drugi;

import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Politician> politicians = DBLoader.loadPoliticians();
        List<Car> cars = DBLoader.loadCars();
        Collections.sort(politicians);
        for (Politician politician : politicians) {
            System.out.println(politician.toString());
        }
        System.out.println("End of first example");

        cars.stream().sorted(Car.BY_ID).forEach(c -> System.out.println(c));

        System.out.println("=====================================");
        cars.stream().sorted(Car.BY_MANUFACTURER.reversed().thenComparing(Car.BY_OWNER)).forEach(c -> System.out.println(c));
    }
}
