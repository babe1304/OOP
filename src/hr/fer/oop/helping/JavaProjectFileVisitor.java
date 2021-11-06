package hr.fer.oop.helping;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaProjectFileVisitor extends SimpleFileVisitor<Path> {

    private Map<String, Long> map = new HashMap<>();
    private Set<String> extensionFilter;

    public JavaProjectFileVisitor(Set<String> extensionFilter) {
        this.extensionFilter = extensionFilter;
    }

    public Map<String, Long> getProjectFileSizeInfo() {
        return map;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        int index = file.getFileName().toString().lastIndexOf(".");
        String niz = file.getFileName().toString().substring(index);

        if (extensionFilter.contains(niz)) {
            if (!map.containsKey(niz)) map.put(niz, attrs.size());
            else map.replace(niz, map.get(niz) + attrs.size());
        }

        return FileVisitResult.CONTINUE;
    }
}
