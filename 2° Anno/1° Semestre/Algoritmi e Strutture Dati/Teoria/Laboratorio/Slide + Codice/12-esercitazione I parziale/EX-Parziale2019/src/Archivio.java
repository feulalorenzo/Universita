import java.util.*;

public class Archivio 
{
 
List<Automobile> archivio = new ArrayList<Automobile>(); 

public void insert(String targa, Cliente cliente) {
	insert(new Automobile (targa, cliente));
}

public void insert(Automobile altra_auto) {
	for (Automobile auto: archivio) {
		if (auto.equals(altra_auto)) {
			auto.setCliente(altra_auto.getCliente());
			return;
		}
	}
	archivio.add(altra_auto);
}


public void insert2(Automobile altra_auto) {
	int pos = archivio.indexOf(altra_auto);
	if (pos == -1) 	archivio.add(altra_auto);
	else archivio.set(pos, altra_auto);
}


public boolean delete (String targa) {
	return archivio.remove(new Automobile(targa));
}


public Archivio archivio_byCitta(String citta) {
	Archivio nuovo  = new Archivio();
	for (Automobile a: archivio)
		if (a.getCliente()!=null && (a.getCliente().getCitta()).equals(citta.toUpperCase()) ) nuovo.insert(a);
	return nuovo;
}
  
 
public void sort_byTarga() {
	Collections.sort(archivio);
}

public void sort_byCF() {
	Collections.sort(archivio, new Cmp_byCF());
}

   /**
   * Restituisce una rappresentazione String di questo archivio   */
  public String toString()
  {   String s = "";
	  for (Automobile a: archivio) {
		  s += a.toString() + ";\n";
	  }
	  return s;
  } // method toString
  
} // end-class 


class Cmp_byCF implements Comparator<Automobile>{
  public int compare(Automobile a1, Automobile a2) {
	  if (a1.getCliente() == null) return +1; // priorità minore ad automobili prive di proprietario
	  if (a2.getCliente() == null) return -1;
	  return (a1.getCliente()).compareTo((a2.getCliente()));
  }

}

/*
 * HOMEWORK: implementare un metodo 
 *  	public Cliente FindClient (String targa);
 * che ricerca e restituisce in output il proprietario dell'automobile specificata in input.
 * Calcolare la complessità computazionale della soluzione proposta (caso peggiore). 
 * 
 * Spunti di riflessione:
 * esistono soluzioni alternative più efficienti per l'operazione di ricerca? 
 * Trade-off costi di ricerca vs inserimenti e cancellazioni 
 */
 


