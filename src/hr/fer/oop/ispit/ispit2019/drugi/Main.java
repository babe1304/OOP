package hr.fer.oop.ispit.ispit2019.drugi;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class Main {

    public static void printStudents(Iterable<Student> students, Predicate<Student> predicate) {
        for (Student s : students) {
            if (predicate.test(s)) {
                System.out.println(s.toString());
            }
        }
    }

    public static void printPair(Student first, Student last) {
        System.out.format("First and last student: %n\t%s%n\t%s%n", first, last);
    }

    public static void firstAndLastStudent(Iterable<Student> students, Comparator<Student>
            comparator, BiConsumer<Student, Student> action) {
        SortedSet<Student> sorted = new TreeSet<>(comparator);

        for (Student s : students) {
            sorted.add(s);
        }
        action.accept(sorted.first(), sorted.last());
    }

    public static void main(String[] args) {
        List<Student> dataset = DBLoader.loadStudents();

        printStudents(dataset, new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getAvgGrade() > 3.5;
            }
        });

        firstAndLastStudent(dataset, Student.AVG_GRADE, Main::printPair);

        BiConsumer<Student, Student> biConsumer = (s1, s2) -> {
            System.out.println(String.format("Diff = %f", Math.abs(Double.valueOf(s1.getAvgGrade()) - Double.valueOf(s2.getAvgGrade()))));
        };

        firstAndLastStudent(dataset, Student.AVG_GRADE.reversed(), biConsumer);
    }
}

