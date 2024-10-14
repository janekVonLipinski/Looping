package Looping;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private final static String PATH = "C:\\Users\\User\\Desktop\\janek\\java_programme\\Looping\\src\\main\\resources";

    public static void main(String[] args) {

        Looping looping = new Looping(10, 2);

        System.out.println(looping.getPunkte().stream().map(i -> i.getX()).toList());
        System.out.println(looping.getPunkte().stream().map(i -> i.getY()).toList());


        try (FileWriter fileWriter = new FileWriter(PATH + "LoopingDaten.csv");) {
            String result = looping.getPunkte().stream()
                    .map(punkt -> punkt.getY() +  "\n")
                    .map(punk -> punk.replace(".", ","))
                    .collect(Collectors.joining());

            fileWriter.write(result);
        }
        catch (IOException ex){
            System.out.println("Error: " + ex);
        }


    }
}
