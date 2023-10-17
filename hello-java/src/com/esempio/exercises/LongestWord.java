package com.esempio.exercises;

import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        // Esercizio 1 : Chiediamo all’utente due parole in successione.
        // Andiamo poi a verificare quale delle due parole è più lunga e stampiamo in console un messaggio appropriato.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scrivi una parola: ");
        String firstWord = scanner.nextLine();
        System.out.println("Scrivi una parola: ");
        String secondWord = scanner.nextLine();
        if (firstWord.length() > secondWord.length()) {
            System.out.println("La parola " + firstWord + " è più lunga di " + secondWord);
        } else if (secondWord.length() > firstWord.length()) {
            System.out.println("La parola " + secondWord + " è più lunga di " + firstWord);
        } else {
            System.out.println("Le parole " + firstWord + " e " + secondWord + " hanno la stessa lunghezza");
        }

        // String longerWord = firstWord.length() > secondWord.length() ? firstWord : secondWord;
        // String shorterWord = firstWord.length() < secondWord.length() ? firstWord : secondWord;
        // if (firstWord.length() != secondWord.length()) {
        //    System.out.println("La parola " + longerWord + " è più lunga di " + shorterWord);
        // } else {
        //     System.out.println("Le parole " + firstWord + " e " + secondWord + " hanno la stessa lunghezza");
        //}

    }
}
