package com.ferragnez.party;

import java.util.Arrays;
import java.util.Scanner;

public class CheckGuest {
    public static void main(String[] args) {
        // Nel programma bisogna:
        // creare e inizializzare l’array contenente i nomi degli invitati
        // chiedere all’utente come si chiama
        // verificare che il nome sia presente nella lista in Java per confrontare due stringhe
        // non posso usare ==, ma devo usare il metodo equals(): esempio qui)
        // lasciarlo entrare o rispedirlo cortesemente da dove è venuto
        // Bonus: se avete usato il ciclo for per cercare il nome nella lista nella consegna base,
        // implementare lo stesso programma usando il ciclo while, e viceversa
        Scanner scanner = new Scanner(System.in);
        String[] guestList = {"Dua Lipa", "Paris Hilton", "Manuel Agnelli", "J-Ax", "Francesco Totti", "Ilary Blasi", "Bebe Vio", "Luis", "Pardis Zarei", "Martina Maccherone", "Rachel Zeilic"};
        boolean present = false;

        System.out.print("Hello there! What's your name? ");
        String userName = scanner.nextLine();

        // FOR LOOP
        for (int i = 0; i < guestList.length; i++) {
            String guest = guestList[i];

            if (userName.equalsIgnoreCase(guest)) {
                present = true;
                break;
            }
        }

        /*  WHILE LOOP
            int i = 0;
            while (i < guestList.length) {
                String guest = guestList[i];

                if (userName.equalsIgnoreCase(guest)) {
                    present = true;
                }

                i++;
            }
         */

        if (present) {
            System.out.println("Welcome " + userName + " your name is on the list!");
        } else {
            System.out.println("I'm sorry " + userName + " your name is not on the list.");
        }

        /* ALTERNATIVE SOLUTION
            boolean isPresent = Arrays.asList(guestList).contains(userName);
            System.out.println(isPresent ? "Welcome " + userName + " your name is on the list!" : "I'm sorry " + userName + " your name is not on the list.")
         */

        scanner.close();

    }
}
