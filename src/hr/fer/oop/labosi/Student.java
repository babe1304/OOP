package hr.fer.oop.labosi;

public class Student {
    private final String name;
    private int points;

    public Student(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", points=" + points + "]";
    }
}
