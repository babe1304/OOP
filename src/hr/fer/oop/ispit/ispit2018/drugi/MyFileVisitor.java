package hr.fer.oop.ispit.ispit2018.drugi;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private Map<String, Integer> mapa = new HashMap<>();

    public Map<String, Integer> getData() {
        return mapa;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        String name = path.getFileName().toString();
        int index = name.lastIndexOf(".");

        if (index != -1) {
            String ext = name.substring(index + 1).toUpperCase();
            mapa.compute(ext, (extension , num) -> num == null ? 1 : num+1);
        }
        return FileVisitResult.CONTINUE;
    }
}
