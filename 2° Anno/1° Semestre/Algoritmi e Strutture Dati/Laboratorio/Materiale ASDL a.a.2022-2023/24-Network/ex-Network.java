    /******************* ESERCITAZIONE II PARZIALE *****************/
    
    /**
     *  Add to the NetworkVertex> class a new method that determines if this (directed
     *  Network object is (strongly) connected. The worstTime(V, E) is O(V * V * log V).
     *
     *  @return true - if this (directed) Network object is connected.
     *
     */
    public boolean isConnected()
    {
    	for (Vertex v : adjacencyMap.keySet())
        {
            // Count the vertices reachable from v.
            Iterator<Vertex> itr = new BreadthFirstIterator (v);
            int count = 0;
            while (itr.hasNext())
            {
                itr.next();
                count++;
            } // while
            if (count < adjacencyMap.size())
                return false;
        } // for
        return true;
    } // method isConnected
    
    /*
     * Esercizio 4 del 10-02-2021 (II appello)
     * Aggiungere alla classe Network<Vertex extends Comparable<? super Vertex>>
     * un nuovo metodo public Double getNetWeight(); che restituisce il peso del grafo,
     * ovvero la somma dei pesi degli archi di questo grafo orientato.
     */
        
        public Double getNetWeight() {
        	Double weight =0.0;
        	for (Vertex v: adjacencyMap.keySet()) {
        		   for (Map.Entry<Vertex, Double> entry : adjacencyMap.get (v).entrySet())
        			   weight += entry.getValue();
        	}
        	return weight;
        }
        
 
    	/* EX2 del II parziale del 14/01/2020
         * Si aggiunga alla classe Network<Vertex> un nuovo metodo costruttore
         * public Network(Double[][] AdjMatrix, Vertex[] V)
         * che generi una network come nuova rappresentazione di un digrafo rappresentato
         * mediante la matrice di adiacenza AdjMatrix: AdjMatrix[i][j] = d != null
         * (per qualche Double d) sse nel digrafo esiste un arco da
         * V[i] a V[j] con peso d.
         */
        
        public Network(Double[][] AdjMatrix, Vertex[] V) {
        	adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
        	if (AdjMatrix.length != V.length) return; 
        	//inserimento vertici
        	for (int i=0; i < V.length; i++) 
        		adjacencyMap.put (V[i], new TreeMap<Vertex, Double>());   //addVertex(V[i]);
        	//inserimento archi
        	for (int i=0; i < AdjMatrix.length; i++) {
        		TreeMap<Vertex, Double> neighborMap = adjacencyMap.get (V[i]);       
        		for (int j=0; j < AdjMatrix[i].length; j++) {
        			if (AdjMatrix[i][j]!=null && j <= V.length) {
        				//addEdge(V[i],V[j],AdjMatrix[i][j]); 
        		        neighborMap.put (V[j], AdjMatrix[i][j]);
        			}
        		}
        	}
        	
        }

        /**
        * EX3 del 20.6.2017
        * Si aggiunga alla classe Network<Vertex> un metodo che verifichi se
        * tutti i vertici del grafo orientato corrente hanno lo stesso grado uscente.
        */

        public boolean SameOutdegree() {
        	if (adjacencyMap.isEmpty()) return true;
        	Vertex u = adjacencyMap.firstKey();
        	int out = adjacencyMap.get(u).size();    	
            for (Vertex v: adjacencyMap.keySet())	{
            		if (adjacencyMap.get(v).size() !=  out) return false; 	
            }
            return true;
        }
        
        /**
        * Si aggiunga alla classe Network<Vertex> un metodo che calcoli il grado entrante 
        * di tutti i vertici del grafo corrente.
        */

        public HashMap<Vertex, Integer> Indegree() {
        	HashMap<Vertex, Integer> indegreeMap= new HashMap<Vertex, Integer>();
        	TreeMap<Vertex, Double> neighborMap;
        	for (Vertex v: adjacencyMap.keySet()) indegreeMap.put(v, 0);
        	for (Vertex v: adjacencyMap.keySet()) {
            	neighborMap = adjacencyMap.get(v);
            	for (Vertex u: neighborMap.keySet()) indegreeMap.put(u, (indegreeMap.get(u))+1);
            	/* //for alternativo 
            	for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
            		Vertex u = entry.getKey();
            		indegreeMap.put(u, (indegreeMap.get(u))+1);
            	}
            	*/
        	}
        	return indegreeMap;
        }
            
            
            
        /** Esercizio 2 II parziale 10.01.2018
         * Si aggiunga alla classe Network<Vertex> un metodo che verifichi
         * se ogni nodo del grafo orientato corrente ha lo stesso numero di archi
         * entranti ed uscenti (i.e., dato G=(V,E) si verifichi se
         * per ogni vertice v  in-degree(v) = out-degree(v)).
         */

        public boolean SameInOutDegree() {
        	Map<Vertex,Integer> inDegreeMap= new HashMap<Vertex,Integer>(); 
        	TreeMap<Vertex, Double> neighborMap;
        	//Calcola inDegreeMap
        	for (Vertex v: adjacencyMap.keySet()) inDegreeMap.put(v,0);
         	for (Vertex v: adjacencyMap.keySet()) {
            	neighborMap = adjacencyMap.get(v);
            	for (Vertex w: neighborMap.keySet())
            		inDegreeMap.put(w, inDegreeMap.get(w)+1);
         	}
         	for (Vertex v: adjacencyMap.keySet()) {
         		// verifica l'uguaglianza tra outdegree e indegree
         		if (adjacencyMap.get(v).size() != inDegreeMap.get(v)) return false;
         	}		
        	return true;
        }


        /**  EX3 del 27/01/2016
         * Si aggiunga alla classe Network<Vertex> un metodo che, dati due vertici s e t,
         * verifichi l'esistenza di un cammino da s a t che attraversa soltanto archi di peso
         * dispari (si assuma che gli archi siano etichettati da valori interi positivi).
         */
        	
        public  boolean CamminoDispari(Vertex start, Vertex target){
         
        // Inizializzazione implicita di un iteratore DepthFirst a start.
        Stack<Vertex> stack = new Stack<Vertex>();
        HashMap<Vertex, Boolean> reached = new HashMap<Vertex, Boolean>();
        for (Vertex v: adjacencyMap.keySet()) reached.put (v, false);
        stack.add (start);
        reached.put (start, true);

        while (!stack.isEmpty() && !reached.get (target)) {
            // Estrazione del vertice successivo raggiungibile dallo stack.
            Vertex current = stack.pop();
            TreeMap<Vertex, Double> neighborMap = adjacencyMap.get (current);            
            for (Map.Entry<Vertex, Double> entry: neighborMap.entrySet())
            {
                Vertex to = entry.getKey();
                if (!reached.get (to) && entry.getValue()%2==1)
        			// NB: per verificare l'esistenza di un generico cammino da
        			// start a target e' sufficiente verificare se (!reached.get (to))
                {
                   reached.put (to, true);
                   stack.add (to);
                } // if
                if (to.equals(target)) break;
            } // for
        } // while
        return reached.get (target);
        } // method CamminoDispari


        /**
        * EX3 del 4.7.2017
        * Si aggiunga alla classe Network<Vertex> un metodo che verifichi se tutti
        * gli archi del grafo orientato corrente hanno la stessa etichetta.
        */

        public boolean SameEdgeLabel1() {
        	Double label;
        	if (adjacencyMap.isEmpty()) return true;
        	TreeMap<Vertex, Double> NM = adjacencyMap.get(adjacencyMap.firstKey());
        	label = NM.get(NM.firstKey()); //valore di un'etichetta      
            for (Vertex v: adjacencyMap.keySet())	{
            	TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(v);
            	for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) 
            		if (! entry.getValue().equals(label) ) return false; 	
            }
            return true;
        }


        public boolean SameEdgeLabel2() {
        	HashSet<Double> setOfLabels= new HashSet<Double>();  
        	if (adjacencyMap.isEmpty()) return true;
            for (Vertex v: adjacencyMap.keySet())	{
            	TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(v);
            	setOfLabels.addAll(neighborMap.values());
            	if (setOfLabels.size()>1) return false; 	
            }
            return true;
        }
            




        /**
        * EX2 del 14.2.2017
        * Si aggiunga alla classe Network<Vertex> un metodo che verifichi se il grafo
        * orientato corrente contiene tutti vertici interni (informalmente, un vertice
        * si dice "interno" se ha almeno un arco entrante ed almeno un arco uscente,
        * ovvero se non e' ne' sorgente ne' pozzo).
        */

        public boolean InternalNodes() {
        	HashSet<Vertex> indegreeSet= new HashSet<Vertex>();
        	//indegreeSet e' il set dei vertici aventi almeno un arco entrante
        	TreeMap<Vertex, Double> neighborMap;
        	for (Vertex v: adjacencyMap.keySet()) {
        		if (adjacencyMap.get(v).size() == 0) return false;  // outdegree(v)==0 
        		else {
                	neighborMap = adjacencyMap.get(v);
                	//for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet())
                	//	indegreeSet.add(entry.getKey());
                	indegreeSet.addAll(neighborMap.keySet());
        		}
        	}
        	return ( indegreeSet.size() == adjacencyMap.size() );
        }


        /* EX 3 del 17.1.2017   
        * Si aggiunga alla classe Network<Vertex> un metodo che determini
        * se il grafo corrente contiene almeno un nodo isolato, ovvero un
        * nodo con out-degree e in-degree uguali a zero.
        */

        public boolean InOutDegreeZero() {
        	Set<Vertex> FlagOutZero= new HashSet<Vertex>(); //set di vertici con outdegree=0
        	TreeMap<Vertex, Double> neighborMap;
        	for (Vertex v: adjacencyMap.keySet()) {
        		if (adjacencyMap.get(v).size()==0) FlagOutZero.add(v);
        	}
        	if (FlagOutZero.size()==0) return false; // tutti i nodi hanno almeno un arco uscente
        	
        	for (Vertex v: adjacencyMap.keySet()) {
            	neighborMap = adjacencyMap.get(v);
            	/* for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
            			Vertex u = entry.getKey();
            			FlagOutZero.remove(u);
            			if (FlagOutZero.size()==0) return false;
            	} */
            	FlagOutZero.removeAll(neighborMap.keySet());
            	if (FlagOutZero.size()==0) return false;
        	}
        	return true;
        }
        

