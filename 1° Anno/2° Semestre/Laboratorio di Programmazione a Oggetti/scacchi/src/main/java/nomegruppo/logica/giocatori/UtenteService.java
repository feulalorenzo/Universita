package nomegruppo.logica.giocatori;

import java.util.Scanner;

import nomegruppo.datamodel.Giocatore;
import nomegruppo.datamodel.Mossa;
import nomegruppo.datamodel.Partita;
import nomegruppo.datamodel.Pedina;
import nomegruppo.datamodel.Scacchiera;
import nomegruppo.logica.IGiocatoreService;
import nomegruppo.logica.ImpMuovereException;
import nomegruppo.logica.Stampa;

public class UtenteService implements IGiocatoreService {

    public void turno(Partita p, Giocatore g){

        Stampa.opzioniTurno();

        boolean continua = true;
        Scanner tastiera = new Scanner(System.in);
        int scelta = tastiera.nextInt();
        //Il while continua fin quando l'utente non sceglie un'operazione valida nelle varie opzioni del turno
        while(continua){
            switch (scelta) {
                case 1:
                    try {

                        muoviPezzo(p.getScacchiera(), g, pezzoDaMuovere(g), p.trovaAvversario(g));
                        
                        continua = false;

                    }catch (ImpMuovereException e) {
                        System.out.println("La pedina non può muoversi");
                    }
                    
                    break;
                case 2:

                    continua = false;
                    break;
                case 3:

                    continua = false;
                    break;
                case 4:

                    continua = false;
                    break;
                default:
                    System.out.println("Opzione non valida");
                    break;
            }
        }

        tastiera.close();
    }

    public Pedina pezzoDaMuovere(Giocatore g) {
        //Scelta pezzo
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Quale pezzo vuoi muovere?");
        Stampa.pedineDisponibili(g);
        int scelta = tastiera.nextInt();
        tastiera.nextLine();
        //Controllo sulla scelta (nel caso in cui non sia valida si reinserisce)
        boolean sceltaValida = false;
        while(!sceltaValida){
            if(scelta<1 || scelta > g.getPezziDisponibili().size()){
                System.out.println("Numero non valido, reinserisci:");
                scelta = tastiera.nextInt();
                tastiera.nextLine();
            }
            else
                sceltaValida = true;
        }

        tastiera.close();
        return g.getPezziDisponibili().get(scelta - 1);
        
    }
    
    public void muoviPezzo(Scacchiera s, Giocatore g, Pedina p, Giocatore avv) throws ImpMuovereException {

        p.setMosseDisponibili(p.getMovimenti().movimentiDisponibili(s, p));
        if(p.getMosseDisponibili().size() == 0)
            throw new ImpMuovereException();
        
        System.out.println("Quale mossa vuoi effettuare?");
        Stampa.mosseDisponibili(p.getMosseDisponibili());
        Scanner tastiera = new Scanner(System.in);
        int scelta = tastiera.nextInt();
        tastiera.nextLine();
        Mossa mossaScelta = p.getMosseDisponibili().get(scelta);

        eseguiMossa(s, g, mossaScelta, avv);
        
        tastiera.close();
    }

}
