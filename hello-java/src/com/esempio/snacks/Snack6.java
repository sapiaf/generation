package com.esempio.snacks;

import java.util.Scanner;

public class Snack6 {
    public static void main(String[] args) {
        // Stampa il cubo dei primi N numeri, dove N è un numero indicato dall’utente.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero: ");
        int numero = scanner.nextInt();
        for (int i = 1; i <= numero; i++) {
            int cubo = i * i * i;
            System.out.println("Il cubo di " + i + " è: " + cubo);
        }

    }
}
