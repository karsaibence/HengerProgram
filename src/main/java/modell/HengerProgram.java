package modell;

import com.sun.jdi.InvalidTypeException;

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

    // Henger típus térfogata.
    public double atlagTerfogat() {

        return 0;
    }

    public double csovekSulya() {
        return 0;
    }

    private ArrayList list() {
        ArrayList<Objects> o = new ArrayList<>();
        return o;
    }

    private void hengerValaszto() {
        sc = new Scanner(System.in);
        System.out.println("Add meg milyen hengert szeretnél:");
        System.out.println("1. Tömörhenger.");
        System.out.println("2. Cső.");
        try {
            switch (sc.nextInt()) {
                case 1:
                    tomorHengerKeszit();
                    break;
                case 2:
                    csoHengerKeszit();
                    break;
                default:
                    System.out.println("Nem jó számot adtál meg.");
            }
        }catch (InputMismatchException error){
            System.out.println("Nem számot adtál meg");
        }
    }

    private void csoHengerKeszit() {
        System.out.print("A Henger sugara: ");
        double sugar = sc.nextDouble();
        System.out.print("\nA henger magassága: ");
        double magassag = sc.nextDouble();
        System.out.print("\nA henger fajsúlya(Nem kötelező, default 1): ");
        double fajsuly = sc.nextDouble();
        System.out.print("\nA henger falvastagsága: ");
        double falvastagsag = sc.nextDouble();
        System.out.println();

        hengerek.add(new Cso(sugar,magassag,fajsuly,falvastagsag));
    }

    private void tomorHengerKeszit() {
        System.out.print("A Henger sugara: ");
        double sugar = sc.nextDouble();
        System.out.print("\nA henger magassága: ");
        double magassag = sc.nextDouble();
        System.out.print("\nA henger fajsúlya(Nem kötelező, default 1): ");
        double fajsuly = sc.nextDouble();
        System.out.println();

        hengerek.add(new TomorHenger(sugar,magassag,fajsuly));
    }

    public void run() {
        while (hengerek.size()<4){
            hengerValaszto();
            System.out.println(hengerek.size());
        }
        hengerListaKiir();
    }

    public void hengerListaKiir(){
        for (Henger henger : hengerek) {
            System.out.println(henger.toString());
        }
    }
}
