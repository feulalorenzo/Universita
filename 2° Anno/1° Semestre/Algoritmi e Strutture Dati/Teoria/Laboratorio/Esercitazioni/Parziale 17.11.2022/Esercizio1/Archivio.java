package Esercizio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Archivio{

    List<Paziente> lista = new ArrayList<Paziente>();

    public Archivio(){

    }

    public boolean insert(String cf, int e, int r){
        Paziente p = new Paziente(cf, e, r);
        for(Paziente pa : lista){
            if(p.equals(pa))
                return false;
        }
        lista.add(p);
        return true;
    }

    public void deleteByCf(String cf){
        Iterator<Paziente> it = lista.iterator();
        while(it.hasNext()){
            if(it.next().getCodiceFiscale().equals(cf)){
                it.remove();
                return;
            }
        }
    }

    public Archivio selByRepart(int r){
        Archivio ret = new Archivio();

        for(Paziente pa : lista){
            if(pa.getReparto() == r){
                ret.insert(pa.getCodiceFiscale(), pa.getEta(), pa.getReparto());
            }
        }
        return ret;
    }

    public void sortByCf(){
        Collections.sort(lista);
    }

    public void sortByEta(){
        Collections.sort(lista,new Comparator<Paziente>() {
            @Override
            public int compare(Paziente p1, Paziente p2){
                if(p1.getEta() > p2.getEta())
                    return 1;
                if(p1.getEta() == p2.getEta())
                    return 0;
                return -1;
            }
        });
    }

    public int[] numeroPazienti(){
        int[] array = new int[10];

        for(Paziente pa : lista){
            array[pa.getReparto()-1]++;
        }
        return array;
    }
}
