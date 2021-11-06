package hr.fer.oop.labosi.PetiLabos;

public class MainExample {
    
    public static void main(String[] args) {
        int [] gradesCroat = {3,4,5};
        int [] gradesGerman = {1,2,1};
        char [] gradesAmerican = {'A','B','A'};

        Student croat = new Student("Mate", "Juric", 30, gradesCroat);
        Student german = new GermanStudent("Hans", "Zimmer", 40, gradesGerman);
        Student american = new AmericanStudent("John", "Doe", 20, gradesAmerican);

        System.out.println(croat.averageGrade());
        System.out.println(german.averageGrade());
        System.out.println(american.averageGrade());
    }
}
