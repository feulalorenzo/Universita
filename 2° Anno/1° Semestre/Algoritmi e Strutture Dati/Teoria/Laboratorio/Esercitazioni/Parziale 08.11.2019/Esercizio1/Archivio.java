package Esercizio1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Archivio {

    private List<Automobile> lista = new ArrayList<Automobile>();
    
    public Archivio(){

    }

    public void insert(String targa, Cliente cliente){
        Automobile a = new Automobile(targa, cliente);
        for(Automobile at : lista){
            if(a.equals(at)){
                at.setProprietario(cliente);
                return;
            }
        }
        lista.add(a);
    }
    
    public boolean deleteByTarga(String targa){
        Iterator<Automobile> iterator = lista.iterator();
        while(iterator.hasNext())
            if(iterator.next().getTarga().equals(targa)){
                iterator.remove();
                return true;
            }
        return false;
    }

    public Archivio nuovoArchivio(String citta){
        Archivio less = new Archivio();
        for(Automobile at : lista){
            if(at.getProprietario().getResidenza().equals(citta))
                less.insert(at.getTarga(),at.getProprietario());
        }
        return less;
    }

    public void SortByTarga(){
        Collections.sort(lista);
    }

    public void SortByCF(){
        Collections.sort(lista,new Comparator<Automobile>() {
            public int compare(Automobile a1, Automobile a2){
                return a1.getProprietario().compareTo(a2.getProprietario());
            }
        });
    }
    public void Stampa(){
        for(Automobile at : lista){
            System.out.println(at.toString());
        }
    }
}