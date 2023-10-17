package org.lessons.java.shop;

public class Categoria {

    // ATTRIBUTI
    private String nome;
    private String descrizione;

    // CONSTRUCTORS
    public Categoria(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
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


    @Override
    public String toString() {
        return "Categoria: " +
                "nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'';
    }
}


