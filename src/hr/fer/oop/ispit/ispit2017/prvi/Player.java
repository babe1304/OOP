package hr.fer.oop.ispit.ispit2017.prvi;

public class Player {
    private String name;
    private String surname;
    private int number;
    private int goals;
    private int assists;
    private String team;

    public Player(String name, String surname, int number, int goals, int assists, String team) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.goals = goals;
        this.assists = assists;
        this.team = team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getNumber() {
        return number;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number=" + number +
                ", goals=" + goals +
                ", assists=" + assists +
                ", team='" + team + '\'' +
                '}';
    }
}
