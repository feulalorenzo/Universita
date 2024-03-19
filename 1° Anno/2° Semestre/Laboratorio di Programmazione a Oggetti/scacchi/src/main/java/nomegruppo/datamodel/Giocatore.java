package nomegruppo.datamodel;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;
import nomegruppo.datamodel.pedine.*;

public abstract @Data class Giocatore {

    String nome;
    List<Pedina> pezziDisponibili = new ArrayList<Pedina>();
    Colore colore;

    public Giocatore(String nome, String colore){
        if(colore.equals("BIANCO")){
            this.colore = Colore.BIANCO;
            pezziDisponibili.add(new Pedone(this.colore, "p1", new Posizione(2, 'a')));
            pezziDisponibili.add(new Pedone(this.colore, "p2", new Posizione(2, 'b')));
            pezziDisponibili.add(new Pedone(this.colore, "p3", new Posizione(2, 'c')));
            pezziDisponibili.add(new Pedone(this.colore, "p4", new Posizione(2, 'd')));
            pezziDisponibili.add(new Pedone(this.colore, "p5", new Posizione(2, 'e')));
            pezziDisponibili.add(new Pedone(this.colore, "p6", new Posizione(2, 'f')));
            pezziDisponibili.add(new Pedone(this.colore, "p7", new Posizione(2, 'g')));
            pezziDisponibili.add(new Pedone(this.colore, "p8", new Posizione(2, 'h')));
            pezziDisponibili.add(new Torre(this.colore, "t1", new Posizione(1, 'a')));
            pezziDisponibili.add(new Cavallo(this.colore, "c1", new Posizione(1, 'b')));
            pezziDisponibili.add(new Alfiere(this.colore, "a1", new Posizione(1, 'c')));
            pezziDisponibili.add(new Regina(this.colore, "rg", new Posizione(1, 'd')));
            pezziDisponibili.add(new Re(this.colore, "re", new Posizione(1, 'e')));
            pezziDisponibili.add(new Alfiere(this.colore, "a2", new Posizione(1, 'f')));
            pezziDisponibili.add(new Cavallo(this.colore, "c2", new Posizione(1, 'g')));
            pezziDisponibili.add(new Torre(this.colore, "t2", new Posizione(1, 'h')));
        }
        else{
            this.colore = Colore.NERO;
            pezziDisponibili.add(new Pedone(this.colore, "p1", new Posizione(7, 'a')));
            pezziDisponibili.add(new Pedone(this.colore, "p2", new Posizione(7, 'b')));
            pezziDisponibili.add(new Pedone(this.colore, "p3", new Posizione(7, 'c')));
            pezziDisponibili.add(new Pedone(this.colore, "p4", new Posizione(7, 'd')));
            pezziDisponibili.add(new Pedone(this.colore, "p5", new Posizione(7, 'e')));
            pezziDisponibili.add(new Pedone(this.colore, "p6", new Posizione(7, 'f')));
            pezziDisponibili.add(new Pedone(this.colore, "p7", new Posizione(7, 'g')));
            pezziDisponibili.add(new Pedone(this.colore, "p8", new Posizione(7, 'h')));
            pezziDisponibili.add(new Torre(this.colore, "t1", new Posizione(8, 'a')));
            pezziDisponibili.add(new Cavallo(this.colore, "c1", new Posizione(8, 'b')));
            pezziDisponibili.add(new Alfiere(this.colore, "a1", new Posizione(8, 'c')));
            pezziDisponibili.add(new Regina(this.colore, "rg", new Posizione(8, 'd')));
            pezziDisponibili.add(new Re(this.colore, "re", new Posizione(8, 'e')));
            pezziDisponibili.add(new Alfiere(this.colore, "a2", new Posizione(8, 'f')));
            pezziDisponibili.add(new Cavallo(this.colore, "c2", new Posizione(8, 'g')));
            pezziDisponibili.add(new Torre(this.colore, "t2", new Posizione(8, 'h')));
        }
        this.nome = nome;
        
    }
}
