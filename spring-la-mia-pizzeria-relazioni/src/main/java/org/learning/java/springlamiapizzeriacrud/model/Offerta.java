package org.learning.java.springlamiapizzeriacrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
@Table(name = "offerte")
public class Offerta {
    // ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titolo;
    @NotNull(message = "Inserisci una data")
    @PastOrPresent(message = "Inserisci una data nel presente o nel passato")
    private LocalDate dataInizio;
    @NotNull(message = "Inserisci una data")
    @FutureOrPresent(message = "Inserisci una data nel presente o nel passato")
    private LocalDate dataFine;
    @ManyToOne
    private Pizza pizza;

    // GETTERS E SETTERS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public LocalDate getDataInizio() {
        return dataInizio;
    }
    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }
    public LocalDate getDataFine() {
        return dataFine;
    }
    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }
    public Pizza getPizza() {
        return pizza;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
