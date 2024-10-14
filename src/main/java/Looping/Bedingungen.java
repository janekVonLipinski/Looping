package Looping;

import java.util.List;

public class Bedingungen {
    private final double maxHoehe;
    private final double maxGeschwindigkeit;

    public Bedingungen(double maxHoehe, double maxGeschwindigkeit) {
        this.maxHoehe = maxHoehe;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }

    public boolean istLoopingValide(List<Double> anpressdruecke, double gewichtskraft) {
        return istAnpressdruckGroesserNull(anpressdruecke)
                && istGewichtsZuHoch(anpressdruecke, gewichtskraft);
    }

    private boolean istAnpressdruckGroesserNull(List<Double> anpressdruecke) {
        return anpressdruecke.stream()
                .map(i -> i > 0)
                .anyMatch(i -> !i);
    }

    private boolean istGewichtsZuHoch(List<Double> anpressdruecke, double gewichtskraft) {
        return anpressdruecke.stream()
                .map(i -> i > gewichtskraft)
                .anyMatch(i -> !i);
    }

    public boolean checkHoehe(double hoehe) {
        return hoehe <= maxHoehe;
    }

    public boolean checkGeschwindigkeit(double geschwindigkeit) {
        return geschwindigkeit <= maxGeschwindigkeit;
    }
}