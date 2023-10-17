package org.generation.italy.calcio;

import java.util.Random;

public class Partita {
    private Squadra squadraGiocatore;
    private Squadra squadraComputer;
    private Arbitro arbitro;
    private boolean isCominciata;
    private int goalSquadraGiocatore;
    private int goalSquadraComputer;

    public Partita(Squadra squadraGiocatore, Squadra squadraComputer, Arbitro arbitro) {
        this.squadraGiocatore = squadraGiocatore;
        this.squadraComputer = squadraComputer;
        this.arbitro = arbitro;
        this.isCominciata = false;
        this.goalSquadraGiocatore = 0;
        this.goalSquadraComputer = 0;
    }

    public void iniziaPartita(){
        isCominciata = true;
        System.out.println("Partiti.......");
        System.out.println(squadraGiocatore);
        System.out.println(squadraComputer);
        System.out.println("Arbitra " + arbitro);
    }

    public void segnaGoal(){
        if (isCominciata){
            Random random = new Random();
            String marcatore;
            int squadraCheHaSegnato = random.nextInt(2);

            if (squadraCheHaSegnato == 0){
                goalSquadraGiocatore++;
                marcatore = squadraGiocatore.getGiocatori().get(random.nextInt(squadraGiocatore.getGiocatori().size())).getNome();
                System.out.println("Ha segnato la squadra " + squadraGiocatore.getNomeSquadra() + " Goal di " + marcatore);
            } else {
                goalSquadraComputer++;
                marcatore = squadraComputer.getGiocatori().get(random.nextInt(squadraComputer.getGiocatori().size())).getNome();
                System.out.println("Ha segnato la squadra " + squadraComputer.getNomeSquadra() + "," + " Goal di " + marcatore);
            }
        } else {
            System.out.println("La partita non è ancora cominciata!");
        }
    }

    public void terminaPartita(){
        isCominciata = false;
        System.out.println("Partita terminata");
        if (goalSquadraComputer > goalSquadraGiocatore) {
            System.out.println("Hai Perso");
        } else if (goalSquadraComputer < goalSquadraGiocatore) {
            System.out.println("Hai Vinto");
        } else {
            System.out.println("Pareggio");
        }

    }
}
