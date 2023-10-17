package com.java.jssnacks;

public class Snack9 {
    public static void main(String[] args) {
        // Calcola la somma e la media dei primi 10 numeri.
        int somma = 0;
        double media;
        for (int i = 1; i <= 10; i++) {
            somma += i;
        }
        media = (double) somma / 10;

        System.out.println("La somma dei primi 10 numeri è: " + somma);
        System.out.println("La media dei primi 10 numeri è: " + media);
    }
}
