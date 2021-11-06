package hr.fer.oop.ispit.ispit2017.drugi;

import java.util.Comparator;
import java.util.Objects;

public class Politician implements Comparable<Politician> {
    private String oib;
    private String firstname;
    private String surname;
    private String party;
    public Politician(String oib, String firstname, String surname, String party){
        this.oib = oib;
        this.firstname = firstname;
        this.surname = surname;
        this.party = party;
    }

    @Override
    public int compareTo(Politician other) {
        int c = Objects.compare(this.getParty(), other.getParty(), Comparator.naturalOrder());
        if (c != 0) return c;

        c = Objects.compare(this.getOib(), other.getOib(), Comparator.naturalOrder());
        return c;
    }

    @Override
    public int hashCode() {
        return  (getOib() != null) ? this.getOib().hashCode() : 0;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (!(other instanceof Politician)) return false;

        Politician politician = (Politician) other;
        return this.getOib().equals(politician.getOib());
    }

    @Override
    public String toString() {
        return "Politician{" + "oib=" + oib + ", firstname=" + firstname + ", surname=" + surname + ", party=" + party + '}';
    }

    public String getOib() {
        return oib;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getParty() {
        return party;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setParty(String party) {
        this.party = party;
    }
}
