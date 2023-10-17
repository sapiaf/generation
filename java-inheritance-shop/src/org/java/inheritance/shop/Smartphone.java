package org.java.inheritance.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Smartphone extends Prodotto{
    // ATTRIBUTI

    private String imei;
    private int memoria;

    // COSTRUTTORI

    public Smartphone(String nome, String brand, BigDecimal prezzo, BigDecimal iva, String imei, int memoria) {
        super(nome, brand, prezzo, iva);
        this.imei = imei;
        this.memoria = memoria;
    }


    // GETTERS E SETTERS

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }


    // METODI


    @Override
    public String toString() {
        return "Smartphone{" +
                "imei='" + imei + '\'' +
                ", memoria=" + memoria +
                '}';
    }

    @Override
    public BigDecimal calcolaPrezzoScontato(boolean hasTesseraFedelta) {
        BigDecimal scontoPercentuale = new BigDecimal("0.02"); // Sconto del 2% di default
        if (hasTesseraFedelta) {
            if (getMemoria() < 32) {
                scontoPercentuale = new BigDecimal("0.05"); // Sconto del 5% per Smartphone con memoria < 32GB
            }
        }
        return getPrezzo().subtract(getPrezzo().multiply(scontoPercentuale)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
