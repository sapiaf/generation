package org.generation.italy.calcio;

import java.time.LocalDate;

public class Allenatore extends Persona{
    // ATTRIBUTI
    private String strategia;

    // COSTRUTTORE
    public Allenatore(String nome, LocalDate dataDiNascita, String strategia) {
        super(nome, dataDiNascita);
        this.strategia = strategia;
    }

    // GETTERS E SETTERS
    public String getStrategia() {
        return strategia;
    }

    // METODI
}
