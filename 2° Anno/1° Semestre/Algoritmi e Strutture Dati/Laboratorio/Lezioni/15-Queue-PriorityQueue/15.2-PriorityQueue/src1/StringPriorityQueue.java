/* ESEMPIO DI USO DELLA CLASSE PriorityQueue<E>
 * Notice the highest priority for the smallest item  */

import java.util.*;

public class StringPriorityQueue
{
	public static void main (String[ ] args)
	{
		new StringPriorityQueue().run();
	 } // method main
	
	public void run()
	{
		Queue<String> pq = new PriorityQueue<String> ();
		
		pq.offer ("yes");
        pq.offer ("no");
        pq.offer ("maybe");
        pq.offer ("wow");
        pq.offer ("no");
			
		Queue<String> pq_byLenght = new PriorityQueue<String> (
				/** 
				 *  Compares two specified String objects 
				 *  lexicographically if they have the same length, and 
				 *  otherwise returns the difference in their lengths.
				 *
				 *  @param s1 – one of the specified String objects.
				 *  @param s2 – the other specified String object.
				 *
				 *  @return s1.compareTo (s2) if s1 and s2 have the 
				 *                same length; otherwise, return
				 *                 s1.length() – s2.length(). 
				 *
				 */	
				new Comparator<String>() {
			public int compare(String s1, String s2) {
			int len1 = s1.length(),
	 		    len2 = s2.length();
			if (len1 == len2) return s1.compareTo (s2);
			else return (len1 - len2);
			} // method compare
		});        

        
        pq_byLenght.offer ("yes");
        pq_byLenght.offer ("maybe");
        pq_byLenght.offer ("no");
        pq_byLenght.offer ("wow");
        pq_byLenght.offer ("no");
        
        /* Esempio di violazione nell'accesso all'ADT Priority Queue:
         * la coda può essere iterata, consentendo l'accesso anche agli elementi
         * diversi da quello avente priorita' maggiore.
         * Notare che NON si garantisce l'iterazione ordinata.  
         */
 
        System.out.println("pq contiene (iterazione non ordinata!):");
        for (String s: pq) System.out.println (s);
        System.out.println("\npq_byLenght contiene (iterazione non ordinata!):");
        for (String s: pq_byLenght) System.out.println (s);
        
        /* Accesso vincolato */
        System.out.println("\nAlphabetical order:");
        while (!pq.isEmpty()) 
        	System.out.println("Maximum priority: " + pq.poll());
        
        System.out.println("\nOrder by string length:");
        while (!pq_byLenght.isEmpty()) 
        	System.out.println("Maximum priority: " + pq_byLenght.poll());
        
	} // method run
} // class StringPriorityQueue


