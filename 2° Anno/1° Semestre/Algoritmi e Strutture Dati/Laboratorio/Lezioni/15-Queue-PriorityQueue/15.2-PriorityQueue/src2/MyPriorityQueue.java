import java.util.Comparator;

/**
 * A trivial implementation built as a wrapper around the ArrayListBinaryHeap class
 * Notice the highest priority for the maximum item
 */
public class MyPriorityQueue<T extends Comparable<? super T>>
   	implements MyQueue<T> {

	private ArrayListBinaryHeap<T> data;
    
    /**
     *  Constructs the binary heap given a comparator
     */
    public MyPriorityQueue() {data = new ArrayListBinaryHeap<T>();} 
    
    /**
     *  Constructs the binary heap given a comparator
     */
    public MyPriorityQueue(Comparator<T> comparator)
    {
    	data = new ArrayListBinaryHeap<T>(comparator);
    }
    

    public boolean offer(T item) {data.insert(item); return true;}
    
    
    public T remove() {
	return data.deleteMax(); 
    }
    
    public T peek() {
	if (isEmpty()) return null;
	else return data.findMax(); 
    }
    
    public int size() {return data.size();}
    
    public boolean isEmpty() {return data.isEmpty();}

}