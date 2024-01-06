package Esercizio1;
class Automobile implements Comparable<Automobile>{
    
    private String targa;
    private Cliente proprietario;

    public Automobile(String targa, Cliente proprietario) {
        this.targa = targa;
        this.proprietario = proprietario;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Automobile))
            return false;
        Automobile a = (Automobile) obj;
        return this.targa.equals(a.getTarga()) && this.proprietario.equals(a.getProprietario());
    }

    public String toString(){
        return "Targa: " + targa + "; Proprietario: " + proprietario;
    }

    public int compareTo(Automobile a){
        return targa.compareTo(a.getTarga());
    }
}
