package Looping;

import java.util.ArrayList;
import java.util.List;

public class Looping {

    private final List<Punkt> punkte = new ArrayList<>();
    private final double startWinkel;
    private final double startStrecke;
    private final double h;
    private static final double g = 9.81;

    public Looping(double startWinkel, double startStrecke, double h) {
        this.startWinkel = startWinkel;
        this.startStrecke = startStrecke;
        this.h = h;
        konstruiere();
    }

    public List<Punkt> getPunkte() {
        return punkte;
    }

    public void konstruiere() {
        Punkt ersterPunkt = new Punkt(
                0, 0, 0, startWinkel
        );
        punkte.add(ersterPunkt);

        int numberOfIterations = (int) (360 / startWinkel);

        Punkt aktuellerPunkt = ersterPunkt;

        for (int i = 0; i < numberOfIterations; i++) {
            aktuellerPunkt = berechneNaechstenPunkt(aktuellerPunkt);
        }
    }

    private List<Double> mapToGeschwindigkeitQuadrat() {
        List<Double> rForList = mapToR();
        List<Double> geschwindigkeiten = new ArrayList<>();

        for (int i = 0; i < rForList.size(); i++) {
            double r = rForList.get(i);
            Punkt pInList = punkte.get(i);
            double v = getGeschwindigkeitQuadrat(pInList, r);
            geschwindigkeiten.add(v);
        }

        return geschwindigkeiten;
    }

    private double getGeschwindigkeitQuadrat(Punkt punkt, double r) {
        return r * g * (h - punkt.getY());
    }

    private List<Double> mapToR() {
        return punkte.stream()
                .map(Punkt::getAlpha)
                .map(this::getR)
                .toList();
    }

    private double getR(double alpha) {
        return (startStrecke / 2) * (1 / Math.tan(Math.toRadians(alpha / 2)));
    }

    private Punkt berechneNaechstenPunkt(Punkt aktuellerPunkt) {
        double betaNext = startWinkel + aktuellerPunkt.getBeta();
        double radiantVonBeta = Math.toRadians(betaNext);
        double sinVonBeta = Math.sin(radiantVonBeta);
        double cosVonBeta = Math.cos(radiantVonBeta);

        double xNext = aktuellerPunkt.getX() + startStrecke * cosVonBeta;
        double yNext = aktuellerPunkt.getY() + startStrecke * sinVonBeta;

        Punkt naechsterPunkt = new Punkt(
                xNext, yNext, betaNext, startWinkel
        );

        punkte.add(naechsterPunkt);
        aktuellerPunkt = naechsterPunkt;

        return aktuellerPunkt;
    }
}
