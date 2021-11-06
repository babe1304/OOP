package hr.fer.oop.work.A9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLoader {

    public static List<Employee> loadFromFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        List<String> lines = Files.readAllLines(path);
        List<Employee> employees = new ArrayList<>();

        for (String line : lines) {
            String[] employeeStuff = line.split(";");

            double salary = Double.valueOf(employeeStuff[1]);
            LocalDate date = LocalDate.of(Integer.valueOf(employeeStuff[2]) , Integer.valueOf(employeeStuff[3]), Integer.valueOf(employeeStuff[4]));

            employees.add(new Employee(employeeStuff[0], salary, date));
        }

        return employees;
    }
}
