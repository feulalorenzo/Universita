package nomegruppo.logica;

import nomegruppo.datamodel.Pedina;
import nomegruppo.datamodel.Scacchiera;

public interface IPedinaService<T extends Pedina>{

    public void movimentiDisponibili(Scacchiera s, T p);

}
