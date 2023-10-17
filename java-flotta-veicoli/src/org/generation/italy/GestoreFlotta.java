package org.generation.italy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestoreFlotta {
    // ATTRIBUTI

    private final List<Veicolo> flotta = new ArrayList<>();
    // METODI

    // GETTER E SETTER
    public List<Veicolo> getFlotta() {
        return flotta;
    }


    // METODI
    public void aggiungiVeicolo(Veicolo veicolo) {
        String nuovaTarga = veicolo.getTarga();
        int annoImmatricolazione = veicolo.getAnnoImmatricolazione();

        if (!isTargaPresente(nuovaTarga)) {
            System.out.println("Errore: Il veicolo con targa " + nuovaTarga + " è già presente nella flotta.");
            return;
        }

        if (!controllaImmatricolazione(annoImmatricolazione)) {
            System.out.println("Errore: L'anno di immatricolazione non è valido.");
            return;
        }

        flotta.add(veicolo);
        System.out.println("Veicolo aggiunto con successo.");
    }

    public void contaVeicoli(List<Veicolo> veicoli) {
        int automobileCount = 0;
        int motociclettaCount = 0;

        for (Veicolo veicolo : veicoli) {
            if (veicolo instanceof Automobile) {
                automobileCount++;
            } else if (veicolo instanceof Motocicletta) {
                motociclettaCount++;
            }
        }

        System.out.println("Numero totale veicoli: " + flotta.size());
        System.out.println("Numero automobili: " + automobileCount);
        System.out.println("Numero motociclette: " + motociclettaCount);

        System.out.println("\nLista di tutti i veicoli nella flotta:");
        for (Veicolo veicolo : veicoli) {
            System.out.println("Targa: " + veicolo.getTarga());
            System.out.println("Immatricolazione: " + veicolo.getAnnoImmatricolazione());
            if (veicolo instanceof Automobile) {
                System.out.println("Tipo: Automobile");
                System.out.println("Porte: " + ((Automobile) veicolo).getNumeroPorte());
            } else if (veicolo instanceof Motocicletta) {
                System.out.println("Tipo: Motocicletta");
                System.out.println("Cavalletto: " + ((Motocicletta) veicolo).isCavalletto());
            }
            System.out.println();
        }
    }

    public boolean isTargaPresente(String numeroTarga) {
        for (Veicolo veicolo : flotta) {
            if (veicolo.getTarga().equals(numeroTarga)) {
                return false;
            }
        }
        return true;
    }

    public boolean controllaImmatricolazione(int annoImmatricolazione) {
        int annoCorrente = LocalDate.now().getYear();
        return annoCorrente >= annoImmatricolazione;
    }

    public Veicolo trovaVeicolo(String numeroTarga) {
        for (Veicolo veicolo : flotta) {
            if (veicolo.getTarga().equals(numeroTarga)) {
                return veicolo;
            }
        }
        return null;
    }


}
