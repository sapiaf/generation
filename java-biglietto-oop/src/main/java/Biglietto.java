import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Biglietto {
    private int etaPasseggero;
    private int km;
    private LocalDate data;
    private boolean isFlessibile;
    private static final int DURATA_NORMALE = 30;
    private static final int DURATA_FLESSIBILE = 90;
    private static final BigDecimal MAGGIORAZIONE_FLESSIBILE = new BigDecimal("0.10");
    private static final BigDecimal COSTO_CHILOMETRICO = new BigDecimal("0.21");
    private static final BigDecimal SCONTO_OVER_65 = new BigDecimal("0.40");
    private static final BigDecimal SCONTO_UNDER_18 = new BigDecimal("0.20");

    public Biglietto(int etaPasseggero, int km, LocalDate data, boolean isFlessibile) {
        if (!isValidKm(km)) {
            throw new IllegalArgumentException("Numero di Km inseriti non valido.");
        }

        if (!isValidEta(etaPasseggero)) {
            throw new IllegalArgumentException("Età del passeggero non valida.");
        }

        if (!isValidData(data)) {
            throw new IllegalArgumentException("Data del biglietto non valida. La data deve essere odierna o futura.");
        }

        this.etaPasseggero = etaPasseggero;
        this.km = km;
        this.data = data;
        this.isFlessibile = isFlessibile;
    }

    private boolean isValidData(LocalDate data) {
        return data.isEqual(LocalDate.now()) || data.isAfter(LocalDate.now());
    }

    private boolean isValidKm(int km) {
        return km > 0 && km <= 10000;
    }

    private boolean isValidEta(int eta) {
        return eta >= 0 && eta <= 110;
    }

    public BigDecimal calcolaPrezzo() {
        BigDecimal prezzoBase = COSTO_CHILOMETRICO.multiply(new BigDecimal(this.km));
        BigDecimal sconto = calcolaSconto(prezzoBase);
        prezzoBase = prezzoBase.subtract(sconto);

        if (isFlessibile) {
            prezzoBase = prezzoBase.add(prezzoBase.multiply(MAGGIORAZIONE_FLESSIBILE));
        }
        return prezzoBase.setScale(2, RoundingMode.HALF_UP);
    }


    private BigDecimal calcolaSconto(BigDecimal prezzoBase) {
        if (this.etaPasseggero < 18) {
            return prezzoBase.multiply(SCONTO_UNDER_18);
        } else if (this.etaPasseggero >= 65) {
            return prezzoBase.multiply(SCONTO_OVER_65);
        } else {
            return BigDecimal.ZERO;
        }
    }

    public LocalDate calcolaDataScadenza() {
        if (isFlessibile) {
            return data.plusDays(DURATA_FLESSIBILE);
        } else {
            return data.plusDays(DURATA_NORMALE);
        }
    }
}