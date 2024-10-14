package Looping;

public class Punkt {

    private double x;
    private double y;
    private double beta;
    private double alpha;

    public Punkt(double x, double y, double beta, double alpha) {
        this.x = x;
        this.y = y;
        this.beta = beta;
        this.alpha = alpha;
    }

    @Override
    public String toString() {
        return "Punkt{" +
                "x=" + x +
                ", y=" + y +
                ", beta=" + beta +
                ", alpha=" + alpha +
                '}';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
}
