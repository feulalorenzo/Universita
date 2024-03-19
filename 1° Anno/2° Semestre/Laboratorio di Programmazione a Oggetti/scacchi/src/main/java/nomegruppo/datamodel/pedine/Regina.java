package nomegruppo.datamodel.pedine;

import nomegruppo.datamodel.Colore;
import nomegruppo.datamodel.Pedina;
import nomegruppo.datamodel.Posizione;
import nomegruppo.logica.pedine.ReginaService;

public class Regina extends Pedina{
    public Regina(Colore colore, String nome, Posizione p){
        super(colore, nome, p);
        this.setMovimenti(new ReginaService<Regina>());
        this.setValore(8);
    }
}
