package hr.fer.oop.ispit.pokazniIspit.prvi;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Driver {
    private String name;
    private String surname;
    private String adress;
    private long pid;

    public Driver(String name, String surname, String adress, long pid) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.pid = pid;
    }

    public static void main(String[] args) {
        Set<Driver> driverSet = DBLoader.loadDrivers();

        driverSet.stream().filter(d -> d.getAdress().toString().contains("Zagreb"))
                .sorted((d1, d2) -> (int) (d1.getPid() - d2.getPid()))
                .forEach(d -> System.out.println(d));

        Set<Long> set = driverSet.stream().filter(d -> d.getName().startsWith("M"))
                .map(d -> d.getPid())
                .collect(Collectors.toSet());
        System.out.println(set);

        driverSet.stream().mapToInt(d -> d.getName().length()).average().ifPresent(s -> System.out.println(s));
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", adress='" + adress + '\'' +
                ", pid=" + pid +
                "}";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other instanceof Driver) {
            Driver driver = (Driver) other;
            return Objects.equals(driver.name,this.name) && Objects.equals(driver.surname, this.surname)
                    && Objects.equals(driver.adress, this.adress) && Objects.equals(driver.pid, this.pid);
        } else return false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }
}
