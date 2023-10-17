package org.generation.italy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GestoreFlotta gestoreFlotta = new GestoreFlotta();
        Scanner scanner = new Scanner(System.in);

        // VEICOLI ESEMPIO
        Veicolo veicolo1 = new Automobile("ABC123", 2020, 4);
        Veicolo veicolo2 = new Motocicletta("XYZ789", 2019, true);
        Veicolo veicolo3 = new Motocicletta("DEF456", 2022, true);
        gestoreFlotta.aggiungiVeicolo(veicolo1);
        gestoreFlotta.aggiungiVeicolo(veicolo2);
        gestoreFlotta.aggiungiVeicolo(veicolo3);


        boolean continua = true;

        while (continua) {
            System.out.println("\nCosa desideri fare?");
            System.out.println("1. Aggiungi un veicolo");
            System.out.println("2. Trova un veicolo");
            System.out.println("3. Lista Veicoli");
            System.out.println("4. Esci");

            int scelta;
            try {
                scelta = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserire un numero valido.");
                continue;
            }
            
            switch (scelta) {
                case 1 -> {
                    System.out.print("Inserisci la targa del veicolo: ");
                    String targa = scanner.nextLine();
                    System.out.print("Inserisci l'anno di immatricolazione del veicolo: ");
                    int annoImmatricolazione = Integer.parseInt(scanner.nextLine());
                    System.out.print("Il veicolo è un'automobile o una motocicletta? (A/M): ");
                    String tipoVeicolo = scanner.nextLine();
                    Veicolo veicolo;
                    if (tipoVeicolo.equalsIgnoreCase("A")) {
                        System.out.print("Inserisci il numero di porte dell'automobile: ");
                        int numeroPorte = Integer.parseInt(scanner.nextLine());
                        veicolo = new Automobile(targa, annoImmatricolazione, numeroPorte);
                    } else if (tipoVeicolo.equalsIgnoreCase("M")) {
                        System.out.print("La motocicletta ha il cavalletto? (true/false): ");
                        boolean cavalletto = Boolean.parseBoolean(scanner.nextLine());
                        veicolo = new Motocicletta(targa, annoImmatricolazione, cavalletto);
                    } else {
                        System.out.println("Tipo di veicolo non riconosciuto. Riprova.");
                        continue;
                    }
                    gestoreFlotta.aggiungiVeicolo(veicolo);
                }
                case 2 -> {
                    System.out.print("Inserisci la targa del veicolo da cercare: ");
                    String targaDaCercare = scanner.nextLine();
                    Veicolo veicoloTrovato = gestoreFlotta.trovaVeicolo(targaDaCercare);
                    if (veicoloTrovato != null) {
                        System.out.println("Veicolo trovato: " + veicoloTrovato.getClass().getSimpleName()
                                + " - Targa: " + veicoloTrovato.getTarga()
                                + " - Anno di immatricolazione: " + veicoloTrovato.getAnnoImmatricolazione());
                    } else {
                        System.out.println("Nessun veicolo trovato con la targa inserita.");
                    }
                }
                case 3 -> gestoreFlotta.contaVeicoli(gestoreFlotta.getFlotta());
                case 4 -> continua = false;
                default -> System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}
