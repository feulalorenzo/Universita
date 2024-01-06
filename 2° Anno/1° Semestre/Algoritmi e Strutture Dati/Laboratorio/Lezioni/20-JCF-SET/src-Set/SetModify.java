/**
 * Programma che genera random N interi e modifica l'insieme ottenuto
 * Focus sull'uso degli iteratori contestualmente alla modifica dell'insieme
 **/

import java.util.*;

public class SetModify {
	
	public static void main (String[ ] args)
	{
	new SetModify().run();
	} // method main


public void run()
{
	int N = 20, MAXINT = 50;	
	Set <Integer> set1 = new  HashSet <Integer>(); 
					// new TreeSet <Integer>();
	Set <Integer> set2;
	Random  generator = new  Random ();
	for (int i=0; i < N; i++) {
		Integer x = generator.nextInt(MAXINT + 1);
		set1.add(x);
	}
	set2 = new  HashSet <Integer>(set1); 
			// new TreeSet <Integer>(set1);
	
	System.out.println("set1: " + set1);
	System.out.println("set2: " + set2);	
	if (set1.equals(set2)) System.out.println("\nGli insiemi sono uguali");
    else System.out.println("\nGli insiemi sono diversi");
    
    if (!set2.isEmpty()) {  //cancella un elemento
    	System.out.println("cancella un elemento da set2:");	
    	set2.remove(set2.iterator().next());
    	System.out.println("set2: " + set2);
    }
    // ora gli insiemi sono diversi
    if (set1.equals(set2))
    	System.out.println("\nGli insiemi sono uguali");
    else System.out.println("\nGli insiemi ora sono diversi\n");
    
  
    /*** Eliminare tutti gli interi pari **/
    Iterator<Integer> itr = set1.iterator();
    
    /** soluzione errata 
    while(itr.hasNext()) {
      Integer v = itr.next();
      if(v.intValue()%2==0) itr.remove();
    } */

   
    
    // Soluzione 1 - cancella da set1
    while(itr.hasNext()) {
      Integer v = itr.next();
      if(v.intValue()%2==0) {
    	  itr.remove();
    	  itr = set1.iterator();
      }
    }//end-while
    
    System.out.println("set1 (soli interi dispari):\n" + set1); 
    
    // Soluzione 2 - cancella da set2
    while(contienePari(set2)) 
    	eliminaUnPari(set2);
    
    	System.out.println("\nset2 (soli interi dispari):\n" + set2); 
   
  }//end-main
  
  private static boolean contienePari(Set<Integer> s) {
      Integer v;
      Iterator<Integer> itr = s.iterator();
      while(itr.hasNext()) {
        v=(Integer) itr.next();
        if(v.intValue()%2==0)
          return true;
      }
      return false;
    }
  
  private static void eliminaUnPari(Set<Integer> s) {
	    Integer v;
	    Iterator<Integer> itr;
	    itr=s.iterator();
	    while(itr.hasNext()) {
	      v=(Integer) itr.next();
	      if(v.intValue()%2==0) {
	        s.remove(v);
	        break;
	      }
	    }
	  }
}

