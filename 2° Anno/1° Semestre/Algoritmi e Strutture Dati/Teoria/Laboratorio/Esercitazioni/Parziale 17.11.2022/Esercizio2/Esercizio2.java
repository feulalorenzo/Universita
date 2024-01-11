package Esercizio2;

import java.util.ArrayList;
import java.util.Collections;

public class Esercizio2 {
    /*
    //Prima versione
    public static ArrayList<String> differenzaSimmetrica(ArrayList<String> lista1, ArrayList<String> lista2){
        ArrayList<String> lista = new ArrayList<String>();
        for(String s : lista1){
            lista.add(s);
        }
        for(String s : lista2){
            lista.add(s);
        }
        Collections.sort(lista);
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).equals(lista.get(i+i))){
                lista.remove(lista.get(i));
                lista.remove(lista.get(i+1));
                i--;
            }
        }
        return lista;
    }
    */
    
    //Seconda versione (metodo generico)
    public static <T extends Comparable<? super T>> ArrayList<T> differenzaSimmetrica(ArrayList<T> lista1, ArrayList<T> lista2){

        ArrayList<T> lista = new ArrayList<T>();
        for(T s : lista1){
            lista.add(s);
        }
        for(T s : lista2){
            lista.add(s);
        }
        Collections.sort(lista);
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).equals(lista.get(i+i))){
                lista.remove(lista.get(i));
                lista.remove(lista.get(i+1));
                i--;
            }
        }
        return lista;
    }
}
