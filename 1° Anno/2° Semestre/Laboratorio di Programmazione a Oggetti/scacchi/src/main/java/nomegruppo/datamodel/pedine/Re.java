package nomegruppo.datamodel.pedine;

import nomegruppo.datamodel.Colore;
import nomegruppo.datamodel.Pedina;
import nomegruppo.datamodel.Posizione;
import nomegruppo.logica.pedine.ReService;

public class Re extends Pedina{
    public Re(Colore colore, String nome, Posizione p){
        super(colore, nome, p);
        this.setMovimenti(new ReService<Re>());
        this.setValore(10);
    }
}
