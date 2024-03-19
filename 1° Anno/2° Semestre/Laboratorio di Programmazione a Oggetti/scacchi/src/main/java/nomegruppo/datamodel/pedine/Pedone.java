package nomegruppo.datamodel.pedine;

import nomegruppo.datamodel.Colore;
import nomegruppo.datamodel.Pedina;
import nomegruppo.datamodel.Posizione;
import nomegruppo.logica.pedine.PedoneService;


public class Pedone extends Pedina{

    private boolean mosso;

    public Pedone(Colore colore, String nome, Posizione p){
        super(colore, nome, p);
        this.setMovimenti(new PedoneService<Pedone>());
        this.setValore(2);
        this.mosso = false;
    }

    public boolean getMosso(){
        return this.mosso;
    }
    public void setMosso(boolean m){
        this.mosso = m;
    }
}
