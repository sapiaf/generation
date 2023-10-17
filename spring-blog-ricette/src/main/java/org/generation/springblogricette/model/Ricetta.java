package org.generation.springblogricette.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ricette")
public class Ricetta {
    // ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titolo;
    @Column(name = "lista_ingredienti")
    private String listaIngredienti;
    @Column(name = "foto_url")
    private String fotoUrl;
    @Column(name = "tempo_preparazione")
    private Integer tempoPreparazione;
    private Integer porzioni;
    @Column(name = "testo_ricetta")
    private String testoRicetta;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
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

    public String getListaIngredienti() {
        return listaIngredienti;
    }

    public void setListaIngredienti(String listaIngredienti) {
        this.listaIngredienti = listaIngredienti;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Integer getTempoPreparazione() {
        return tempoPreparazione;
    }

    public void setTempoPreparazione(Integer tempoPreparazione) {
        this.tempoPreparazione = tempoPreparazione;
    }

    public Integer getPorzioni() {
        return porzioni;
    }

    public void setPorzioni(Integer porzioni) {
        this.porzioni = porzioni;
    }

    public String getTestoRicetta() {
        return testoRicetta;
    }

    public void setTestoRicetta(String testoRicetta) {
        this.testoRicetta = testoRicetta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
