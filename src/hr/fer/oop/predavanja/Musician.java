package hr.fer.oop.predavanja;

public class Musician extends Person {

    private BandPosition position;
    private Integer skill;

    public Musician(String name, String country, int age, BandPosition position, Integer skill) {
        super(name, country, age);
        this.position = position;
        this.skill = skill;
    }

    public void trainForOneYear() {
        this.setAge(getAge() + 1);
        this.setSkill(getSkill() + 1);
    }

    public void setPosition(BandPosition position) {
        this.position = position;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public BandPosition getPosition() {
        return position;
    }

    public Integer getSkill() {
        return skill;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Musician other = (Musician) obj;
        if (position != other.position)
            return false;
        if (skill == null) {
            if (other.skill != null)
                return false;
        } else if (!skill.equals(other.skill))
            return false;
        return true;
    }
}
