package Looping;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private final static String PATH = "C:\\Users\\User\\Desktop\\janek\\java_programme\\Looping\\Looping\\src\\main\\resources\\";
    private final static String PATH2 = "C:\\Users\\049mlhoehne\\Documents\\Looping\\";

    public static void main(String[] args) {

        Looping looping = new Looping(10, 2, 31, 200,
                new Bedingungen(31, 80));
        CSVFile csvFile = new CSVFile();

        csvFile.cretateCsvFile(PATH, looping);

        System.out.println(looping.getPunkte().stream().map(i -> i.getX()).toList());
        System.out.println(looping.getPunkte().stream().map(i -> i.getY()).toList());

        System.out.println(looping.isValid());

    }
}
