package org.java.inheritance.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;


public class Prodotto {

    // ATTRIBUTI
    private int codice;
    private String nome;
    private String brand;
    private BigDecimal prezzo;
    private BigDecimal iva;

    // COSTRUTTORI
    public Prodotto(String nome, String brand, BigDecimal prezzo, BigDecimal iva) {
        this.codice = Integer.parseInt(generaNumeroCasuale());
        this.nome = nome;
        this.brand = brand;
        this.prezzo = prezzo;
        this.iva = iva;
    }

    public Prodotto(String nomeInput, String brandInput, BigDecimal prezzoInput, BigDecimal ivaInput, int i, boolean b) {
    }


    // GETTERS E SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public int getCodice() {
        return codice;
    }

    // METODI
    @Override
    public String toString() {
        return "Prodotto{" +
                "codice=" + codice +
                ", nome='" + nome + '\'' +
                ", brand='" + brand + '\'' +
                ", prezzo=" + prezzo +
                ", iva=" + iva +
                '}';
    }

    public BigDecimal getPrezzoIva() {
        BigDecimal vatOnPrice = prezzo.multiply(iva);
        BigDecimal fullPrice = prezzo.add(vatOnPrice);
        return fullPrice.setScale(2, RoundingMode.HALF_EVEN);
    }

    private String generaNumeroCasuale() {
        Random random = new Random();
        int randomNum = random.nextInt(1, 9999);
        String randomNumString = String.valueOf(randomNum);
        while (randomNumString.length() < 8) {
            randomNumString = "0" + randomNumString;
        }
        return randomNumString;
    }


    public BigDecimal calcolaPrezzoScontato(boolean hasTesseraFedelta) {
        BigDecimal scontoPercentuale = new BigDecimal("0.02");
        if (hasTesseraFedelta) {

        }
        return prezzo.subtract(prezzo.multiply(scontoPercentuale)).setScale(2, RoundingMode.HALF_EVEN);
    }


}
