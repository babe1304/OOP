package hr.fer.oop.labosi.PetiLabos;

class Student{
    public String name, surname;
    public int age;
    public int [] grades;

    public Student(String name, String surname, int age, int [] grades) {
        super();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.grades = grades;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }

    public double averageGrade() {
        double zbroj=0;
        for(int i=0;i<grades.length;i++) zbroj += grades[i];
        return zbroj/grades.length;
    }
}