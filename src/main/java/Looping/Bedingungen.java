package Looping;

public class Bedingungen {
    private double maxHoehe;
    private double maxGeschwindigkeit;

    public Bedingungen(double maxHoehe, double maxGeschwindigkeit) {
        this.maxHoehe = maxHoehe;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }

    public double getMaxHoehe() {
        return maxHoehe;
    }

    public void setMaxHoehe(double maxHoehe) {
        this.maxHoehe = maxHoehe;
    }

    public double getMaxGeschwindigkeit() {
        return maxGeschwindigkeit;
    }

    public void setMaxGeschwindigkeit(double maxGeschwindigkeit) {
        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }

    public boolean checkHoehe(double hoehe) {
        return hoehe <= maxHoehe;
    }

    public boolean checkGeschwindigkeit(double geschwindigkeit) {
        return geschwindigkeit <= maxGeschwindigkeit;
    }
}