package hr.fer.oop.labosi;

public class DriverStats {
    private String name;
    private int starts;
    private int podiums;

    public DriverStats(String name, int starts, int podiums) {
        super();
        this.name=name;
        this.starts=starts;
        this.podiums=podiums;
    }

    public String getName() {
        return name;
    }

    public int getStarts() {
        return starts;
    }

    public int getPodiums() {
        return podiums;
    }
}
