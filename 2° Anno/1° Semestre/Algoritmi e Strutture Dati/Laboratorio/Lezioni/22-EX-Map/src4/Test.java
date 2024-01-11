public class Test  //EX1
{
    public static void main(String[] args)
    {
        new Test().run();
    } // method main

    public void run() {
    	Cliente c1 = new Cliente("Jones", "BBBBBBB", "Roma"),
    		    c2 = new Cliente ("Smith", "AAAAAAA", "Siena"), 
    		    c3 = new Cliente ("Jones", "ZZZZZZZ", "Torino");
    	
        Archivio a = new Archivio();
        a.insert("T523", c1);
        a.insert("T345", c3);
        a.insert("T444", c2);
        a.insert("T400", c3);

    System.out.println("Archivio: " + a);
          
    a.delete("T345");
    System.out.println("Cancella T345");
    System.out.println("Archivio: " + a);
    
    a.insert("T345", c1); 
    System.out.println("Insert T345, Jones");
    System.out.println("Archivio: " + a);
        
    Archivio roma = a.crea_byCitta("Roma");
    System.out.println("Roma: " + roma);
    

    } // method run

} // class 