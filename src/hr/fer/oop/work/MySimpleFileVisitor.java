package hr.fer.oop.work;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.TreeMap;

public class MySimpleFileVisitor extends SimpleFileVisitor<Path> {
    private Map<String, Integer> mapaBrojeva =  new TreeMap<>();
    private int brojac_normalna = 0;
    private int brojac_prazan = 0;
    private int brojac_true = 0;
    private int brojac_false = 0;

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        String file = path.getFileName().toString();

        if (file.endsWith(".txt")) {
            System.out.println(file);
            BufferedReader br = Files.newBufferedReader(path);

            br.lines().map((line) -> {
                System.out.println(line);

//                //provjera ako je ime slike medu slikama
//                String[] parts = line.split("\t");
//                Path check_path = Path.of("E:\\SSIP\\dataset_1\\aligned");
//                LineChecker lc = new LineChecker(parts[1]);
//                try {
//                    Files.walkFileTree(check_path, lc);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                if (lc.isExisting()) brojac_true++;
//                else if (!lc.isExisting()) brojac_false++;
//
//                System.out.println(lc.isExisting());

                //katgoriziranje po godištima
                if (line.indexOf("(") != -1) {
                    brojac_normalna++;
                    return line.substring(line.indexOf("("), line.indexOf(")") + 1);
                } else {
                    String[] lista = line.split("\t");
                    brojac_prazan++;
                    return lista[3];
                }
            })
                .forEach((ages) -> {
                        if (mapaBrojeva.get(ages) == null) mapaBrojeva.put(ages, 1);
                        else mapaBrojeva.put(ages, mapaBrojeva.get(ages) + 1);
                    });
        }
        return FileVisitResult.CONTINUE;
    }

    public Map<String, Integer> getMapaBrojeva() {
        return mapaBrojeva;
    }

    public int getBrojac_normalna() {
        return brojac_normalna;
    }

    public int getBrojac_prazan() {
        return brojac_prazan;
    }

    public int getBrojac_true() {
        return brojac_true;
    }

    public int getBrojac_false() {
        return brojac_false;
    }
}
