package modell;

public class Henger {
    private static int hengerDarab = 0;
    private double sugar, magassag;

    public Henger(double sugar, double magassag) {
        this.hengerDarab = hengerDarab + 1;
        this.sugar = sugar;
        this.magassag = magassag;
    }

    public static int getHengerDarab() {
        return hengerDarab;
    }

    public double getSugar() {
        return sugar;
    }

    public double getMagassag() {
        return magassag;
    }

    public double terfogat() {
        return (Math.pow(getSugar(), 2) * Math.PI) * getMagassag();
    }

    @Override
    public String toString() {
        return getHengerDarab() + "." + " henger{" +
                "sugar: " + sugar +
                ", magassag: " + magassag +
                '}';
    }
}
