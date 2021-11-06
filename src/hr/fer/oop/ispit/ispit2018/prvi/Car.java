package hr.fer.oop.ispit.ispit2018.prvi;

import java.util.Comparator;
import java.util.List;

public class Car {

    private String name;
    private CarType type;
    private int maxSpeed;
    private int power;
    private double consuption;
    private double price;

    public Car(String name, CarType type, int maxSpeed, int power, double consuption, double price) {
        this.name = name;
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.power = power;
        this.consuption = consuption;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setConsuption(double consuption) {
        this.consuption = consuption;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public CarType getType() {
        return type;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getPower() {
        return power;
    }

    public double getConsumption() {
        return consuption;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s %s %dKS, max speed: %d, %.2f/100km, %.2fKn",
                getName(), getType(),getPower(), getMaxSpeed(),
                getConsumption(), getPrice());

    }
    public static void main(String[] args) {
        List<Car> list = CarCatalog.loadCars();

        list.stream().sorted(Comparator.comparing(Car::getPrice).reversed()).forEach(System.out::println);

        list.stream().filter((car) -> car.getType() == CarType.PETROL).mapToDouble(Car::getPrice).average().ifPresent(n -> System.out.println(n));
    }

}
