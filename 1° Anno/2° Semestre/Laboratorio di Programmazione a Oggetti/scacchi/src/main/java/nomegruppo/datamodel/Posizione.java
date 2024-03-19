package nomegruppo.datamodel;

import lombok.Data;
//La classe è utilizzata soltanto per mappare una posizione ad una pedina all'interno della scacchiera
public @Data class Posizione {
    
    private int riga;
    private char colonna;

    public Posizione(int i, char c){
        riga = i;
        colonna = c;
    }

    
}
