package nomegruppo.datamodel.pedine;

import nomegruppo.datamodel.Colore;
import nomegruppo.datamodel.Pedina;
import nomegruppo.datamodel.Posizione;
import nomegruppo.logica.pedine.TorreService;

public class Torre extends Pedina{
    public Torre(Colore colore, String nome, Posizione p){
        super(colore, nome, p);
        this.setMovimenti(new TorreService<Torre>());
        this.setValore(5);
    }
}
