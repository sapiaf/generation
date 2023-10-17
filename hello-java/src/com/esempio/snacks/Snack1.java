package com.esempio.snacks;

import java.util.Scanner;

public class Snack1 {
    public static void main(String[] args) {
        // L’utente inserisce due numeri in successione. Il software stampa il maggiore.
        Scanner scanner = new Scanner(System.in);
        int numberOne = scanner.nextInt();
        int numberTwo = scanner.nextInt();
        if (numberOne > numberTwo) {
            System.out.println("Il numero maggiore è: " + numberOne);
        } else if (numberTwo > numberOne) {
            System.out.println("Il numero maggiore è: " + numberTwo);
        } else {
            System.out.println("I numeri sono uguali.");
        }

    }
}
