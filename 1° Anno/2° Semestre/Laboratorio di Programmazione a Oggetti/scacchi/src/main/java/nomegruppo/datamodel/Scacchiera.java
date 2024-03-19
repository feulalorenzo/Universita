package nomegruppo.datamodel;

import java.util.HashMap;

import lombok.Data;

public @Data class Scacchiera {

    private HashMap<Posizione,Pedina> scacchiera = new HashMap<>();

    /** Crea una scacchiera con pezzi disposti secondo il regolamento */
    public Scacchiera(Giocatore g1, Giocatore g2){
        //Pedoni g1
        scacchiera.put(new Posizione(2, 'a') , g1.pezziDisponibili.get(0));
        scacchiera.put(new Posizione(2, 'b') , g1.pezziDisponibili.get(1));
        scacchiera.put(new Posizione(2, 'c') , g1.pezziDisponibili.get(2));
        scacchiera.put(new Posizione(2, 'd') , g1.pezziDisponibili.get(3));
        scacchiera.put(new Posizione(2, 'e') , g1.pezziDisponibili.get(4));
        scacchiera.put(new Posizione(2, 'f') , g1.pezziDisponibili.get(5));
        scacchiera.put(new Posizione(2, 'g') , g1.pezziDisponibili.get(6));
        scacchiera.put(new Posizione(2, 'h') , g1.pezziDisponibili.get(7));
        //Altre pedine g1
        scacchiera.put(new Posizione(1, 'a') , g1.pezziDisponibili.get(8));
        scacchiera.put(new Posizione(1, 'b') , g1.pezziDisponibili.get(9));
        scacchiera.put(new Posizione(1, 'c') , g1.pezziDisponibili.get(10));
        scacchiera.put(new Posizione(1, 'd') , g1.pezziDisponibili.get(11));
        scacchiera.put(new Posizione(1, 'e') , g1.pezziDisponibili.get(12));
        scacchiera.put(new Posizione(1, 'f') , g1.pezziDisponibili.get(13));
        scacchiera.put(new Posizione(1, 'g') , g1.pezziDisponibili.get(14));
        scacchiera.put(new Posizione(1, 'h') , g1.pezziDisponibili.get(15));
        //Pedoni g2
        scacchiera.put(new Posizione(7, 'a') , g2.pezziDisponibili.get(0));
        scacchiera.put(new Posizione(7, 'b') , g2.pezziDisponibili.get(1));
        scacchiera.put(new Posizione(7, 'c') , g2.pezziDisponibili.get(2));
        scacchiera.put(new Posizione(7, 'd') , g2.pezziDisponibili.get(3));
        scacchiera.put(new Posizione(7, 'e') , g2.pezziDisponibili.get(4));
        scacchiera.put(new Posizione(7, 'f') , g2.pezziDisponibili.get(5));
        scacchiera.put(new Posizione(7, 'g') , g2.pezziDisponibili.get(6));
        scacchiera.put(new Posizione(7, 'h') , g2.pezziDisponibili.get(7));
        //Altre pedine g2
        scacchiera.put(new Posizione(8, 'a') , g2.pezziDisponibili.get(8));
        scacchiera.put(new Posizione(8, 'b') , g2.pezziDisponibili.get(9));
        scacchiera.put(new Posizione(8, 'c') , g2.pezziDisponibili.get(10));
        scacchiera.put(new Posizione(8, 'd') , g2.pezziDisponibili.get(11));
        scacchiera.put(new Posizione(8, 'e') , g2.pezziDisponibili.get(12));
        scacchiera.put(new Posizione(8, 'f') , g2.pezziDisponibili.get(13));
        scacchiera.put(new Posizione(8, 'g') , g2.pezziDisponibili.get(14));
        scacchiera.put(new Posizione(8, 'h') , g2.pezziDisponibili.get(15));
    }

    public int valorePezzi(){
        int valore = 0;
        for(Pedina p : scacchiera.values()){
            valore += p.getValore();
        }
        return valore;
    }
    
}