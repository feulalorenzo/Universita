package nomegruppo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import lombok.Data;
import nomegruppo.datamodel.Partita;
import nomegruppo.datamodel.giocatori.Computer;
import nomegruppo.datamodel.giocatori.Utente;
import nomegruppo.logica.Engine;
import nomegruppo.logica.Stampa;

@SuppressWarnings("unchecked")
public abstract @Data class Menu {

    public static void avvia(){

        Scanner tastiera = new Scanner(System.in);
        int s;
        int scelta;
        boolean continua = true;
        String nomeg1, nomeg2;
        String risposta;
        Partita partita;
        List<Partita> listaPartite = new ArrayList<Partita>();
        try{
            ObjectInputStream oss = new ObjectInputStream(new FileInputStream("src/main/resources/partitesalvate.ser"));
            listaPartite.addAll((List<Partita>) oss.readObject());
            oss.close();
        }
        catch(Exception e){
            System.out.println("Impossibile caricare le partite salvate");
        }

        while(continua){
            //Scelta menu
            System.out.println("Cosa vuoi fare?");
            System.out.println("1 - Giocatore contro Giocatore");
            System.out.println("2 - Giocatore contro Computer");
            System.out.println("3 - Carica partita salvata");
            System.out.println("4 - Ordina le partite");
            System.out.println("5 - Esci");
            s = tastiera.nextInt();
            tastiera.nextLine();
            switch (s) {
                case 1:
                    System.out.println("Inserisci il nome del primo giocatore: ");
                    nomeg1 = tastiera.nextLine();
                    System.out.println("Inserisci il nome del giocatore due:");
                    nomeg2 = tastiera.nextLine();
                    partita = Engine.avvia(new Partita(new Utente(nomeg1,"BIANCO"), new Utente(nomeg2,"NERO")));
                    listaPartite.add(partita);
                    
                    break;
                case 2:
                    System.out.println("Inserisci il nome del giocatore: ");
                    nomeg1 = tastiera.nextLine();
                    partita = Engine.avvia(new Partita(new Utente(nomeg1, "BIANCO"), new Computer("NERO")));
                    listaPartite.add(partita);
                    break;
                case 3:
                    System.out.println("Quale vuoi caricare?");
                    Stampa.partiteDisponibili(listaPartite);
                    scelta = tastiera.nextInt();
                    tastiera.nextLine();
                    partita = Engine.avvia(listaPartite.get(scelta - 1));
                    listaPartite.add(partita);
                    break;
                case 4:
                    Stampa.opzioniOrdinamento();
                    scelta = tastiera.nextInt();
                    tastiera.nextLine();
                    switch (scelta) {
                        case 1:
                            listaPartite.sort(new Comparator<Partita>() {
                                public int compare(Partita p1, Partita p2){
                                    if(p1.getTurno() > p2.getTurno())
                                        return 1;
                                    if(p1.getTurno() < p2.getTurno())
                                        return -1;
                                    return 0;
                                }
                            });
                            break;
                        case 2:
                            listaPartite.sort(new Comparator<Partita>() {
                                public int compare(Partita p1, Partita p2){
                                    int numPezzi1 = p1.getG1().getPezziDisponibili().size() + p1.getG2().getPezziDisponibili().size();
                                    int numPezzi2 = p2.getG1().getPezziDisponibili().size() + p2.getG2().getPezziDisponibili().size();
                                    if( numPezzi1 > numPezzi2 )
                                        return 1;
                                    if( numPezzi1 < numPezzi2 )
                                        return -1;
                                    return 0;
                                }
                            });
                            break;
                        case 3:
                            listaPartite.sort(new Comparator<Partita>() {
                                public int compare(Partita p1, Partita p2){
                                    int valPezzi1 = p1.getScacchiera().valorePezzi();
                                    int valPezzi2 = p2.getScacchiera().valorePezzi();
                                    if( valPezzi1 > valPezzi2 )
                                        return 1;
                                    if( valPezzi1 < valPezzi2 )
                                        return -1;
                                    return 0;
                                }
                            });
                            break;
                        default:
                            System.out.println("Ordinamento non valido");
                            break;
                    }
                    break;
                case 5:
                    continua = false;
                    System.out.println("Arrivederci! O/");
                    break;
                default:
                    System.out.println("Opzione non valida");
                    break; 
            }
            System.out.println("Continuare a giocare?");
            risposta = tastiera.nextLine();
            if(!risposta.equalsIgnoreCase("si"))
                continua = false;
        }
        
        tastiera.close();
    }

}
