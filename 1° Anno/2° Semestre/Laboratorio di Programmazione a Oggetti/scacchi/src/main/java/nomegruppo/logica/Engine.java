package nomegruppo.logica;

import nomegruppo.datamodel.Partita;
import nomegruppo.datamodel.giocatori.Computer;
import nomegruppo.logica.giocatori.ComputerService;
import nomegruppo.logica.giocatori.UtenteService;

public class Engine {

    public static Partita avvia(Partita partita){
        boolean partitaFinita = true;
        IGiocatoreService engineg1, engineg2;

        engineg1 = new UtenteService();
        if(partita.getG2() instanceof Computer)
            engineg2 = new ComputerService();
        else
            engineg2 = new UtenteService();

        while(partitaFinita){
            
            //Tocca al giocatore 1
            if(partita.getTurno() % 2 == 1){

                engineg1.turno(partita, partita.getG1());

            }

            //Tocca al giocatore 2
            else{

                engineg2.turno(partita, partita.getG2());

            }
            partita.setTurno(partita.getTurno()+1);
        }
        
        return partita;
        
    }

}
