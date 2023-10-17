package org.generation.agenzia;

public class Abitazione extends Immobile{
    // ATTRIBUTI
    private int numeroVani;
    private int numeroBagni;
    public Abitazione(String codice, String indirizzo, String cap, String città, int superficie, int numeroVani, int numeroBagni) {
        super(codice, indirizzo, cap, città, superficie);
        this.numeroVani = numeroVani;
        this.numeroBagni = numeroBagni;
    }

    // METODI
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Vani: " + numeroVani + "\n" +
                "Bagni: " + numeroBagni;
    }


}
