package nomegruppo.datamodel;

import java.util.List;

import lombok.Data;
import nomegruppo.logica.IPedinaService;

@SuppressWarnings("rawtypes")
public abstract @Data class Pedina {
    
    private int valore;
    private Posizione posizione;
    private IPedinaService movimenti;

    private Colore colore;
    //Il nome sarà utile per la stampa su schermo
    private final String nome;
    //Lista mosse disponibili per ogni pezzo
    private List<Mossa> mosseDisponibili;
    
    public Pedina ( Colore colore , String nome, Posizione p){
        this.colore = colore;
        this.nome = nome;
        this.posizione = p;
    }

}
