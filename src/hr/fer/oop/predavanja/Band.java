package hr.fer.oop.predavanja;

public class Band {

    private Musician[] bandMembers;
    private String bandName;

    public Band(Musician[] musicians, String name) {
        this.bandMembers = musicians;
        this.bandName = name;
    }

    public void setBandMembers(Musician[] bandMembers) {
        this.bandMembers = bandMembers;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public Musician[] getBandMembers() {
        return bandMembers;
    }

    public String getBandName() {
        return bandName;
    }

    @Override
    public String toString() {
        String rez = "Members of the band " + getBandName() + " are:";
        for (int i = 0; i < bandMembers.length; i++) {
            if (i != bandMembers.length - 1) rez += " " + bandMembers[i].getName() + ",";
            else rez += " " + bandMembers[i].getName();
        }
        return rez;
    }
}
