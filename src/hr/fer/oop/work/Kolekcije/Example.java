package hr.fer.oop.work.Kolekcije;

import java.io.IOException;
import java.nio.file.Path;

public class Example {

    public static void main(String[] args) throws IOException {
        Path input = Path.of("E:\\input.txt");
        Path output = Path.of("E:\\output.txt");

        FileEditor.processFiles(input, output);
    }

}
