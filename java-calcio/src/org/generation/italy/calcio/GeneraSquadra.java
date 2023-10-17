package org.generation.italy.calcio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneraSquadra {
    private static final String[] NOMI_COGNOMI_GIOCATORI = {
            "Marco Rossi", "Alessio Bianchi", "Lorenzo Russo", "Simone Ferrara", "Andrea Martini",
            "Luca Rossetti", "Davide Fontana", "Giovanni Ricci", "Filippo Bellini", "Nicolas De Luca",
            "Emanuele Gallo", "Matteo Rossi", "Paolo Marini", "Riccardo Leone", "Tommaso Vitale",
            "Enrico Longo", "Lorenzo Gatti", "Mattia Barbieri", "Pietro Greco", "Luigi Fiore",
            "Dario Lombardi", "Andrea Mariani", "Fabio Serra", "Stefano Ruggiero", "Davide Palumbo",
            "Nicola Lombardi", "Michele Russo", "Alessio D'Amico", "Gianluca Santoro", "Nicolas Lombardi",
            "Fabrizio Marino", "Simone Barone", "Daniele Pellegrini", "Roberto Mariani", "Andrea Rizzi",
            "Matteo Moretti", "Davide Barbieri", "Stefano Bianchi", "Pietro Marchetti", "Nicolas Santoro",
            "Marco Monti", "Giovanni Martino", "Lorenzo Galli", "Alessandro Marchetti", "Luca Coppola",
            "Davide Palmieri", "Giacomo Leone", "Matteo Santoro", "Fabrizio Marino", "Gianluca Fontana",
            "Alessandro De Angelis", "Leonardo Sorrentino", "Davide Farina", "Federico Romano",
            "Simone Rinaldi", "Francesco Esposito", "Luca Vitale", "Domenico Ferrara", "Antonio Martini",
            "Mario Rossetti", "Angelo Coppola", "Carmine Bellini", "Vincenzo Ricci", "Salvatore Greco",
            "Giovanni Marchetti", "Francesco Barbieri", "Raffaele Lombardi", "Federico Bianchi",
            "Emanuele Pellegrini", "Alessio Marino", "Stefano De Rosa", "Lorenzo Santoro",
            "Gianluca De Luca", "Alberto Monti", "Gabriele Martino", "Roberto Galli", "Matteo Ferri",
            "Alessandro Mariani", "Antonio Vitale", "Nicola Romano", "Massimo Palmieri", "Daniele Ferrari",
            "Vincenzo Greco", "Salvatore Moretti", "Davide Santoro", "Riccardo Marini", "Leonardo Fiore",
            "Angelo Ruggiero", "Carmine Sorrentino", "Emanuele Farina", "Francesco Rinaldi",
            "Luigi Esposito", "Domenico Vitale", "Antonio De Angelis", "Mario Barbieri", "Giovanni Marchetti",
            "Francesco Russo", "Raffaele Martini", "Federico Coppola", "Emanuele Bellini", "Alessio Ricci"
    };
    private static final String[] RUOLI_GIOCATORI = {"Difensore", "Centrocampista", "Attaccante"};
    private static final String[] STRATEGIA_ALLENATORE = {"4-3-3", "3-5-2", "4-4-2", "4-2-3-1"};
    private static final String[] NOMI_SQUADRE = {
            "Real Madrid",
            "FC Barcelona",
            "Manchester United",
            "Liverpool FC",
            "AC Milan",
            "Inter Milan",
            "Juventus FC",
            "Bayern Munich",
            "Paris Saint-Germain",
            "Chelsea FC",
            "Manchester City",
            "Arsenal FC",
            "Borussia Dortmund",
            "Tottenham Hotspur",
            "Atletico Madrid",
            "Ajax Amsterdam",
            "Benfica",
            "FC Porto",
            "Rangers FC",
            "Celtic FC"
    };


    private List<String> nomiUtilizzati;
    private String nomeSquadra;
    private String nomeAllenatore;
    private String strategiaAllenatore;

    public GeneraSquadra(String nomeSquadra, String nomeAllenatore, String strategiaAllenatore) {
        nomiUtilizzati = new ArrayList<>();
        this.nomeSquadra = nomeSquadra;
        this.nomeAllenatore = nomeAllenatore;
        this.strategiaAllenatore = strategiaAllenatore;
    }

    public GeneraSquadra() {
        this.nomeSquadra = generaNomesquadraRandom();
        Allenatore allenatoreCasuale = generaAllenatoreRandom();
        this.nomeAllenatore = allenatoreCasuale.getNome();
        this.strategiaAllenatore = allenatoreCasuale.getStrategia();
    }

    public List<Giocatore> generaGiocatori() {
        List<Giocatore> giocatori = new ArrayList<>();
        Random random = new Random();

        String nomePortiere = NOMI_COGNOMI_GIOCATORI[random.nextInt(NOMI_COGNOMI_GIOCATORI.length)];
        LocalDate dataDiNascitaPortiere = LocalDate.of(1990 + random.nextInt(20), random.nextInt(12) + 1, random.nextInt(28) + 1);
        giocatori.add(new Giocatore(nomePortiere, dataDiNascitaPortiere, "Portiere"));
        nomiUtilizzati.add(nomePortiere);

        while (giocatori.size() < 10) {
            String nomeCasuale = NOMI_COGNOMI_GIOCATORI[random.nextInt(NOMI_COGNOMI_GIOCATORI.length)];
            LocalDate dataDiNascitaCasuale = LocalDate.of(1990 + random.nextInt(20), random.nextInt(12) + 1, random.nextInt(28) + 1);
            String ruoloCasuale = RUOLI_GIOCATORI[random.nextInt(RUOLI_GIOCATORI.length)];

            if (!nomiUtilizzati.contains(nomeCasuale)) {
                giocatori.add(new Giocatore(nomeCasuale, dataDiNascitaCasuale, ruoloCasuale));
                nomiUtilizzati.add(nomeCasuale);
            }

        }
        return giocatori;
    }

    public Allenatore generaAllenatore(String nomeAllenatore) {
        Random random = new Random();
        LocalDate dataDiNascitaAllenatore = LocalDate.of(1970 + random.nextInt(20), random.nextInt(12) + 1, random.nextInt(28) + 1);
        return new Allenatore(nomeAllenatore, dataDiNascitaAllenatore, strategiaAllenatore);
    }

    public Allenatore generaAllenatoreRandom() {
        Random random = new Random();

        String nomeAllenatore;
        do {
            nomeAllenatore = NOMI_COGNOMI_GIOCATORI[random.nextInt(NOMI_COGNOMI_GIOCATORI.length)];
        } while (nomiUtilizzati.contains(nomeAllenatore));

        String strategiaAllenatore = STRATEGIA_ALLENATORE[random.nextInt(STRATEGIA_ALLENATORE.length)];
        LocalDate dataDiNascitaAllenatore = LocalDate.of(1970 + random.nextInt(20), random.nextInt(12) + 1, random.nextInt(28) + 1);

        return new Allenatore(nomeAllenatore, dataDiNascitaAllenatore, strategiaAllenatore);
    }


    private String generaNomesquadraRandom() {
        Random random = new Random();
        return NOMI_SQUADRE[random.nextInt(NOMI_SQUADRE.length)];
    }


    public Squadra generaSquadra() {
        List<Giocatore> giocatori = generaGiocatori();
        Allenatore allenatore = generaAllenatore(nomeAllenatore);
        return new Squadra(giocatori, allenatore, nomeSquadra);
    }


}
