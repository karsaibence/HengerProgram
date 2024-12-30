package modell;

public class TomorHenger extends Henger {
    private double fajsuly = 1;

    public TomorHenger(double sugar, double magassag) {
        super(sugar, magassag);
    }

    public TomorHenger(double sugar, double magassag, double fajsuly) {
        this(sugar, magassag);
        fajsulyVizsgal(fajsuly);
    }

    public double getFajsuly() {
        return fajsuly;
    }

    public double suly() {
        return hengerTerfogat() * fajsuly;
    }

    public void fajsulyVizsgal(double fajsuly) {
        if (fajsuly <= 0) {
            this.fajsuly = 1;
        } else {
            this.fajsuly = fajsuly;
        }
    }

    @Override
    public String toString() {
        return "Tömör henger:{" +
                "sugara: " + getSugar() +
                ", magassag: " + getMagassag() +
                ", fajsúlya: " + getFajsuly() +
                ", térfogata: " + hengerTerfogat() +
                ", súlya: " + suly() +
                "}" ;
    }
}
