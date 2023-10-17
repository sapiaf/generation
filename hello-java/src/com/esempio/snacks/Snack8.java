package com.esempio.snacks;

import java.util.Scanner;

public class Snack8 {
    public static void main(String[] args) {
        // Chiedi un numero di 4 cifre all’utente e calcola la somma di tutte le cifre che compongono il numero.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero a 4 cifre");
        String numeroUtente = scanner.nextLine();
        int somma = 0;
        for (int i = 0; i < numeroUtente.length() ; i++) {
            somma += Character.getNumericValue(numeroUtente.charAt(i));
        }
        System.out.println(somma);

    }
}
