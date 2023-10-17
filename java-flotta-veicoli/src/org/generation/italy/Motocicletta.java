package org.generation.italy;

public class Motocicletta extends Veicolo {
    // ATTRIBUTI
    private final boolean cavalletto;

    // COSTRUTTORE
    public Motocicletta(String targa, int annoImmatricolazione, boolean cavalletto) {
        super(targa, annoImmatricolazione);
        this.cavalletto = cavalletto;
    }

    // GETTERS E SETTERS


    public boolean isCavalletto() {
        return cavalletto;
    }

    // METODI
    @Override
    public String toString() {
        return "Motocicletta {" +
                "\n   targa = '" + getTarga() + '\'' +
                "\n   annoImmatricolazione = " + getAnnoImmatricolazione() +
                "\n   cavalletto = " + cavalletto +
                "\n}";
    }
}
