package org.generation.italy.calcio;

import java.time.LocalDate;

abstract class Persona {
    // ATTRIBUTI
    private String nome;
    private LocalDate dataDiNascita;

    // COSTRUTTORE
    public Persona(String nome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.dataDiNascita = dataDiNascita;
    }
    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    // METODI

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
