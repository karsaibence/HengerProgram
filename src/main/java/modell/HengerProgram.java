package modell;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class HengerProgram {
    private ArrayList<Henger> hengerek;
    private Scanner sc;

    public HengerProgram() {
        this.hengerek = new ArrayList<>();
    }

    public double atlagTerfogat() {
        double atlagTerfogat = 0;
        for (Henger henger : hengerek) {
            if (henger instanceof Cso cs) {
                atlagTerfogat += cs.terfogat();
            } else if (henger instanceof TomorHenger th) {
                atlagTerfogat += th.hengerTerfogat();
            }
        }
        return atlagTerfogat / hengerek.size();
    }

    public double csovekSulya() {
        double osszSuly = 0;
        for (int i = 0; i < hengerek.size(); i++) {
            Henger h = hengerek.get(i);
            if (h instanceof Cso cs) {
                osszSuly += cs.suly();
            }
        }
        return osszSuly;
    }

    //nem tudom mi ez.
    private ArrayList list() {
        ArrayList<Objects> o = new ArrayList<>();
        return o;
    }

    private int hengerValaszto() {
        valszOpcioszoveg();

        sc = new Scanner(System.in);
        int felhasznaloValasza = 0;
        try {
            felhasznaloValasza = sc.nextInt();
            if (felhasznaloValasza == 1 || felhasznaloValasza == 2) {
                hengerKeszit(felhasznaloValasza);
                return felhasznaloValasza;
            } else if (felhasznaloValasza == 100 && hengerek.size() >= 4) {
                for (Henger henger : hengerek) {
                    System.out.println(henger);
                }
                System.out.println("Az átlag térfogat: "+atlagTerfogat());
                System.out.println("A csövek össz súlya: "+csovekSulya());
            }else{
                System.out.println("Nem jó számot adtál meg.");
            }
        } catch (InputMismatchException error) {
            System.out.println("Nem számot adtál meg");
        }

        return felhasznaloValasza;
    }

    private void valszOpcioszoveg() {
        if (hengerek.size() < 4) {
            System.out.println("Add meg milyen hengert szeretnél:");
            System.out.println("1. Tömörhenger.");
            System.out.println("2. Cső.");
        } else {
            System.out.println("Add meg milyen hengert szeretnél:");
            System.out.println("1. Tömörhenger.");
            System.out.println("2. Cső.");
            System.out.println("100. Ha nem szeretnél több hengert, akkor írd be a '100'-at.");
        }
    }

    private void hengerKeszit(int a) {

        double sugar = getAdatok("sugara");

        double magassag = getAdatok("magassága");

        System.out.print("\nA henger fajsúlya(Nem kötelező, default 1): ");
        double fajsuly = sc.nextDouble();

        if (a == 2) {
            System.out.print("\nA henger falvastagsága: ");
            double falvastagsag = sc.nextDouble();
            while (!isHelyesAdat(falvastagsag) || sugar < falvastagsag) {
                System.out.print("\nA henger falvastagsága nem lehet nagyobb vagy egyenlő mint a sugár/nem lehet nulla vagy kisebb. A henger falvastagsága: ");
                falvastagsag = sc.nextDouble();
            }
            hengerek.add(new Cso(sugar, magassag, fajsuly, falvastagsag));
        } else {
            hengerek.add(new TomorHenger(sugar, magassag, fajsuly));
        }
    }

    private double getAdatok(String szo) {
        System.out.print("A Henger " + szo + ": ");
        double kimenoErtek = sc.nextDouble();

        while (!isHelyesAdat(kimenoErtek)) {
            System.out.print("Nem lehet kisebb vagy egyenlő mint 0. A Henger " + szo + ": ");
            kimenoErtek = sc.nextDouble();
        }
        return kimenoErtek;
    }

    private boolean isHelyesAdat(double adat) {
        return adat > 0;
    }

    //nincs kész
    public void run() {
        int valasz = 0;
        while (hengerek.size() < 4 || valasz != 100) {
            valasz = hengerValaszto();
        }
    }
}
