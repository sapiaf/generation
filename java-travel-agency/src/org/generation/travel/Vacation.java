package org.generation.travel;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Vacation {

    // ATTRIBUTES
    private String destination;
    private LocalDate startOfVacation;
    private LocalDate endOfVacation;

    // CONSTRUCTOR
    public Vacation(String destination, LocalDate startOfVacation, LocalDate endOfVacation) {
        validateVacationData(destination, startOfVacation, endOfVacation);
        this.destination = destination;
        this.startOfVacation = startOfVacation;
        this.endOfVacation = endOfVacation;
    }

    // GETTERS AND SETTERS

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        validateVacationData(destination, startOfVacation, endOfVacation);
        this.destination = destination;
    }

    public LocalDate getStartOfVacation() {
        return startOfVacation;
    }

    public void setStartOfVacation(LocalDate startOfVacation) {
        validateVacationData(destination, startOfVacation, endOfVacation);
        this.startOfVacation = startOfVacation;
    }

    public LocalDate getEndOfVacation() {
        return endOfVacation;
    }

    public void setEndOfVacation(LocalDate endOfVacation) {
        validateVacationData(destination, startOfVacation, endOfVacation);
        this.endOfVacation = endOfVacation;
    }


    // METHODS
    public static void validateVacationData(String destination, LocalDate startOfVacation, LocalDate endOfVacation) {
        if (destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("first name must not be null or empty");
        }

        if (startOfVacation == null || startOfVacation.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("start of vacation must not be null or before the end of vacation");
        }

        if (endOfVacation == null || endOfVacation.isBefore(startOfVacation)) {
            throw new IllegalArgumentException("end of vacation must not be null or before the start of vacation");
        }
    }

    public int lengthOfVacation() {
        return (int) ChronoUnit.DAYS.between(startOfVacation, endOfVacation) + 1;
    }

    public void vacationInfo() {
        System.out.println("You have booked a vacation of " + lengthOfVacation() + " days to " +
                getDestination() + " from " + getStartOfVacation() + " to " +
                getEndOfVacation());
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "destination='" + destination + '\'' +
                ", startOfVacation=" + startOfVacation +
                ", endOfVacation=" + endOfVacation +
                '}';
    }
}
