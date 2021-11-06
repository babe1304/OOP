package hr.fer.oop.work;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class LineChecker extends SimpleFileVisitor<Path> {
    private boolean isExisting = false;
    private String imageName;

    public LineChecker(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {

        String fileName = path.getFileName().toString();

        if (fileName.contains(imageName)) isExisting = true;

        return FileVisitResult.CONTINUE;
    }

    public boolean isExisting() {
        return isExisting;
    }
}
