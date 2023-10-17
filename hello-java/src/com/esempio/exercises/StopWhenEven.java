package com.esempio.exercises;

import java.util.Scanner;

public class StopWhenEven {
    public static void main(String[] args) {
        //Esercizio 2: Continuare a chiedere all’utente di inserire un numero.
        // Fermarsi quando il numero è pari. Stampare in console l’ultimo numero inserito

        Scanner scanner = new Scanner(System.in);
        int userNum;

        do {
            System.out.print("Write a number: ");
            userNum = scanner.nextInt();
        } while (userNum % 2 != 0);

        System.out.println("The chosen even number is: " + userNum);

        scanner.close();
    }
}
