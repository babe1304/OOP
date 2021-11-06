package hr.fer.oop.labosi.PetiLabos;

public class AmericanStudent extends Student {
    public AmericanStudent(String name, String surname, int age, char[] grades) {
        super(name, surname, age, new int[grades.length]);

        int[] newGrades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            Character c = grades[i];
            if (c.equals('A')) newGrades[i] = 5;
            else if (c.equals('B')) newGrades[i] = 4;
            else if (c.equals('C')) newGrades[i] = 3;
            else if (c.equals('D')) newGrades[i] = 2;
            else newGrades[i] = 1;
        }
        this.grades = newGrades;
    }
}
