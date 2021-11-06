package hr.fer.oop.helping;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MySecondFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        String file = path.getFileName().toString();
        Path output = Path.of("E:\\SSIP\\None.txt");

        if (file.endsWith(".txt") && !file.contains("-copy")) {
            System.out.println(file);
            BufferedReader br = Files.newBufferedReader(path);
            br.skip(br.readLine().toString().length());

            while (br.ready()) {
                String line = br.readLine().toString();
                if (line.contains("None")) {
                    System.out.println(line);
                    Files.writeString(output, line + "\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                } else {
                    String newPathString = path.toAbsolutePath().toString().substring(0, path.toAbsolutePath().toString().lastIndexOf(".txt"));
                    Path newPath = Path.of(newPathString + "-copy.txt");
                    Files.writeString(newPath, line + "\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                }
            }
        }
        return FileVisitResult.CONTINUE;
    }
}