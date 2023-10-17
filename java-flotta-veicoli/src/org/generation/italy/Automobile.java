package org.generation.italy;

public class Automobile extends Veicolo {
    // ATTRIBUTI
    private final int numeroPorte;

    // COSTRUTTORE

    public Automobile(String targa, int annoImmatricolazione, int numeroPorte) {
        super(targa, annoImmatricolazione);
        this.numeroPorte = numeroPorte;
    }

    // GETTERS E SETTERS
    public int getNumeroPorte() {
        return numeroPorte;
    }

    // METODI
    @Override
    public String toString() {
        return "Automobile {" +
                "\n   targa = '" + getTarga() + '\'' +
                "\n   annoImmatricolazione = " + getAnnoImmatricolazione() +
                "\n   numeroPorte = " + numeroPorte +
                "\n}";
    }
}
