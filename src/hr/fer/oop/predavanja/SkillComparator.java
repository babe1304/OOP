package hr.fer.oop.predavanja;

import java.util.Comparator;

public class SkillComparator implements Comparator<Musician> {

    @Override
    public int compare(Musician o1, Musician o2) {
        if (o1.getSkill() == o2.getSkill()) return 0;
        else if (o1.getSkill() > o2.getSkill()) return 1;
        else return -1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
