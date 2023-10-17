package org.generation.travel;
import java.time.LocalDate;
import java.util.Scanner;


public class Agency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vacation vacation = null;
        boolean exit = false;

        while(!exit) {
            System.out.println("Hello! Do you want to book a vacation?\n1 = Book a Vacation\n0 = Exit");

            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice) {
                case 1 -> {

                    // Destination Name
                    System.out.println("Perfect! Where do you want to go?");
                    String destinationName = null;
                    boolean validDestinationName = false;
                    while (!validDestinationName) {
                        try {
                            destinationName = scanner.nextLine();
                            Vacation.validateVacationData(destinationName, LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
                            validDestinationName = true;
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            System.out.println("Choose a correct destination name: ");
                        }
                    }


                    // Departure date
                    System.out.println("When do you want to go? (yyyy-MM-dd)");
                    LocalDate startOfVacation = null;
                    boolean validStartDate = false;
                    while (!validStartDate) {
                        try {
                            startOfVacation = LocalDate.parse(scanner.nextLine());
                            Vacation.validateVacationData(destinationName, startOfVacation, startOfVacation.plusDays(1));
                            validStartDate = true;
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            System.out.println("Choose a correct start date: (yyyy-MM-dd)");
                        }
                    }

                    // Return date
                    System.out.println("When do you want to return? (yyyy-MM-dd)");
                    LocalDate endOfVacation = null;
                    boolean validEndDate = false;
                    while (!validEndDate) {
                        try {
                            endOfVacation = LocalDate.parse(scanner.nextLine());
                            Vacation.validateVacationData(destinationName, startOfVacation, endOfVacation);
                            validEndDate = true;
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            System.out.println("Choose a correct end date: (yyyy-MM-dd)");
                        }
                    }


                    try {
                        vacation = new Vacation(destinationName, startOfVacation, endOfVacation);
                        exit = true;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }


                case 0 -> exit = true;
                default -> System.out.println("Invalid choice, try again...");
            }
        }


        if (vacation != null) {
            vacation.vacationInfo();
        } else {
            System.out.println("Goodbye!");
        }

        scanner.close();
    }

}
