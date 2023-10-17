package com.esempio.snacks;

public class Snack7 {
    public static void main(String[] args) {
        // Stampa le potenze di 2 minori di 1000
        int numero = 1;
        int potenza = 1;
        while (numero < 1000) {
            System.out.println(numero);
            numero = Math.pow(2, potenza);
            potenza++;
        }
    }
}
