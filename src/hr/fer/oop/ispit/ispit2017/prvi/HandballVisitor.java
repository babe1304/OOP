package hr.fer.oop.ispit.ispit2017.prvi;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class HandballVisitor extends SimpleFileVisitor<Path> {

    private static List<Player> listOfPlayers = new LinkedList<Player>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().endsWith("txt")) {
            List<String> list = Files.readAllLines(file);

            String teamName = file.getFileName().toString().substring(0, file.getFileName().toString().indexOf("."));

            for (String s : list) {
                String[] player = s.split(";");
                listOfPlayers.add(new Player(player[0], player[1], Integer.valueOf(player[2]),
                        Integer.valueOf(player[3]), Integer.valueOf(player[4]), teamName));
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:/Programiranje/Programi/src/hr/fer/oop/ispit/ispit2017/prvi/Handball");
        FileVisitor<Path> visitor = new HandballVisitor();

        Files.walkFileTree(path, visitor);

        listOfPlayers.stream().filter(s -> s.getGoals() > 5).sorted((s1, s2) -> s1.getGoals() - s2.getGoals())
                .forEach(s -> System.out.printf("%s %s: %d\n", s.getName(), s.getSurname(), s.getGoals()));

        Set<String> setOfCountries = new HashSet<>();
        listOfPlayers.stream().map((s) -> s.getTeam()).forEach((s) -> setOfCountries.add(s));

        for (String country : setOfCountries) {
            double rez = listOfPlayers.stream().filter(s -> s.getTeam() == country)
                    .mapToInt(s -> s.getGoals()).average().getAsDouble();
            System.out.printf("%s : %.2f\n", country, rez);
        }
    }
}
