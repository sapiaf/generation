package org.generation.agenzia;

public class Immobile {
    // ATTRIBUTI
    private String codice;
    private String indirizzo;
    private String cap;
    private String città;
    private int superficie;
    private int personeInteressate;

    // COSTRUTTORE
    public Immobile(String codice, String indirizzo, String cap, String città, int superficie) {
        this.codice = codice;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.città = città;
        this.superficie = superficie;
        this.personeInteressate = 0;
    }

    // GETTERS E SETTERS
    public String getCodice() {
        return codice;
    }

    public int getPersoneInteressate() {
        return personeInteressate;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCap() {
        return cap;
    }

    public String getCitta() {
        return città;
    }

    public int getSuperficie() {
        return superficie;
    }

    // METODI
    @Override
    public String toString() {
        return "Codice: " + codice + "\n" +
                "Indirizzo: " + indirizzo + "\n" +
                "CAP: " + cap + "\n" +
                "Città: " + città + "\n" +
                "Superficie: " + superficie + "\n" +
                "Persone Interessate: " + personeInteressate;
    }


    public void reimpostaSuperfici(int nuovaSuperficie) {
        this.superficie = nuovaSuperficie;
    }

    public void aumentaPersoneInteressate(){
        personeInteressate++;
    }
}
