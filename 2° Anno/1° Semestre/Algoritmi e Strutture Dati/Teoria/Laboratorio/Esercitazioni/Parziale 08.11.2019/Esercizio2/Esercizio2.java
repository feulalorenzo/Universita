package Esercizio2;

public class Esercizio2 {
    public static <T> void riordina(T[] array){
        T temp;
        for(int i = 0; i < array.length/2; i++){
            temp = array[i];
            array[i] = array[array.length - i];
            array[array.length - i] = temp;
        }
    } 
}
