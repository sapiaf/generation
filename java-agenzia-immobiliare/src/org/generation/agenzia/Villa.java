package org.generation.agenzia;

public class Villa extends Abitazione{
    private int superficieGiardino;
    public Villa(String codice, String indirizzo, String cap, String città, int superficie, int numeroVani, int numeroBagni,  int superficieGiardino) {
        super(codice, indirizzo, cap, città, superficie, numeroVani, numeroBagni);
        this.superficieGiardino = superficieGiardino;
    }

    // METODI
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Superficie Giardino: " + superficieGiardino;
    }


    public void reimpostaSuperfici(int nuovaSuperficie, int nuovaSuperficieGiardino) {
        super.reimpostaSuperfici(nuovaSuperficie);
        this.superficieGiardino = nuovaSuperficieGiardino;
    }

}
