package org.lessons.java.shop;

import java.util.ArrayList;
import java.util.Random;

public class Prodotto {

    // ATTRIBUTI
    private String codice;
    private String nome;
    private String descrizione;
    private double prezzo;
    private double iva;
    private ArrayList<Categoria> categorie;

    // CONSTRUCTORS
    public Prodotto(String nome, String descrizione, double prezzo, double iva, ArrayList<Categoria> categorie) {
        this.codice = generaNumeroCasuale();
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.iva = iva;
        this.categorie = categorie;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public ArrayList<Categoria> getCategorie() {
        return categorie;
    }

    public void setCategorie(ArrayList<Categoria> categorie) {
        this.categorie = categorie;
    }

    // METODI

    @Override
    public String toString() {
        return "\nProdotto:\n" +
                "Codice:       " + codice + "\n" +
                "Nome:         " + nome + "\n" +
                "Descrizione:  " + descrizione + "\n" +
                "Prezzo:       " + prezzo + "\n" +
                "IVA:          " + iva + "\n" +
                "Categorie:    " + categorie + "\n";
    }

    public double prezzoLordo() {
        return prezzo;
    }

    public double prezzoNetto() {
        return prezzo * (1 + iva / 100);
    }

    public String nomeCompleto() {
        return codice + " - " + nome;
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

    public String getCodice() {
        return codice;
    }

}
