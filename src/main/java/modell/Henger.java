package modell;

public class Henger {
    private static int id = 1;
    private int hengerDarab;
    private double sugar, magassag;

    public Henger(double sugar, double magassag) {
        this.hengerDarab = id++;
        this.sugar = sugar;
        this.magassag = magassag;
    }

    public int getHengerDarab() {
        return hengerDarab;
    }

    public double getSugar() {
        return sugar;
    }

    public double getMagassag() {
        return magassag;
    }

    public double hengerTerfogat() {
        return ((Math.pow(getSugar(), 2) * Math.PI) * magassag);
    }

    @Override
    public String toString() {
        return getHengerDarab() + "." + " henger{" +
                "sugar: " + sugar +
                ", magassag: " + magassag +
                '}';
    }
}
