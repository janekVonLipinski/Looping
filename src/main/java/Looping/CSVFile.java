package Looping;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFile {

    public void cretateCsvFile(String PATH, Looping looping) {

        try (FileWriter fileWriter = new FileWriter(PATH + "LoopingDaten.csv")) {
            fileWriter.write("X;Y\n");

            List<Punkt> punkte = looping.getPunkte();
            List<Double> anpressDruecke = looping.getAnpressdruck();
            List<Double> zentrifugalKraft = looping.getZentrifugalKraefte();
            List<Double> normalKraft = looping.getNormalkraft();

            StringBuilder result = new StringBuilder("X;Y;F_A;F_Z;F_N;alpha");

            for (int i = 0; i < punkte.size(); i++) {
                Punkt punkt = punkte.get(i);
                double anpress = anpressDruecke.get(i);
                double zen = zentrifugalKraft.get(i);
                double kraft = normalKraft.get(i);
                result.append("%.8f;%.8f,%.8f,%.8f,%.8f,%.8f\n".formatted(
                        punkt.getX(), punkt.getY(), anpress, zen, kraft, punkt.getAlpha()
                ));
            }

            fileWriter.write(result.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
