package nomegruppo.logica.giocatori;

import java.util.Random;

import nomegruppo.datamodel.Giocatore;
import nomegruppo.datamodel.Partita;
import nomegruppo.datamodel.Pedina;
import nomegruppo.datamodel.Scacchiera;
import nomegruppo.logica.IGiocatoreService;
import nomegruppo.logica.ImpMuovereException;

public class ComputerService implements IGiocatoreService{

    public void turno(Partita p, Giocatore g){
        Random random = new Random();
        int rn = random.nextInt(g.getPezziDisponibili().size());

        boolean continua = true;
        while(continua){
            try {
                muoviPezzo(p.getScacchiera(), g, g.getPezziDisponibili().get(rn), p.trovaAvversario(g) );
                continua = false;
            } catch (ImpMuovereException e) {
                
            }
        }
    }

    public Pedina pezzoDaMuovere(Giocatore g){
        Random random = new Random();
        int rn = random.nextInt(g.getPezziDisponibili().size());
        return g.getPezziDisponibili().get(rn);
    }
//TODO:
    public void muoviPezzo(Scacchiera s, Giocatore g, Pedina p, Giocatore avv) throws ImpMuovereException {
        
    }
}
