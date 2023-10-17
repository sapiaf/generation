import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private Biglietteria biglietteria;

    public UserInterface() {
        this.biglietteria = new Biglietteria();
    }

    public void start() {
        printTratte();
        Tratta trattaScelta = scegliTratta();

        if (trattaScelta != null) {
            prezzoBiglietto(trattaScelta);
        }

        scanner.close();
    }

    private void prezzoBiglietto(Tratta trattaScelta) {
        try {
            int eta = getEtaPasseggero();
            LocalDate dataPartenza = getDataPartenza();
            boolean isFlessibile = getSceltaFlessibile();
            int km = trattaScelta.getKm();

            Biglietto biglietto = new Biglietto(eta, km, dataPartenza, isFlessibile);
            BigDecimal prezzo = biglietto.calcolaPrezzo();
            System.out.println("Il prezzo del biglietto è: €" + prezzo);
            System.out.println("La data di scadenza del biglietto è: " + biglietto.calcolaDataScadenza());

        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
    private Tratta scegliTratta() {
        Tratta trattaScelta = null;
        String partenza;
        String arrivo;

        do {
            System.out.print("Inserisci la stazione di partenza (premere invio per uscire): ");
            partenza = scanner.nextLine();
            if (partenza.isEmpty()) break;

            System.out.print("Inserisci la stazione di arrivo (premere invio per uscire): ");
            arrivo = scanner.nextLine();
            if (arrivo.isEmpty()) break;

            trattaScelta = searchTratta(partenza, arrivo);

            if (trattaScelta == null) {
                System.out.println("Tratta non trovata. Riprova.");
            }
        } while (trattaScelta == null);
        return trattaScelta;
    }

    private void printTratte() {
        System.out.println("Elenco delle tratte disponibili:");
        for (Tratta tratta : biglietteria.getTratte()) {
            System.out.println(tratta);
        }
    }

    private static int getEtaPasseggero() {
        System.out.print("Inserisci l'età del passeggero: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static LocalDate getDataPartenza() {
        LocalDate dataPartenza = null;
        while(dataPartenza == null) {
            System.out.print("Inserisci la data di partenza (formato YYYY-MM-DD): ");
            try {
                dataPartenza = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Errore: formato data non valido. Riprova.");
            }
        }
        return dataPartenza;
    }

    private static boolean getSceltaFlessibile() {
        System.out.print("Vuoi un biglietto flessibile? (si/no): ");
        return scanner.nextLine().equalsIgnoreCase("si");
    }

    private Tratta searchTratta(String partenza, String arrivo) {
        for (Tratta tratta : biglietteria.getTratte()) {
            if (tratta.getPartenza().equalsIgnoreCase(partenza) && tratta.getArrivo().equalsIgnoreCase(arrivo)) {
                return tratta;
            }
        }
        return null;
    }
}
