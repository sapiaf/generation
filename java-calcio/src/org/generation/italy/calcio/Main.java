package org.generation.italy.calcio;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il nome della squadra: ");
        String nomeSquadra = scanner.nextLine();

        System.out.print("Inserisci il nome dell'allenatore: ");
        String nomeAllenatore = scanner.nextLine();

        System.out.print("Inserisci la strategia dell'allenatore: ");
        String strategiaAllenatore = scanner.nextLine();

        GeneraSquadra generaSquadra = new GeneraSquadra(nomeSquadra, nomeAllenatore, strategiaAllenatore);
        GeneraSquadra generaSquadraComputer = new GeneraSquadra();


        Squadra squadraGiocatore = generaSquadra.generaSquadra();
        Squadra squadraComputer = generaSquadraComputer.generaSquadra();
        Arbitro arbitro = new Arbitro("Davide Santoro", LocalDate.of(1970, 1, 1));


        Partita nuovapPartita = new Partita(squadraGiocatore, squadraComputer, arbitro);

        nuovapPartita.iniziaPartita();
        nuovapPartita.segnaGoal();
        nuovapPartita.segnaGoal();
        nuovapPartita.segnaGoal();
        nuovapPartita.segnaGoal();
        nuovapPartita.segnaGoal();
        nuovapPartita.segnaGoal();
        nuovapPartita.segnaGoal();
        nuovapPartita.terminaPartita();






    }


}
