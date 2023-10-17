package org.generation.agenzia;

public class Box extends Immobile{
    // ATTRIBUTI
    private int numeroPostiAuto;

    // COSTRUTTORE
    public Box(String codice, String indirizzo, String cap, String città, int superficie, int numeroPostiAuto) {
        super(codice, indirizzo, cap, città, superficie);
        this.numeroPostiAuto = numeroPostiAuto;

    }

    // METODI
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Posti Auto: " + numeroPostiAuto;
    }

}
