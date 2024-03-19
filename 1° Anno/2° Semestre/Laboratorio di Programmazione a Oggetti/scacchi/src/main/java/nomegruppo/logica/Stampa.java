package nomegruppo.logica;

import java.util.List;

import nomegruppo.datamodel.Colore;
import nomegruppo.datamodel.Giocatore;
import nomegruppo.datamodel.Mossa;
import nomegruppo.datamodel.Partita;
import nomegruppo.datamodel.Posizione;
import nomegruppo.datamodel.Scacchiera;

public class Stampa {
    //Il seguente metodo serve soltanto a stampare la situazione attuale della scacchiera
    public static void stampaScacchiera(Scacchiera scacchiera){
        for(int i=1; i<9; i++){
            for(char j='a'; j<'i'; j++){
                try {
                    if(scacchiera.getScacchiera().get(new Posizione(i, j)).getColore().equals(Colore.BIANCO))
                        System.out.printf("| b_" + scacchiera.getScacchiera().get(new Posizione(i, j)).getNome() + " |");
                    else
                        System.out.printf("| n_" + scacchiera.getScacchiera().get(new Posizione(i, j)).getNome() + " |");
                } catch (NullPointerException e) {
                    System.out.printf("|      |");
                }
                
            }
            System.out.println();
        }       
    }

    //Stampa le partite disponibili nel file di salvataggio
    public static void partiteDisponibili(List<Partita> partite){
        int cont = 1;
        for(Partita p : partite){
            System.out.println("------------------");
            System.out.println("Partita " + cont);
            System.out.println("G1: " + p.getG1().getNome());
            System.out.println("G2: " + p.getG2().getNome());
            System.out.println("Numero di turni: "+p.getTurno());
            System.out.println("------------------");
            cont++;
        }
    }

    //Stampa i criteri di ordinamento delle partite
    public static void opzioniOrdinamento(){
        System.out.println("In base a cosa vuoi ordinare?");
        System.out.println("1 - Numero di turni");
        System.out.println("2 - Pezzi complessivi rimasti");
        System.out.println("3 - Valore complessivo dei pezzi rimasti");
    }

    //Stampa le opzioni disponibili all'inizio del turno
    public static void opzioniTurno() {
        System.out.println("Cosa vuoi fare?");
        System.out.println("1 - Muovi un pezzo");
        System.out.println("2 - Torna indietro fino a 5 mosse");
        System.out.println("3 - Salva ed esci");
        System.out.println("4 - Resa (non farlo puoi vincere!)");
    }

    //Stampa le pedine di un giocatore
    public static void pedineDisponibili(Giocatore g){
        for(int i = 0; i < g.getPezziDisponibili().size(); i++){
            System.out.printf("| " + (i+1) + " - " + g.getPezziDisponibili().get(i).getNome() + " |");
            if(i == g.getPezziDisponibili().size() / 2)
                System.out.println();
        }
        System.out.println();
    }

    //Stampa la lista delle mosse disponibili
    public static void mosseDisponibili(List<Mossa> movimentiDisponibili) {
        for(Mossa m : movimentiDisponibili){
            System.out.println("1 - " + m.toString());
        }
    }
}