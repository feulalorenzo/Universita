package nomegruppo.datamodel.pedine;

import nomegruppo.datamodel.Colore;
import nomegruppo.datamodel.Pedina;
import nomegruppo.datamodel.Posizione;
import nomegruppo.logica.pedine.AlfiereService;

public class Alfiere extends Pedina{
    public Alfiere(Colore colore, String nome, Posizione p){
        super(colore,nome, p);
        this.setMovimenti(new AlfiereService<Alfiere>());
        this.setValore(7);
    }
}
