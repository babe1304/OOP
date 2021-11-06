package hr.fer.oop.predavanja;

public class Manager extends Person {
    private Band managingBand;

    public Manager(String name, String country, int age, Band managingBand) {
        super(name, country, age);
        this.managingBand = managingBand;
    }

    public void kickBandMember(Musician musician) {
        Musician[] noviBend = new Musician[managingBand.getBandMembers().length - 1];
        int i = 0;

        for (Musician musician1 : managingBand.getBandMembers()) {
            if (!(musician1.equals(musician))) {
                noviBend[i++] = musician1;
            }
        }

        this.managingBand.setBandMembers(noviBend);
    }

}
