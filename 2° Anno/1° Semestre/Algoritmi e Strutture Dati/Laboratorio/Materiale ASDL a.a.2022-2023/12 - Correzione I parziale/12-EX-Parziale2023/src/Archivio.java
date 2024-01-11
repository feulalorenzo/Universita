import java.util.*;

public class Archivio 
{
 
List<Paziente> archivio = new LinkedList<Paziente>(); 

public boolean insert(String cf, int eta, int reparto) {
	if (cf != null && eta >=0 && reparto >=0 && reparto <= 10)// semplificato
		return insert(new Paziente (cf, eta, reparto));
	else return false;
	}

private boolean insert(Paziente altro_Paziente) {
	for (Paziente p: archivio)
		if (p.equals(altro_Paziente)) return false;
	archivio.add(altro_Paziente);
	return true;
}

public boolean delete (String cf) {
	return archivio.remove(new Paziente(cf));
}


public Archivio archivio_perReparto(int r) {
	Archivio nuovo  = new Archivio();
	for (Paziente p: archivio)
		if (p.getReparto()==r) nuovo.insert(p);
	return nuovo;
}
  
 
public void sort_byCF() {
	Collections.sort(archivio);
}

public void sort_byEta() {
	Collections.sort(archivio, new Cmp_byEta());
}

public int[] PazientiPerReparto() {
	int[] occ = new int[11]; // occ[0] dummy
	for (int i=0; i<11; i++) occ[i]=0;
	for (Paziente p: archivio) occ[p.getReparto()]++;
	return occ;
}

   /**
   * Restituisce una rappresentazione String di questo archivio   */
  public String toString()
  {   String s = "";
	  for (Paziente p: archivio) {
		  s += p.toString() + ";\n";
	  }
	  return s;
  } // method toString
  
 
  
  
} // end-class 


class Cmp_byEta implements Comparator<Paziente>{
  public int compare(Paziente p1, Paziente p2) {
	  return (p1.getEta() - p2.getEta() );
  }
}


 


