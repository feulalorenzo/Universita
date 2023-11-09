package Esercizio1;
public class Cliente implements Comparable<Cliente>{
    private String nominativo;
    private String codiceFiscale;
    private String residenza;
    
    Cliente(String nominativo, String codiceFiscale, String residenza){
        this.nominativo = nominativo;
        this.codiceFiscale = codiceFiscale;
        this.residenza = residenza;
    }
    
    Cliente(String codiceFiscale){
        this.nominativo = "Unknown";
        this.codiceFiscale = codiceFiscale;
        this.residenza = "Unknown";
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Cliente))
            return false;
        Cliente c = (Cliente) obj;
        return nominativo.equals(c.getNominativo()) && codiceFiscale.equals(c.getCodiceFiscale()) && residenza.equals(c.getResidenza());
    }

    @Override
    public String toString(){
        return "Nominativo: " + nominativo + "Codice Fiscale: " + codiceFiscale + "Residenza: " + residenza;
    }

    @Override
    public int compareTo(Cliente obj){
        return this.codiceFiscale.compareTo(obj.getCodiceFiscale());
    }
}