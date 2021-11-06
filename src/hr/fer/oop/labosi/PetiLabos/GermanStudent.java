package hr.fer.oop.labosi.PetiLabos;

class GermanStudent extends Student {
    public GermanStudent(String name, String surname, int age, int[] grades) {
        super(name, surname, age, grades);
    }

    @Override
    public double averageGrade() {
        double zbroj=0;
        for (int grade: grades) {
            if (grade == 1) grade = 5;
            else if (grade == 2) grade = 4;
            else if (grade == 4) grade = 2;
            else if (grade == 5) grade = 1;
            else grade = 3;

            zbroj += grade;
        }
        return zbroj / grades.length;
    }
}
