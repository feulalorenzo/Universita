import java.util.*;

public class UndirectedNetwork<Vertex extends Comparable<? super Vertex>> extends Network<Vertex>
{

    /**
     *  Initializes this UndirectedNetwork object to be empty, with the ordering of
     *  vertices by an implementation of the Comparable interface.
     */
    public UndirectedNetwork()
    {        
        super(); 
    } // default constructor

       
    /**
     *  Initializes this UndirectedNetwork object to a shallow copy of a specified UndirectedNetwork
     *  object.    
     *
     *  @param network - the UndirectedNetwork object that this UndirectedNetwork object is
     *                   initialized to a shallow copy of.
     * 
     *  @throws NullPointerException if network is null.
     *
     */
    public UndirectedNetwork (UndirectedNetwork<Vertex> network)
    {
        super (network); 
    } // copy constructor

    /**
     *  Determines if this UndirectedNetwork object is equal to a given object. 
     * 
     *  @param obj - the object this UndirectedNetwork object is compared to.
     *
     *  @return true - if this UndirectedNetwork object is equal to obj.
     *
     */
    public boolean equals (Object obj)
    {
        if (!(obj instanceof UndirectedNetwork))
            return false;
        UndirectedNetwork<?> other = (UndirectedNetwork<?>)obj;
        
        return adjacencyMap.equals (other.adjacencyMap);
    } // method equals
                
    /**
     *  Ensures that a given edge with a given weight is in this UndirectedNetwork 
     *  object.  
     *
     *  @param v1 – the first vertex of the edge.
     *  @param v2 -  the second vertex of the edge (the neighbor of v1).
     *  @param weight – the weight of the edge (v1, v2).
     *
     *  @return true – if this UndirectedNetwork object changed as a result of this call.
     *
     */ 
    public boolean addEdge (Vertex v1, Vertex v2, Double weight) 
    {
        return super.addEdge (v1, v2, weight) && super.addEdge (v2, v1, weight);
    } // method addEdge 
    
    /**
     *  Ensures that an edge specified by two vertices is absent from this UndirectedNetwork
     *  object.
     *  The averageTime (V, E) is O (log V).
     *
     *  @param v1 -   the beginning Vertex object of the edge whose absence is
     *                          ensured.
     *  @param v2 - the ending Vertex object of the edge whose absence is
     *                        ensured.
     *
     *  @return true - if the edge <v1, v2> was removed from this UndirectedNetwork object
     *                          by this call; return false if the edge <v1, v2> was not in this
     *                          UndirectedNetwork object when this call was made.
     * 
     *  @throws NullPointerException if v1 and/or v2 is null.
     *
     */
    public boolean removeEdge (Vertex v1, Vertex v2)
    {
        return super.removeEdge (v1, v2) && super.removeEdge (v2, v1);
    } // method removeEdge       
    
    
    /**** EX: verifica connessione grafo non orientato ****/
    
    public boolean isConnected()
    {
        Vertex v = adjacencyMap.firstKey();

            // Count the vertices reachable from v.
            Iterator<Vertex> itr2 = new BreadthFirstIterator (v);
            int count = 0;
            while (itr2.hasNext())
            {
                itr2.next();
                count++;
            } // while
            if (count < adjacencyMap.size())
                return false;
            else return true;
    } // method isConnected
    
} // class UndirectedNetwork