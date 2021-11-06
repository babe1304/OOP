package hr.fer.oop.work.Kolekcije;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileEditor {

    public static void processFiles(Path inputFile, Path outputFile) throws IOException {
        List<String> allLines = Files.readAllLines(inputFile, StandardCharsets.UTF_8);

        BufferedWriter bw = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8);

        for (String line : allLines) {
            line.replaceAll("fer ","pmf");
            bw.write(line + "\n");
        }
        bw.close();
    }
}