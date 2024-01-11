/* II parziale 18/01/2022  
 * Si assuma una classe GraphOfStrings con una sola variabile d'istanza
 * private Network<String> graph (non sviluppare il codice).
 * 
 * a) Si aggiunga alla classe GraphOfStrings un metodo costruttore
 * public GraphOfStrings (String [] V, int max)
 * che assegna a graph una nuova istanza di Network<String> tale che
 * - i vertici sono le stringhe contenute in V 
 * - esiste un arco orientato (u,v) etichettato con un intero casuale minore di max
 * (si usi la classe Random) se u!=v e u è più corta di v.
 * 
 * b)	Si aggiunga alla classe GraphOfStrings un metodo che calcola e restituisce il
 * peso medio degli archi del grafo. 
*/

import java.util.*; 

public class GraphOfStrings { 

    public Network<String> graph; 
    
/*
    public GraphOfStrings(String [] V, int max) { 
        graph = new Network<String>(); 
        Random r = new Random(); 
        
        for(String u : V) { 
            graph.addVertex(u); 
            for(String v : V){ 
                //if(u.compareTo(v) != 0) { 
                    if (u.length() < v.length()) {
                    	graph.addVertex(v); 
                        graph.addEdge(u, v, (double) r.nextInt(max+1)); 
                    }
                //} 
            } 
        } 
    } // end-method 
*/
    
/*
    class IncreasingLength implements Comparator<String> {
  	  public int compare(String a, String b) {
  		return a.length() - b.length();
  	  }
  	}
*/
    
    public GraphOfStrings(String [] V, int max) { 
        graph = new Network<String>();
        Random r = new Random(); 
        //Arrays.sort(V,new IncreasingLength());
        
        Arrays.sort(V,new Comparator<String>() {
        	public int compare(String a, String b) {
          		return a.length() - b.length();
          	}} );
        
        for(int i=0; i<V.length; i++) {
            graph.addVertex(V[i]);
            for(int j=i+1; j<V.length; j++)
                if((V[i]).length() != (V[j]).length()) {
                	graph.addVertex(V[j]);
                	graph.addEdge(V[i], V[j], (double) r.nextInt(max+1)); 
                }
         } 
    } 
    
    

    public double meanEdgeWeight() { 

        double mean = 0.0; 
        int edgeSize = graph.edgeSize();
        if (edgeSize == 0) return mean;

        for(String u : graph) { 
            for(String v : graph.neighbors(u)) {
            	Double w = graph.getEdgeWeight(u, v);            
                mean += ( w == null ? 0 : w);
            } 
        } 
        return mean / graph.edgeSize(); 
    } 

} 