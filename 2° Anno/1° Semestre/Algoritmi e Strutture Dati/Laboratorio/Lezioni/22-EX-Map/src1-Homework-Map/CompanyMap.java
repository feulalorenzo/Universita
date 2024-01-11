/* EX1
Suppose we are given the name and division number for each employee in a company.
There are no duplicate names. We would like to store this information alphabetically, by name. 
How should this be done? 
TreeMap? TreeSet? Comparable? Comparator? 
*/

import java.util.*;

class CompanyMap
{
    public static void main(String[ ] args)
    {

	TreeMap<String, Integer> companyMap = new TreeMap<String, Integer>();

    companyMap.put ("Misino John", 8);
    companyMap.put ("Nguyen Viet", 14);
    companyMap.put ("Panchenko Eric", 6);
    companyMap.put ("Dunn Michael", 6);
    companyMap.put ("Deusenbery Amanda", 14);
    companyMap.put ("Taoubina Xenia", 6);

    System.out.println ("Company Map:\n" + companyMap);
    System.out.println ("\nEmployees:\n" + companyMap.keySet());
    // Contiene le duplicazioni
    // System.out.println ("\nDivision numbers:\n" + companyMap.values());
    System.out.println ("\nDivision numbers:\n" + new TreeSet<Integer>(companyMap.values()));


	System.out.println ("\nDivision number 6:");	
	// SCHEMA DI ITERAZIONE SULLA COLLECTION VIEW!
	for (Map.Entry<String, Integer> entry : companyMap.entrySet()) {
		// entry è una specifica coppia chiave-valore <k,v>  
	    if (entry.getValue() == 6)  System.out.println (entry.getKey());
	}


/* 
We want to count the number of employees in each division number (Division number layout)
*/
    // Map <Division number, number of employees> 
	TreeMap<Integer, Integer> companyCount =  new TreeMap<Integer, Integer>();

	for (Integer dn : companyMap.values())
	    companyCount.put(dn,0);  // inserisce <6,0>, <8,0>, <14,0>

	for (Map.Entry<String, Integer> entry : companyMap.entrySet()) {
		int currentValue = entry.getValue();
	    companyCount.replace(currentValue, companyCount.get(currentValue)+1 );
	    //companyCount.put(currentValue, companyCount.get(currentValue)+1 ); 		
	}
	  
	System.out.println ("\nDivision number layout: " + companyCount);


    } // method main                                   
    

} // class CompanyMap
