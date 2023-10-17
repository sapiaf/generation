package org.generation.agenzia;

import java.util.ArrayList;
import java.util.List;

public class AgenziaImmobiliare {
    // ATTRIBUTI
    private List<Immobile> listaImmobili;

    // COSTRUTTORE
    public AgenziaImmobiliare(){

        this.listaImmobili = new ArrayList<>();
    }


    // METODI
    public void aggiungiImmobile(Immobile immobile) throws ImmobiliareException{
        String codiceNuovoImmobile = immobile.getCodice();

        if (!isCodicePresente(codiceNuovoImmobile)) {
            throw new ImmobiliareException("Il codice inserito è già presente.");
        }

        listaImmobili.add(immobile);
        System.out.println("Immobile aggiunto con successo.");
    }

    public boolean isCodicePresente(String codice){
        for (Immobile immobile : listaImmobili) {
            if (immobile.getCodice().equalsIgnoreCase(codice)) {
                return false;
            }
        }
        return true;
    }


    public void cercaPerCitta(String citta) throws ImmobiliareException {
        List<Immobile> immobiliCorrispondenti = new ArrayList<>();

        for (Immobile immobile : listaImmobili) {
            if (immobile.getCitta().equalsIgnoreCase(citta)) {
                immobiliCorrispondenti.add(immobile);
            }
        }

        if (immobiliCorrispondenti.isEmpty()) {
            throw new ImmobiliareException("Nessun immobile nella città inserita: " + citta);
        } else {
            System.out.println("Immobili corrispondenti agli interessi: ");
            for (Immobile immobile : immobiliCorrispondenti) {
                System.out.println(immobile);
            }
        }
    }


    public void cercaPerSuperficie(double superficie) throws ImmobiliareException {
        List<Immobile> immobiliCorrispondenti = new ArrayList<>();

        for (Immobile immobile : listaImmobili) {
            if (immobile.getSuperficie() >= superficie) {
                immobiliCorrispondenti.add(immobile);
            }
        }

        if (immobiliCorrispondenti.isEmpty()) {
            throw new ImmobiliareException("Nessun immobile trovato per la superficie inserita: " + superficie);
        } else {
            System.out.println("Immobili corrispondenti agli interessi: ");
            for (Immobile immobile : immobiliCorrispondenti) {
                System.out.println(immobile);
            }
        }
    }


    public void cercaPerCodice(String codice) throws ImmobiliareException {
        boolean immobileTrovato = false;

        for (Immobile immobile : listaImmobili) {
            if (immobile.getCodice().equalsIgnoreCase(codice)) {
                System.out.println(immobile);
                immobileTrovato = true;
                break;
            }
        }

        if (!immobileTrovato) {
            throw new ImmobiliareException("Il codice inserito (" + codice + ") non è stato trovato tra i nostri immobili.");
        }
    }

    public void getImmobileInteressante() throws ImmobiliareException {
        if (listaImmobili.isEmpty()) {
            throw new ImmobiliareException("Nessun immobile presente.");
        }

        Immobile immobileInteressante = null;
        int maxPersoneInteressate = -1;

        for (Immobile immobile : listaImmobili) {
            int personeInteressate = immobile.getPersoneInteressate();
            if (personeInteressate > maxPersoneInteressate) {
                immobileInteressante = immobile;
                maxPersoneInteressate = personeInteressate;
            }
        }

        if (maxPersoneInteressate == 0) {
            System.out.println("Nessun immobile con interesse trovato.\n");
        } else {
            System.out.println("L'immobile con più persone interessate è:");
            System.out.println("Numero di interessi: " + immobileInteressante.getPersoneInteressate());
            System.out.println(immobileInteressante);
        }
    }

    public void aggiungiInteresse(String codice) throws ImmobiliareException {
        boolean immobileTrovato = false;

        for (Immobile immobile : listaImmobili) {
            if (immobile.getCodice().equalsIgnoreCase(codice)) {
                immobile.aumentaPersoneInteressate();
                immobileTrovato = true;
                System.out.println("Interesse aggiunto per l'immobile con codice " + codice + ".\n");
                break;
            }
        }

        if (!immobileTrovato) {
            throw new ImmobiliareException("Nessun immobile trovato con il codice " + codice + ".\n");
        }
    }

    public void rimuoviImmobile(String codice) throws ImmobiliareException {
        Immobile immobileDaRimuovere = null;

        for (Immobile immobile : listaImmobili) {
            if (immobile.getCodice().equals(codice)) {
                immobileDaRimuovere = immobile;
                break;
            }
        }

        if (immobileDaRimuovere != null) {
            listaImmobili.remove(immobileDaRimuovere);
            throw new ImmobiliareException("Immobile con codice " + codice + " rimosso con successo.");
        } else {
            throw new ImmobiliareException("Nessun immobile trovato con il codice " + codice + ".");
        }
    }

    @Override
    public String toString() {
        if (listaImmobili.isEmpty()) {
            return "Nessun immobile presente.";
        }

        String result = "Lista degli immobili:\n";
        for (Immobile immobile : listaImmobili) {
            result += "Codice: " + immobile.getCodice() + "\n";
            result += "Indirizzo: " + immobile.getIndirizzo() + "\n";
            result += "CAP: " + immobile.getCap() + "\n";
            result += "Città: " + immobile.getCitta() + "\n";
            result += "Superficie: " + immobile.getSuperficie() + "\n";
            result += "Persone Interessate: " + immobile.getPersoneInteressate() + "\n\n";
        }

        return result;
    }



}
