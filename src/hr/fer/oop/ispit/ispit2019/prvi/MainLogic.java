package hr.fer.oop.ispit.ispit2019.prvi;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class MainLogic {
    public static void main(String[] args) {
        List<Car> listOfCars = new LinkedList<Car>();
        String filename = "/Archive.zip";
        //otvaranje .zip datoteke
        try (ZipFile zipfile = new ZipFile(filename)) {
            Enumeration<? extends ZipEntry> entries = zipfile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.getName().toString().endsWith(".txt")) {

                    try (InputStream stream = zipfile.getInputStream(entry)) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(new
                                BufferedInputStream(stream), "UTF-8"));

                        while (true) {
                            String line = br.readLine();
                            if (line == null || line.trim().isEmpty()) break;
                            String[] words = line.split(";");
                            Car car = new Car(words[0], words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3])
                                    , words[4], Integer.parseInt(words[5]), Integer.parseInt(words[6]));
                            listOfCars.add(car);
                        }

                    } catch (IOException e) {
                    }
                }
            }
        } catch (ZipException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Writer bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new
                    FileOutputStream("/izvjestaj.txt")),"UTF-8"));
            List<String> manufacturers = new LinkedList<>();
            listOfCars.stream().map((car) -> car.getManufacturer())
                    .sorted(Comparator.naturalOrder())
                    .forEach((s) -> manufacturers.add(s));

            for (String s : manufacturers) {

                long count = listOfCars.stream()
                        .filter((string) -> string.getManufacturer().toString().equals(manufacturers))
                        .count();
                bw.write(s + " " + Long.toString(count) + "\n");
            }
            bw.write(Double.toString(listOfCars.stream()
                    .filter(a -> a.getYearOfManufacture() < 2015)
                    .mapToDouble(a -> a.getGasConsumption())
                    .average()
                    .getAsDouble()));
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
