
public class Ex_BinaryNode {
	
	/**
	 * Esercizio 1  II parziale 10.01.2018 
	 * Un albero binario di interi si dice pari se tutti i nodi contengono
	 * un intero positivo pari.  Realizzare il metodo statico 
	 * public static boolean IsEvenBtree (BinaryNode<Integer> node) 
	 * che verifica se l'albero binario dato btree e' pari.
	 **/

	 /* soluzione ricorsiva */
	 public static boolean IsEvenBtree (BinaryNode<Integer> node) {
		 if ( node == null ) return true;
		 int s = node.getData();
		 if (s % 2 == 1) return false;
		 else return IsEvenBtree (node.getLeft()) && IsEvenBtree (node.getRight());
	 }
	 
	   	 	
	/*** EX2 I appello 2015/2016  del 27/01/2016  
	Un albero binario si dice "pieno" se tutti i nodi hanno esattamente 0 o 2 figli,
	e nessun nodo ha 1 figlio. 
	Si aggiunga alla classe BinaryNode<E> un metodo ricorsivo
	public boolean isFullBtree()   
	che verifica se l'albero binario radicato nel nodo corrente e' pieno. 
	 
		public boolean isFullBtree() {
			if (this == null || (left == null && right == null) ) return true;
			if ( left !=null && right != null) 
				return (left.isFullBtree() && right.isFullBtree());
			else return false;
		}  // method isFullBtree
	*/ 
	 
	 
	/****************************************************************************
	 * HOMEWORK
	 * 
	Si aggiunga alla classe BinaryNode<E> un metodo ricorsivo  
	public BinaryNode<E> mirror()
	che dato il nodo corrente restituisce il suo nodo "specchio", ovvero
	il nuovo nodo deve essere radice di un albero binario che è
	immagine speculare dell'albero binario radicato nel nodo corrente: 
	ogni figlio destro di questo sottoalbero diventa sinistro e viceversa. 

	  	    public BinaryNode<E> mirror() {
	   	    	BinaryNode<E> l = null, r = null;
	   	    	if (right != null) r = right.mirror();
	  	    	if (left  != null) l = left.mirror();
	   	 		return new BinaryNode<E>(r, data, l);
	   	 	}  // mirror
	   	 	
	*/
 
	
}

