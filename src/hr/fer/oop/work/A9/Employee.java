package hr.fer.oop.work.A9;

import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;
    private LocalDate dateOfEmplyment;

    public Employee(String name, double salary, LocalDate dateOfEmplyment) {
        this.name = name;
        this.salary = salary;
        this.dateOfEmplyment = dateOfEmplyment;
    }

    public double raiseSalary(double byPercent) {
        return salary*(1 + byPercent/100);
    }

    @Override
    public String toString() {
        return name + ", " +salary + " kn , " + dateOfEmplyment;
    }
}
