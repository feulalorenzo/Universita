/*
 * What is the output of the Java program given below?
 */

public class Ex1 {
   private static int value = 10; 
   private String word;
   int id;
   static int c;

   public Ex1(String word) {  this.word = word; System.out.println(this);   }
   
   public String toString(){ return id + " di " + c + ") " + value + ", " + word; }
   
   { id = ++c; }
   static { value = 50;   c = 0; }

   public static void main(String args[]) {
   	Ex1  a = new Ex1("oggi"), b = new Ex1("domani");
    	b.value = 100;
     	System.out.println(a);  System.out.println(b); }
}
