package com.java.palindrome;

import java.util.Scanner;

public class JavaPalindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci una parola: ");
        String userWord = scan.nextLine();
        String reversedWord = "";
        // ALTERNATIVA
        // String reversedWord = new StringBuilder(userWord).reverse().toString();

        for (int i = userWord.length() - 1; i >= 0 ; i--) {
            reversedWord += userWord.charAt(i);
        }


        if (userWord.equalsIgnoreCase(reversedWord))
            System.out.println("La parola " + userWord + " è palindroma");
        else
            System.out.println("La parola " + userWord +  " non è palindroma");
    }
}
