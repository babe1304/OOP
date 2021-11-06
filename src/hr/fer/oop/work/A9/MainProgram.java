package hr.fer.oop.work.A9;

import java.io.IOException;
import java.util.List;

public class MainProgram {

    public static void main(String[] args) throws IOException {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> niz = Solution.groupAnagrams(input);

        for (List<String> s : niz) System.out.println(s);

        List<Employee> employees = EmployeeLoader.loadFromFile("E:\\Programiranje\\eclipse_workspace\\Programi\\src\\hr\\fer\\oop\\work\\A9\\input.txt");

        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }
}
