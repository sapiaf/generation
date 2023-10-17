package org.lessons.java.security;

import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String favoriteColor = scanner.nextLine();
        int dayOfBirth = scanner.nextInt();
        int monthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();

        int ageSum = dayOfBirth + monthOfBirth + yearOfBirth;

        String generatedPass = firstName + "-" + lastName + "-" + favoriteColor + "-" + ageSum;
        // Alternative solution
        // String generatedPass = String.join("-", firstName, lastName, favoriteColor, String.valueOf(ageSum));

        System.out.println("La password generata è: " + generatedPass);
    }
}
