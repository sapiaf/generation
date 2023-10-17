import java.time.LocalDate;
import java.util.ArrayList;

public class ProgrammEventi {
    // ATTRIBUTI
    private String titolo;
    private static final DatabaseManager database = new DatabaseManager();
    private ArrayList<Evento> eventi;
    // COSTRUTTORE
    public ProgrammEventi(String titolo) {
        if (!Utilities.isValidTitle(titolo)) throw new IllegalArgumentException("Il titolo non può essere null oppure vuoto.");
        this.titolo = titolo;
        this.eventi = database.getEventiFromDatabase();
    }
    // GETTERS E SETTERS

    public String getTitolo() {
        return titolo;
    }

    public ArrayList<Evento> getEventi() {
        return eventi;
    }

    public void setTitolo(String titolo) {
        if (!Utilities.isValidTitle(titolo)) throw new IllegalArgumentException("Il titolo non può essere null oppure vuoto.");
        this.titolo = titolo;
    }

    // METODI
    public void aggiungiEvento(Evento evento) {
        if (eventi.contains(evento)) {
            throw new IllegalArgumentException("L'evento è già presente nella lista.");
        }
        eventi.add(evento);
    }

    public ArrayList<Evento> getEventoPerData(LocalDate data) {
        ArrayList<Evento> eventiCorrispondenti = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().equals(data)) {
                eventiCorrispondenti.add(evento);
            }
        }
        return eventiCorrispondenti;
    }

    public Evento getEventoPerID(int id) {
        for (Evento evento : eventi) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null;
    }
    public Evento getEventoPerTitolo(String titolo) {
        for (Evento evento : eventi) {
            if (evento.getTitolo().equalsIgnoreCase(titolo)) {
                return evento;
            }
        }
        return null;
    }

    public int numeroEventi() {
        return eventi.size();
    }

    public void eliminaEventi() {
        eventi.clear();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Programma: " + titolo + "\n");
        for (Evento evento : eventi) {
            result.append(evento.toString()).append("\n");
        }
        return result.toString();
    }
}
