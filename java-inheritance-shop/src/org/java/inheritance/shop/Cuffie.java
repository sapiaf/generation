package org.java.inheritance.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Cuffie extends Prodotto {

    // ATTRIBUTI

    private String colore;
    private boolean isWireless;

    // COSTRUTTORI
    public Cuffie(String nome, String brand, BigDecimal prezzo, BigDecimal iva, String colore, boolean isWireless) {
        super(nome, brand, prezzo, iva);
        this.colore = colore;
        this.isWireless = isWireless;
    }

    // GETTERS E SETTERS

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }


    // METODI


    @Override
    public String toString() {
        return "Cuffie{" +
                "colore='" + colore + '\'' +
                ", isWireless=" + isWireless +
                '}';
    }

    @Override
    public BigDecimal calcolaPrezzoScontato(boolean hasTesseraFedelta) {
        BigDecimal scontoPercentuale = new BigDecimal("0.02"); // Sconto del 2% di default
        if (hasTesseraFedelta) {
            if (!isWireless()) {
                scontoPercentuale = new BigDecimal("0.07"); // Sconto del 7% per Cuffie cablate
            }
        }
        return getPrezzo().subtract(getPrezzo().multiply(scontoPercentuale)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
