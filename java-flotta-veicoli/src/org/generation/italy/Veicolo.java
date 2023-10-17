package org.generation.italy;

public abstract class Veicolo {

    // ATTRIBUTI
    private final String targa;
    private final int annoImmatricolazione;

    // COSTRUTTORE
    public Veicolo(String targa, int annoImmatricolazione) {

        this.targa = targa;
        this.annoImmatricolazione = annoImmatricolazione;
    }

    // GETTER E SETTERS
    public String getTarga() {
        return targa;
    }

    public int getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    // METODI
    @Override
    public String toString() {
        return "Veicolo {" +
                "\n   targa = '" + targa + '\'' +
                "\n   annoImmatricolazione = " + annoImmatricolazione +
                "\n}";
    }
}
