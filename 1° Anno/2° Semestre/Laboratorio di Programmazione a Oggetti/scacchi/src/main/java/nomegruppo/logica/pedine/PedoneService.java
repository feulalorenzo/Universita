package nomegruppo.logica.pedine;

import java.util.ArrayList;
import java.util.List;

import nomegruppo.datamodel.Colore;
import nomegruppo.datamodel.Mossa;
import nomegruppo.datamodel.Posizione;
import nomegruppo.datamodel.Scacchiera;
import nomegruppo.datamodel.pedine.Pedone;
import nomegruppo.logica.IPedinaService;

public class PedoneService<T extends Pedone> implements IPedinaService<T> {

    //Aggiorna la lista dell'istanza di una pedina con tutte le mosse che può effettuare la pedina p sulla scacchiera s
    public void movimentiDisponibili(Scacchiera s, T p) {

        List<Mossa> movimentiDisponibili = new ArrayList<>();
        Posizione destra, sinistra, avanti, avanti2;
        Colore colore = p.getColore();
        int direzione;

        if(colore.equals("BIANCO"))
            direzione = 1;
        else
            direzione = -1;
        
        avanti = p.getPosizione();
        avanti.setRiga(p.getPosizione().getRiga() + direzione);
        if(s.getScacchiera().get(avanti) == null && avanti.getRiga()<9 && avanti.getRiga()>0){
            movimentiDisponibili.add(new Mossa(p, avanti));
        }

        

        if(avanti.getRiga()<9 && avanti.getRiga()>0){
            destra = avanti;
            destra.setColonna((char) (avanti.getColonna() + 1));
            if(destra != null && !(s.getScacchiera().get(destra).getColore().equals(colore)))
                movimentiDisponibili.add(new Mossa(p, destra));
            sinistra = avanti;
            sinistra.setColonna((char) (avanti.getColonna() - 1));
            if(sinistra != null && !(s.getScacchiera().get(sinistra).getColore().equals(colore)))
                movimentiDisponibili.add(new Mossa(p, sinistra));
        }
        
        //Se il pedone si è mosso può avanzare solo di una posizione o mangiare in obliquo
        if(! p.getMosso()){
            avanti2 = p.getPosizione();
            avanti2.setRiga(p.getPosizione().getRiga() + direzione + direzione);
            if(s.getScacchiera().get(avanti2) == null && avanti2.getRiga()<9 && avanti2.getRiga()>0)
                movimentiDisponibili.add(new Mossa(p, avanti2));
            p.setMosso(true);
        }

        p.setMosseDisponibili(movimentiDisponibili);
    
    }
}
