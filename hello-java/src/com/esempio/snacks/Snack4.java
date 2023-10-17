package com.esempio.snacks;

import java.util.Random;
import java.util.Scanner;

public class Snack4 {
    public static void main(String[] args) {
       // Genera un array di 10 numeri interi random compresi tra 0 e 100.
        // L’utente inserisce un numero e il programma gli risponde se il numero è presente nell’array oppure no.
        Random randomNum = new Random();
        Scanner scanner = new Scanner(System.in);

        int[] numberArray = new int[10];

        for (int i = 0; i < 10; i++) {
            numberArray[i] = randomNum.nextInt(0, 101);
        }

        System.out.println("Inserisci un numero: ");
        int numero = scanner.nextInt();

        boolean presente = false;

        for (int i = 0; i < numberArray.length && !presente; i++) {
            if (numberArray[i] == numero) {
                presente = true;
            }
        }

        if (presente) {
            System.out.println("Il numero è presente nell'array.");
        } else {
            System.out.println("Il numero non è presente nell'array.");
        }

    }
}
