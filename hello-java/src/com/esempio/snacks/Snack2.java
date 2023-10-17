package com.esempio.snacks;

import java.util.Scanner;

public class Snack2 {
    public static void main(String[] args) {
        // L’utente inserisce due parole in successione. Il software stampa prima la parola più corta, poi la parola più lunga.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la prima parola: ");

        String wordOne = scanner.nextLine();

        System.out.println("Inserisci la seconda parola: ");
        String wordTwo = scanner.nextLine();

        if (wordOne.length() < wordTwo.length()) {
            System.out.println("La parola più corta è: " + wordOne);
            System.out.println("La parola più lunga è: " + wordTwo);
        } else if (wordTwo.length() < wordOne.length()) {
            System.out.println("La parola più corta è: " + wordTwo);
            System.out.println("La parola più lunga è: " + wordOne);
        } else {
            System.out.println("Le parole hanno la stessa lunghezza.");
        }

    }
}
