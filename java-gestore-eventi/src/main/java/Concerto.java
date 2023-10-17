import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {
    // ATTRIBUTI
    private LocalTime ora;
    private BigDecimal prezzo;

    // COSTRUTTORE
    public Concerto(int id, String titolo, LocalDate data, int numeroPostiTotali, int numeroPostiPrenotati, LocalTime ora, BigDecimal prezzo) {
        super(id, titolo, data, numeroPostiTotali, numeroPostiPrenotati);
        if (!Utilities.isValidPrezzo(prezzo)) throw new IllegalArgumentException("Il prezzo deve essere maggiore di zero.");
        if (!Utilities.isValidDataOra(data, ora)) throw new IllegalArgumentException("La data e l'ora dell'evento non possono essere nel passato.");
        this.ora = ora;
        this.prezzo = prezzo;
    }

    // GETTERS E SETTERS
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        if (!Utilities.isValidDataOra(getData(), ora)) throw new IllegalArgumentException("La data e l'ora dell'evento non possono essere nel passato.");
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        if (!Utilities.isValidPrezzo(prezzo)) throw new IllegalArgumentException("Il prezzo deve essere maggiore di zero.");
        this.prezzo = prezzo;
    }


    // METODI
    public String prezzoFormattato() {
        return prezzo.setScale(2, RoundingMode.HALF_DOWN) + "€";
    }

    @Override
    public String toString() {
       return getId() + " - " + getData() + " - " + ora + " - "  + getTitolo() + " - " + prezzoFormattato();
    }
}
