package org.learning.java.springlamiapizzeriacrud.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ingredienti")
public class Ingrediente {
    // ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToMany(mappedBy = "ingredienti")
    private List<Pizza> pizze;
    // GETTERS E SETTERS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pizza> getPizze() {
        return pizze;
    }

    public void setPizze(List<Pizza> pizze) {
        this.pizze = pizze;
    }
}
