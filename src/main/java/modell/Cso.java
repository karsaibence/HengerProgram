package modell;

public class Cso extends TomorHenger {
    private double falvastagsag;


    public Cso(double sugar, double magassag, double falvastagsag) {
        super(sugar, magassag);
        this.falvastagsag = falvastagsag;
    }

    public Cso(double sugar, double magassag, double fajsuly, double falvastagsag) {
        super(sugar, magassag, fajsuly);
        this.falvastagsag = falvastagsag;
    }

    public double getFalvastagsag() {
        return falvastagsag;
    }

    public double terfogat() {
        return (hengerTerfogat() - ((Math.pow(belsoSugar(), 2) * Math.PI) * getMagassag()));
        //(Math.PI * (Math.pow(getSugar(), 2) - Math.pow(belsoSugar(), 2) * getMagassag()));
    }

    private double belsoSugar() {
        return (getSugar() - falvastagsag);
    }

    @Override
    public double suly() {
        return terfogat()*getFajsuly();
    }

    @Override
    public String toString() {
        return "Cső:{" +
                "sugara: " + getSugar() +
                ", magassag: " + getMagassag() +
                ", fajsúlya: " + getFajsuly() +
                ", falvastagság: " + falvastagsag +
                ", térfogat: " + terfogat() +
                ", súlya: " + suly() +
                "}" ;

    }
}
