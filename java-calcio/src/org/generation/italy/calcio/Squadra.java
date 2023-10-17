package org.generation.italy.calcio;

import java.util.List;

public class Squadra {

    // ATTRIBUTI
    private List<Giocatore> giocatori;
    private Allenatore allenatore;
    private String nomeSquadra;

    // COSTRUTTORE
    public Squadra(List<Giocatore> giocatori, Allenatore allenatore, String nomeSquadra) {
        this.giocatori = giocatori;
        this.allenatore = allenatore;
        this.nomeSquadra = nomeSquadra;
    }

    // GETTERS E SETTERS
    public List<Giocatore> getGiocatori() {
        return giocatori;
    }
    public Allenatore getAllenatori() {
        return allenatore;
    }

    public String getNomeSquadra() {
        return nomeSquadra;
    }

    // METODI
    @Override
    public String toString() {
        String squadraInfo = "Nome Squadra: " + nomeSquadra + "\n";
        String allenatoreInfo = "Allenatore: " + allenatore.getNome() + ", Data di Nascita: " + allenatore.getDataDiNascita() + ", Strategia: " + allenatore.getStrategia();

        String giocatoriInfo = "Giocatori:\n";
        for (Giocatore giocatore : giocatori) {
            giocatoriInfo += "- Nome: " + giocatore.getNome() + ", Data di Nascita: " + giocatore.getDataDiNascita() + ", Ruolo: " + giocatore.getRuolo() + "\n";
        }

        return squadraInfo + giocatoriInfo + allenatoreInfo;
    }


}
