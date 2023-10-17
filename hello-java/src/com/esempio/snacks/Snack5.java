package com.esempio.snacks;

import java.util.Scanner;

public class Snack5 {
    public static void main(String[] args) {
        // Chiedi per 6 volte all’utente di inserire un numero, se è dispari il programma mostra questa informazione a video
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("Inserisci un numero: ");
            int numero = scanner.nextInt();

            if (numero % 2 != 0) {
                System.out.println("Il numero è dispari.");
            }
        }

        scanner.close();
    }
}
