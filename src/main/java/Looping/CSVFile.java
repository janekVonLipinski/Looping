package Looping;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class CSVFile {

    public void cretateCsvFile(String PATH, Looping looping) {

        try (FileWriter fileWriter = new FileWriter(PATH + "LoopingDaten.csv")) {
            fileWriter.write("X;Y\n");

            String result = looping.getPunkte().stream()
                    .map(punkt -> String.format("%.8f;%.8f\n", punkt.getX(), punkt.getY()))
                    .collect(Collectors.joining());

            fileWriter.write(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
