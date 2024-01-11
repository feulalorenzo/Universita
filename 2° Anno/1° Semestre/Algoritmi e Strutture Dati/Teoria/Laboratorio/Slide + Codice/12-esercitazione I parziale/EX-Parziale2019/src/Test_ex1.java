public class Test_ex1
{
    public static void main(String[] args)
    {
        new Test_ex1().run();
    } // method main

    public void run() {
    	Cliente c1 = new Cliente("Jones", "BBBBBBB", "Roma"),
    		    c2 = new Cliente ("Smith", "AAAAAAA", "Siena"), 
    		    c3 = new Cliente ("Jones", "ZZZZZZZ", "Torino"),
    			c4 = new Cliente ("CCCCCCC");
    	
    	Automobile a1 = new Automobile ("T523", c1),
	    a2 = new Automobile ("T345", c3), 
	    a3 = new Automobile ("T444", c2),
	    a4 = new Automobile ("T400", c3),
    	a5 = new Automobile ("T500", c4);
        Archivio a = new Archivio();
        a.insert(a1);
        a.insert(a2);
        a.insert(a3);
        a.insert(a4);
        a.insert(a5);

    System.out.println("Archivio:\n" + a);
          
   
    a.insert2(new Automobile ("T345", c1)); 
    System.out.println("Insert T345, (Jones, BBBBBBB, Roma)");
    System.out.println("Archivio:\n" + a);
    
    a.delete("T345");
    System.out.println("Cancella T345");
    System.out.println("Archivio:\n" + a);
    
    a.sort_byCF();
    System.out.println("Ordina per CF");
    System.out.println("Archivio:\n" + a);
    
    a.sort_byTarga();
    System.out.println("Ordina per Targa");
    System.out.println("Archivio:\n" + a);
    
    Archivio roma = a.archivio_byCitta("Roma");
    System.out.println("Roma:\n" + roma);
    
    Archivio unk = a.archivio_byCitta("unknown");
    System.out.println("Città di residenza sconosciuta:\n" + unk);

    } // method run

} // class 