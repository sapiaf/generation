public class Tratta {
    private int id;
    private String partenza;
    private String arrivo;
    private int km;

    public Tratta(int id, String partenza, String arrivo, int km) {
        this.id = id;
        this.partenza = partenza;
        this.arrivo = arrivo;
        this.km = km;
    }

    public int getId() {
        return id;
    }

    public String getPartenza() {
        return partenza;
    }

    public String getArrivo() {
        return arrivo;
    }

    public int getKm() {
        return km;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Partenza: " + partenza + ", Arrivo: " + arrivo + ", KM: " + km;
    }
}