public class Main {
    public static void main(String[] args) {
        Carta[] deck = new Carta[5];
        for(int i = 0; i<deck.length; i++){
            if(i%2 == 0)
                deck[i] = new Personaggio();
            else    
                deck[i] = new Spells();
        }
    }
}
