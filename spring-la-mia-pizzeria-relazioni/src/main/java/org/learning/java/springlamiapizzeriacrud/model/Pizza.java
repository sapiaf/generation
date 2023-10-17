package org.learning.java.springlamiapizzeriacrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pizze")
public class Pizza {
    // ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "il nome non può essere vuoto")
    @Size(max = 70, message = "Il nome della pizza non può superare i 70 caratteri")
    private String nome;
    @NotBlank(message = "la descrizione non può essere vuota")
    @Size(max = 255, message = "la descrizione non può superare i 255 caratteri")
    private String descrizione;
    @NotNull(message = "Il prezzo è obbligatorio")
    @DecimalMin(value = "0.01", message = "Il prezzo deve essere maggiore di zero")
    private BigDecimal prezzo;
    @Column(name = "foto_url")
    private String fotoUrl;
    @OneToMany(mappedBy = "pizza", cascade = {CascadeType.REMOVE})
    private List<Offerta> offerte;

    @ManyToMany
    @JoinTable(name ="pizza_ingrediente", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<Ingrediente> ingredienti;

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
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public BigDecimal getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
    public String getFotoUrl() {
        return fotoUrl;
    }
    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
    public List<Offerta> getOfferte() {
        return offerte;
    }
    public void setOfferte(List<Offerta> offerte) {
        this.offerte = offerte;
    }
    public List<Ingrediente> getIngredienti() {
        return ingredienti;
    }
    public void setIngredienti(List<Ingrediente> ingredienti) {
        this.ingredienti = ingredienti;
    }
}
