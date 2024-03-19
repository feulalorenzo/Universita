package nomegruppo.datamodel;

import lombok.Data;

public @Data class Mossa {

    Pedina pedina;
    Posizione partenza;
    Posizione arrivo;
    
    public Mossa(Pedina p, Posizione ar){
        this.pedina = p;
        this.partenza = p.getPosizione();
        this.arrivo = ar;
    }

    public String toString(){
        return "metti " + pedina.getNome() + " da " + partenza.getRiga() + partenza.getColonna() + " a " + arrivo.getRiga() + arrivo.getColonna();
    }

}
