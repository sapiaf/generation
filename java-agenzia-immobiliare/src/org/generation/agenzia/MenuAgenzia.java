package org.generation.agenzia;

import java.util.Scanner;

public class MenuAgenzia {
    private AgenziaImmobiliare agenzia;
    private Scanner scanner;

    public MenuAgenzia(){
        this.agenzia = new AgenziaImmobiliare();
        this.scanner = new Scanner(System.in);
    }

    public void avviaProgramma() {
        try {
            immobiliRandom();
        } catch (ImmobiliareException e) {
            System.out.println(e.getMessage());
            return;
        }

        while (true) {
            opzioniMenu();
            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    aggiungiImmobile();
                    break;
                case 2:
                    ricercaImmobile();
                    break;
                case 3:
                    rimuoviImmobile();
                    break;
                case 4:
                    aggiungiInteresse();
                    break;
                case 5:
                    visualizzaImmobileInteressante();
                    break;
                case 6:
                    visualizzaListaImmobili();
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    return;
                default:
                    System.out.println("Opzione non valida.");
            }
        }
    }

    private void opzioniMenu(){
        System.out.println("Seleziona un'opzione:");
        System.out.println("1. Aggiungi immobile");
        System.out.println("2. Ricerca immobile");
        System.out.println("3. Rimuovi immobile");
        System.out.println("4. Aggiungi interesse");
        System.out.println("5. Visualizza immobile più interessante");
        System.out.println("6. Visualizza lista immobili");
        System.out.println("0. Esci");
    }

    private void aggiungiImmobile() {
        System.out.println("Che tipo di abitazione vuoi aggiungere?");
        System.out.println("1. Abitazione");
        System.out.println("2. Villa");
        System.out.println("3. Box");
        int typeChoice = Integer.parseInt(scanner.nextLine());
        System.out.print("Inserisci il codice dell'immobile: ");
        String codiceImmobile = scanner.nextLine();
        System.out.print("Inserisci l'indirizzo dell'immobile: ");
        String indirizzoImmobile = scanner.nextLine();
        System.out.print("Inserisci il CAP dell'immobile: ");
        String capImmobile = scanner.nextLine();
        System.out.print("Inserisci la città dell'immobile: ");
        String cittaImmobile = scanner.nextLine();
        System.out.print("Inserisci la superficie dell'immobile: ");
        int superficieImmobile = Integer.parseInt(scanner.nextLine());
        switch (typeChoice) {
            case 1 -> {
                System.out.print("Inserisci il numero di vani dell'abitazione: ");
                int numeroVani = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserisci il numero di bagni dell'abitazione: ");
                int numeroBagni = Integer.parseInt(scanner.nextLine());
                try {
                    agenzia.aggiungiImmobile(new Abitazione(codiceImmobile, indirizzoImmobile, capImmobile, cittaImmobile, superficieImmobile, numeroVani, numeroBagni));
                } catch (ImmobiliareException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 2 -> {
                System.out.print("Inserisci il numero di vani della villa: ");
                int numeroVaniVilla = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserisci il numero di bagni della villa: ");
                int numeroBagniVilla = Integer.parseInt(scanner.nextLine());
                System.out.print("Inserisci la superficie del giardino della villa: ");
                int superficieGiardino = Integer.parseInt(scanner.nextLine());
                try {
                    agenzia.aggiungiImmobile(new Villa(codiceImmobile, indirizzoImmobile, capImmobile, cittaImmobile, superficieImmobile, numeroVaniVilla, numeroBagniVilla, superficieGiardino));
                } catch (ImmobiliareException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 3 -> {
                System.out.print("Inserisci il numero di posti auto del box: ");
                int numPostiAuto = Integer.parseInt(scanner.nextLine());
                try {
                    agenzia.aggiungiImmobile(new Box(codiceImmobile, indirizzoImmobile, capImmobile, cittaImmobile, superficieImmobile, numPostiAuto));
                } catch (ImmobiliareException e) {
                    System.out.println(e.getMessage());
                }
            }
            default -> System.out.println("Tipo di abitazione non valido.");
        }
    }

    private void ricercaImmobile() {
        System.out.println("Modalità di ricerca: ");
        System.out.println("1. Ricerca per citta");
        System.out.println("2. Ricerca per superficie");
        System.out.println("3. Ricerca per codice");
        System.out.println("0. Esci");
        System.out.print("Seleziona la modalità di ricerca (inserisci il numero corrispondente): ");
        int scelta = Integer.parseInt(scanner.nextLine());
        switch (scelta) {
            case 1 -> {
                System.out.print("Inserisci il nome della città: ");
                String citta = scanner.nextLine();
                try {
                    agenzia.cercaPerCitta(citta);
                } catch (ImmobiliareException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 2 -> {
                System.out.print("Inserisci la superficie dell'immobile: ");
                double superficie = Double.parseDouble(scanner.nextLine());
                try {
                    agenzia.cercaPerSuperficie(superficie);
                } catch (ImmobiliareException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 3 -> {
                System.out.print("Inserisci il codice dell'immobile: ");
                String codice = scanner.nextLine();
                try {
                    agenzia.cercaPerCodice(codice);
                } catch (ImmobiliareException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 0 -> System.out.println("Hai scelto di uscire. Arrivederci!");
            default ->
                    System.out.println("Scelta non valida. Si prega di inserire un numero valido (da 0 a 3).");
        }
    }

    private void rimuoviImmobile() {
        System.out.print("Inserisci il codice dell'immobile da rimuovere: ");
        String codiceRimuovere = scanner.nextLine();
        try {
            agenzia.rimuoviImmobile(codiceRimuovere);
        } catch (ImmobiliareException e) {
            System.out.println(e.getMessage());
        }
    }

    private void aggiungiInteresse() {
        System.out.print("Inserisci il codice dell'immobile al quale aggiungere interesse: ");
        String codiceInteresse = scanner.nextLine();
        try {
            agenzia.aggiungiInteresse(codiceInteresse);
        } catch (ImmobiliareException e) {
            System.out.println(e.getMessage());
        }
    }

    private void visualizzaImmobileInteressante() {
        try {
            agenzia.getImmobileInteressante();
        } catch (ImmobiliareException e) {
            System.out.println(e.getMessage());
        }
    }

    private void visualizzaListaImmobili() {
        System.out.println(agenzia);
    }

    private void immobiliRandom() throws ImmobiliareException {
        agenzia.aggiungiImmobile(new Villa("V001", "Via delle Rose 20", "00100", "Roma", 200, 5, 3, 300));
        agenzia.aggiungiImmobile(new Abitazione("A001", "Via dei Girasoli 5", "00100", "Roma", 120, 4, 2));
        agenzia.aggiungiImmobile(new Box("B001", "Via delle Margherite 8", "00100", "Roma", 20, 1));
        agenzia.aggiungiImmobile(new Villa("V002", "Via delle Orchidee 15", "00100", "Roma", 180, 4, 3, 250));
        agenzia.aggiungiImmobile(new Abitazione("A002", "Via dei Fiori 30", "00100", "Roma", 100, 3, 1));
    }

}