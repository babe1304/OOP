package hr.fer.oop.ispit.ispit2018.drugi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainProgram {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        System.out.println("File types in: " + path.toAbsolutePath().toString());
        MyFileVisitor visitor = new MyFileVisitor();
        Files.walkFileTree(path, visitor);
        System.out.println(visitor.getData());
    }
}
