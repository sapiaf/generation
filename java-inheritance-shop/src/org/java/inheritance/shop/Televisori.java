package org.java.inheritance.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Televisori extends Prodotto{

    // ATTRIBUTI
    private int dimensione;
    private boolean isSmart;

    // COSTRUTTORI
    public Televisori(String nome, String brand, BigDecimal prezzo, BigDecimal iva, int dimensione, boolean isSmart) {
        super(nome, brand, prezzo, iva);
        this.dimensione = dimensione;
        this.isSmart = isSmart;
    }

    // GETTERS E SETTERS

    public int getDimensione() {
        return dimensione;
    }

    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }


    // METODI

    @Override
    public String toString() {
        return "Televisori{" +
                "dimensione=" + dimensione +
                ", isSmart=" + isSmart +
                '}';
    }

    @Override
    public BigDecimal calcolaPrezzoScontato(boolean hasTesseraFedelta) {
        BigDecimal scontoPercentuale = new BigDecimal("0.02"); // Sconto del 2% di default
        if (hasTesseraFedelta) {
            if (!isSmart()) {
                scontoPercentuale = new BigDecimal("0.10"); // Sconto del 10% per Televisori non smart
            }
        }
        return getPrezzo().subtract(getPrezzo().multiply(scontoPercentuale)).setScale(2, RoundingMode.HALF_EVEN);
    }


}
