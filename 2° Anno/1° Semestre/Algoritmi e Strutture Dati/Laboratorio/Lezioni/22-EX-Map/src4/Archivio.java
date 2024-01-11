/*** RIVISITAZIONE EX1 I PARZIALE - USO TREEMAP  ***/

import java.util.*;

public class Archivio  {
  
TreeMap<String, Cliente> archivio =	new TreeMap<String, Cliente>(); 

public void insert(String targa, Cliente cliente) {
	archivio.put(targa, cliente);
}

public void delete (String targa) {
	archivio.remove(targa);
}


public Archivio crea_byCitta(String citta) {
	Archivio nuovo  = new Archivio();
	for (Map.Entry<String, Cliente> entry: archivio.entrySet())
		if ( (entry.getValue().getCitta()).equals(citta.toUpperCase()) )
			nuovo.archivio.put(entry.getKey(),entry.getValue());
	return nuovo;
}
  
   /**
   * Restituisce una rappresentazione String di questo archivio   */
  public String toString()
  {   
	  String s = new String("\n");
	  for (Map.Entry<String, Cliente> entry: archivio.entrySet())
		  s += entry.getKey().toString() + ", " + entry.getValue().toString() + ";\n";
	  return s;
  } // method toString
  
} // end-class 

