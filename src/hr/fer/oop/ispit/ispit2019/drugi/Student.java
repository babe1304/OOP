package hr.fer.oop.ispit.ispit2019.drugi;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String jmbag;
    private String firstname;
    private String surname;
    private Double avgGrade;

    public Student(String jmbag, String firstname, String surname, Double avgGrade) {
        this.jmbag = jmbag;
        this.firstname = firstname;
        this.surname = surname;
        this.avgGrade = avgGrade;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public String getJmbag() {
        return jmbag;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(jmbag, student.jmbag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jmbag);
    }

    @Override
    public int compareTo(Student o) {
        return this.getJmbag().compareTo(o.getJmbag());
    }

    public static final Comparator<Student> SURNAME = (s1, s2) -> s1.getSurname().compareTo(s2.getSurname());
    public static final Comparator<Student> AVG_GRADE = (s1, s2) -> s1.avgGrade.compareTo(s2.avgGrade);

}
