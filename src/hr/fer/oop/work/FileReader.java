package hr.fer.oop.work;

import hr.fer.oop.helping.MySecondFileVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("E:\\SSIP\\dataset_1");
        MySimpleFileVisitor msfv = new MySimpleFileVisitor();
        Files.walkFileTree(path, msfv);

        System.out.println(msfv.getMapaBrojeva());
        System.out.printf("Broj godišta: %d\n", msfv.getBrojac_normalna());
        System.out.printf("Broje bez godišta: %d\n", msfv.getBrojac_prazan());
        System.out.printf("Broj postojećih slika: %d\n", msfv.getBrojac_true());
        System.out.printf("Broj nepostojećih slika: %d\n", msfv.getBrojac_false());


    }
}
