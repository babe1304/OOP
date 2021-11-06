package hr.fer.oop.ispit.ispit2017.drugi;

import java.util.Comparator;
import java.util.Objects;

public class Car implements Comparable<Car> {
    private String manufacturer;
    private String model;
    private String id;
    private float power;
    Politician owner;

    public static final Comparator<Car> BY_MANUFACTURER = (c1, c2) -> c1.getManufacturer().compareTo(c2.getManufacturer());
    public static final Comparator<Car> BY_ID = (c1, c2) -> c1.getId().compareTo(c2.getId());
    public static final Comparator<Car> BY_OWNER = (c1, c2) -> c1.getOwner().compareTo(c2.getOwner());

    public Car(String manufacturer, String model, String id, float power,
               Politician owner) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.id = id;
        this.power = power;
        this.owner = owner;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof Car)) return false;
        Car car = (Car) other;
        return getId().equals(car.getId());
    }

    @Override
    public int hashCode() {
        return (getId() == null) ? 0 : getId().hashCode();
    }

    @Override
    public int compareTo(Car car) {
        return Objects.compare(this, car, BY_ID);
    }

    @Override
    public String toString() {
        return "Car{" + "manufacturer=" + manufacturer + ", model=" + model + ", id=" + id + ", power=" + power + ", owner=" + owner + '}';
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public Politician getOwner() {
        return owner;
    }

    public void setOwner(Politician owner) {
        this.owner = owner;
    }
}
