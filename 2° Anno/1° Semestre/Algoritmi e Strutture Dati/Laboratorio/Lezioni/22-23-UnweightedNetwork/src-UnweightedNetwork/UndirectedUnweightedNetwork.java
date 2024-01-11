
public class UndirectedUnweightedNetwork<Vertex> extends UnweightedNetwork<Vertex>{
    @Override
    public boolean equals (Object obj)
    {
        if ((obj == null) || !(obj instanceof UndirectedUnweightedNetwork<?>))
            return false;
        UndirectedUnweightedNetwork<?> other = (UndirectedUnweightedNetwork<?>)obj;
        return adjacencyMap.equals (other.adjacencyMap);
    }
    @Override
    public int edgeSize(){
        return super.edgeSize()/2;
    }
    @Override
    public boolean addEdge (Vertex v1, Vertex v2)
    {
        return super.addEdge(v1,v2) &&  super.addEdge(v2,v1);
    }

    public boolean removeEdge(Vertex v1, Vertex v2){
        return super.removeEdge(v1,v2) && super.removeEdge(v2,v1);
    }
    public boolean isConnected()
    {
            // Count the vertices reachable from v.
            Vertex v = adjacencyMap.firstKey();
            Iterator<Vertex> itr = new BreadthFirstIterator (v);
            int count = 0;
            while (itr.hasNext())
            {
                itr.next();
                count++;
            } // while
            if (count < adjacencyMap.size())
                return false;
            return true;
    } 
}
