package nomegruppo.logica;

import nomegruppo.datamodel.Giocatore;
import nomegruppo.datamodel.Mossa;
import nomegruppo.datamodel.Partita;
import nomegruppo.datamodel.Pedina;
import nomegruppo.datamodel.Scacchiera;

public interface IGiocatoreService {
    
    //Giocatore g, muove la pedina p sulla scacchiera s. Possibilità di mangiare una pedina del giocatore avv
    public void muoviPezzo(Scacchiera s, Giocatore g, Pedina p, Giocatore avv) throws ImpMuovereException;
    
    public void turno(Partita p, Giocatore g);

    //Scelta del pezzo da muovere da parte di un giocatore
    public Pedina pezzoDaMuovere(Giocatore g);

    //Giocatore g esegue la mossa m, modificando la scacchiera s ed eventualmente i pezziDisponibili dell'avversario avv
    default public void eseguiMossa(Scacchiera s, Giocatore g, Mossa m, Giocatore avv) {
        //Rimuove il pezzo dalla vecchia posizione
        s.getScacchiera().remove(m.getPartenza(), m.getPedina());
        //Se la casella di arrivo è vuota, il pezzo si sposta semplicemente, altrimenti oltre a spostarlo si elimina il pezzo mangiato dalla lista dei pezzi disponibili dell'avversario
        if(s.getScacchiera().get(m.getArrivo()) == null)
            s.getScacchiera().put(m.getArrivo(), m.getPedina());
        else{
            avv.getPezziDisponibili().remove(s.getScacchiera().get(m.getArrivo()));
            s.getScacchiera().replace(m.getArrivo(), m.getPedina());
        }
        //Setto la nuova posizione della pedina a quella di arrivo
        m.getPedina().setPosizione(m.getArrivo());
    }
}