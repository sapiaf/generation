import java.time.LocalDate;
import java.util.Objects;

public abstract class Evento {
    // ATTRIBUTI
    private int id;
    private String titolo;
    private LocalDate data;
    private int numeroPostiTotali;
    private int numeroPostiPrenotati;
    // CONSTRUCTOR
    public Evento(int id, String titolo, LocalDate data, int numeroPostiTotali, int numeroPostiPrenotati) {
        if (!Utilities.isValidData(data)) throw new IllegalArgumentException("La data dell'evento non può essere nel passato!");
        if (!Utilities.isValidNumeroPostiTotali(numeroPostiTotali)) throw new IllegalArgumentException("Il numero di posti totali deve essere positivo!");
        if (!Utilities.isValidTitle(titolo)) throw new IllegalArgumentException("Il titolo non può essere null oppure vuoto.");

        this.id = id;
        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        this.numeroPostiPrenotati = numeroPostiPrenotati;

    }
    // GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        if (!Utilities.isValidTitle(titolo)) throw new IllegalArgumentException("Il titolo non può essere null oppure vuoto.");
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (!Utilities.isValidData(data)) throw new IllegalArgumentException("La data dell'evento non può essere nel passato!");
        this.data = data;
    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }
    // METODI
    public int getPostiDisponibili() {
        return numeroPostiTotali - numeroPostiPrenotati;
    }

    public void prenota(int numeroPosti) {
        if (!Utilities.isValidData(data)) throw new IllegalArgumentException("L'evento è già passato.");
        if (!Utilities.isValidNumeroPosti(numeroPosti)) throw new IllegalArgumentException("Il numero di posti da prenotare deve essere maggiore di zero.");
        if (numeroPosti > getPostiDisponibili()) throw new IllegalArgumentException("Mi dispiace, non ci sono abbastanza posti disponibili.");

        numeroPostiPrenotati += numeroPosti;
    }

    public void disdici(int numeroPosti) {
        if (!Utilities.isValidData(data)) throw new IllegalArgumentException("L'evento è già passato.");
        if (numeroPostiPrenotati < numeroPosti) throw new IllegalArgumentException("Il numero di posti da disdire è maggiore dei posti prenotati.");
        if (!Utilities.isValidNumeroPosti(numeroPosti)) throw new IllegalArgumentException("Il numero di posti da prenotare deve essere maggiore di zero.");
        numeroPostiPrenotati -= numeroPosti;
    }


    @Override
    public String toString() {
        return id + " - " + data + " - " + titolo;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Evento evento = (Evento) object;
        return Objects.equals(titolo, evento.titolo) && Objects.equals(data, evento.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, data);
    }
}
