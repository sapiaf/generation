package com.esempio.snacks;

import java.util.Scanner;

public class Snack3 {
    public static void main(String[] args) {
        //Il software deve chiedere per 10 volte all’utente di inserire un numero. Il programma stampa la somma di tutti i numeri inseriti.
        Scanner scanner = new Scanner(System.in);
        int somma = 0;
        for (int i = 0; i < 10 ; i++) {
            System.out.println("Inserisci un numero: ");
            int numero = scanner.nextInt();
            somma += numero;
        }
        System.out.println("La somma dei numeri inseriti è: " + somma);

    }
}
