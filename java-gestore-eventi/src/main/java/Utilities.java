import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Utilities {
    public static boolean isValidPrezzo(BigDecimal prezzo) {
        return prezzo.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isValidDataOra(LocalDate data, LocalTime ora) {
        boolean dataValida = isValidData(data);
        boolean oraValida = ora.isAfter(LocalTime.now());
        return dataValida && oraValida;
    }

    public static boolean isValidData(LocalDate data) {
        return data.isAfter(LocalDate.now());
    }

    public static boolean isValidNumeroPostiTotali(int numeroPosti) {
        return numeroPosti > 0;
    }

    public static boolean isValidTitle(String titolo) {
        return titolo != null && !titolo.isBlank();
    }

    public static boolean isValidNumeroPosti(int numeroPosti) {
        return numeroPosti > 0;
    }
}
