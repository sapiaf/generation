import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private ProgrammEventi programma;
    private static final DatabaseManager database = new DatabaseManager();

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.programma = new ProgrammEventi("Lollapalooza");
    }
    private void opzioni() {
        System.out.println("Scegli un'opzione:");
        System.out.println("1. Aggiungi evento");
        System.out.println("2. Prenota posti");
        System.out.println("3. Disdici posti");
        System.out.println("4. Esci");
    }
    private void aggiungiEvento() {
        System.out.println("Inserisci i dettagli dell'evento:");
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Data (YYYY-MM-DD): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());
        System.out.print("Numero posti totali: ");
        int numeroPostiTotali = Integer.parseInt(scanner.nextLine());
        System.out.print("Ora (HH:MM): ");
        LocalTime ora = LocalTime.parse(scanner.nextLine());
        System.out.print("Prezzo: ");
        BigDecimal prezzo = new BigDecimal(scanner.nextLine());
        Concerto concerto = new Concerto(0, titolo, data, numeroPostiTotali, 0, ora, prezzo);
        programma.aggiungiEvento(concerto);
        database.aggiungiEvento(concerto);
        System.out.println("Evento aggiunto: " + concerto);
    }

    private Evento selezionaEvento() {
        System.out.println("Lista eventi:");
        System.out.println(programma);
        System.out.print("Inserisci ID dell'evento: ");
        int idEvento = Integer.parseInt(scanner.nextLine());
        return programma.getEventoPerID(idEvento);
    }
    private void prenotaEvento() {
        Evento concertoSelezionato = selezionaEvento();
        if (concertoSelezionato == null) {
            System.out.println("Evento non trovato.");
            return;
        }

        System.out.print("Quante posti vuoi prenotare? ");
        int prenotazioni = Integer.parseInt(scanner.nextLine());
        try {
            concertoSelezionato.prenota(prenotazioni);
            System.out.println("Posti prenotati: " + concertoSelezionato.getNumeroPostiPrenotati());
            System.out.println("Posti disponibili: " + (concertoSelezionato.getNumeroPostiTotali() - concertoSelezionato.getNumeroPostiPrenotati()));
            database.aggiornaPostiPrenotati(concertoSelezionato);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void disdiciEvento() {
        Evento concertoSelezionato = selezionaEvento();
        if (concertoSelezionato == null) {
            System.out.println("Evento non trovato.");
            return;
        }

        System.out.print("Quanti posti vuoi disdire? ");
        int postiDaDisdire = Integer.parseInt(scanner.nextLine());
        try {
            concertoSelezionato.disdici(postiDaDisdire);
            System.out.println("Posti prenotati: " + concertoSelezionato.getNumeroPostiPrenotati());
            System.out.println("Posti disponibili: " + (concertoSelezionato.getNumeroPostiTotali() - concertoSelezionato.getNumeroPostiPrenotati()));
            database.aggiornaPostiPrenotati(concertoSelezionato);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        while (true) {
            try {
                opzioni();
                int scelta = Integer.parseInt(scanner.nextLine());
                switch (scelta) {
                    case 1:
                        aggiungiEvento();
                        break;
                    case 2:
                        prenotaEvento();
                        break;
                    case 3:
                        disdiciEvento();
                        break;
                    case 4:
                        System.out.println("Arrivederci!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserisci un numero valido.");
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Errore: Formato data/ora non valido.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
