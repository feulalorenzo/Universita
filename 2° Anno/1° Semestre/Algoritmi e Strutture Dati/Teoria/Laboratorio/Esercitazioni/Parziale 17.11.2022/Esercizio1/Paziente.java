package Esercizio1;

public class Paziente implements Comparable<Paziente>{
    String codiceFiscale;
    int eta;
    int reparto;

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }
    public int getReparto() {
        return reparto;
    }
    public void setReparto(int reparto) {
        this.reparto = reparto;
    }
    public Paziente(String cf, int e, int r){
        codiceFiscale = cf;
        eta = e;
        reparto = r;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Paziente))
            return false;
        Paziente p = (Paziente) obj;
        return this.codiceFiscale.equals(p.getCodiceFiscale()) && this.eta == p.getEta() && this.reparto == p.getReparto();
    }
    @Override
    public String toString(){
        return "Codice fiscale: " + codiceFiscale + "Età: " + eta + "Reparto: " + reparto;
    }
    @Override
    public int compareTo(Paziente obj){
        return this.codiceFiscale.compareTo(obj.getCodiceFiscale());
    }
}
