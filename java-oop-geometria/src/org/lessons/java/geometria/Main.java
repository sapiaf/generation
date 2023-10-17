package org.lessons.java.geometria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci misura della base: ");
        double base = Double.parseDouble(scanner.nextLine());

        System.out.print("Inserisci misura dell'altezza: ");
        double altezza = Double.parseDouble(scanner.nextLine());

        Rettangolo rettangolo = new Rettangolo(base, altezza);
        rettangolo.disegna();


    }
}
