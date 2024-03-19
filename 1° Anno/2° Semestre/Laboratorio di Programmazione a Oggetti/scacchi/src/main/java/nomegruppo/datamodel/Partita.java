package nomegruppo.datamodel;

import lombok.Data;

public @Data class Partita {

    private Giocatore g1;
    private Giocatore g2;
    private Scacchiera scacchiera;
    private int turno;

    public Partita ( Giocatore g1, Giocatore g2 ){
        this.g1 = g1;
        this.g2 = g2;
        this.scacchiera = new Scacchiera(g1,g2);
        turno = 1;
    }

    public Giocatore trovaAvversario(Giocatore g){
        if(g.equals(this.g1))
            return this.g2;
        return this.g1;
    }

}
