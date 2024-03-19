package nomegruppo.datamodel.pedine;

import nomegruppo.datamodel.Colore;
import nomegruppo.datamodel.Pedina;
import nomegruppo.datamodel.Posizione;
import nomegruppo.logica.pedine.CavalloService;

public class Cavallo extends Pedina{
    public Cavallo(Colore colore, String nome, Posizione p){
        super(colore, nome, p);
        this.setMovimenti(new CavalloService<Cavallo>());
        this.setValore(6);
    }
}
