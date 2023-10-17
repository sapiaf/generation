package org.generation.italy.calcio;

import java.time.LocalDate;

public class Giocatore extends Persona{
    // ATTRIBUTI
    private String ruolo;

    // COSTRUTTORE
    public Giocatore(String nome, LocalDate dataDiNascita, String ruolo) {
        super(nome, dataDiNascita);
        this.ruolo = ruolo;
    }

    // GETTERS  E SETTERS
    public String getRuolo() {
        return ruolo;
    }



}
