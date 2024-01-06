/**
 *   HEAPSORT
 */

import java.util.*;


public class HeapSort_ByPriorityQueue
{
    public static void main(String[] args)
    {
        new HeapSort_ByPriorityQueue().run();
    } // method main


    public void run()
    {
    int L = 15, MAXINT = 100;

    List<Integer> numbers = new ArrayList<Integer>(L);
    Random r = new Random ();
    for (int i = 0; i < L; i++) numbers.add(r.nextInt(MAXINT)); 
    System.out.println("Array da ordinare:\n" + numbers);

    //heapSort
    List<Integer> result = new ArrayList<Integer>(L);
    Queue<Integer> pq = new PriorityQueue<Integer>(numbers); //input di tipo Collection
    while (!pq.isEmpty())
        result.add(pq.remove());  //  poll()

    System.out.println("\nArray ordinato:\n" + result);

   } // method run

}