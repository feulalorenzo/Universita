/* ESEMPIO DI USO DELLA CLASSE MyPriorityQueue<E> */

import java.util.*;

public class Test_MyPriorityQueue
{
	public static void main (String[ ] args)
	{
		new Test_MyPriorityQueue().run();
	 } // method main
	
	public void run()
	{
		MyQueue<String> pq = new MyPriorityQueue<String> ();

		System.out.println("Strings: yes, no, maybe, wow, no");
		pq.offer ("yes");
        pq.offer ("no");
        pq.offer ("maybe");
        pq.offer ("wow");
        pq.offer ("no");
        
		MyQueue<String> pq_byLenght = new MyPriorityQueue<String> (
				new Comparator<String>() {
					public int compare(String s1, String s2) {
					int len1 = s1.length(),
			 		    len2 = s2.length();
					if (len1 == len2) return s1.compareTo (s2);
					else return len1-len2;
					} // method compare
				});        

        pq_byLenght.offer ("yes");
        pq_byLenght.offer ("no");
        pq_byLenght.offer ("maybe");
        pq_byLenght.offer ("wow");
        pq_byLenght.offer ("no");
		
        System.out.println("Reverse Alphabetical order:");
        while (!pq.isEmpty()) 
        	System.out.println("Maximum priority: " + pq.remove());
        
        System.out.println("\nReverse order by string length:");
        while (!pq_byLenght.isEmpty()) 
        	System.out.println("Maximum priority: " + pq_byLenght.remove());
                
	} // method run
	
} // class 


