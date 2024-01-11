/***************************************************************************
 * 
 * SortedDoublyLinkedList.java
 *
 * More advanced implementation of the Collection interface using a doubly
 * linked list with references to both the head and tail Node's in the list.
 * It implements a sorted list.
 * Here Sorted list is implemented using a doubly linked list 
 * and each inserted element is placed at correct position in the list. 
 *
 *****************************************************************************/

   /********************************************************************
   					             I PARTE
   ********************************************************************/ 

import java.util.*;

public class SortedDoublyLinkedList<E extends Comparable<? super E>> implements List<E> {
// Remark: Implemented Interface: java.lang.Iterable<E> 
	

 /*******************************************************
 *
 *  The Node class
 *
 ********************************************************/
   private static class Node<E> {
	   private E data;
	   private Node<E> next;
	   private Node<E> prev;

      public Node(E data, Node<E> next, Node<E> prev) {
         this.data = data;
         this.next = next;
         this.prev = prev;
      }
   }  //end-class-Node
   
      
   private Node<E> head = null;
   private Node<E> tail = null;
   private int size = 0;
   private Comparator<? super E> c = null;

   /**
    *  Constructs an empty list
    */
    public SortedDoublyLinkedList() { }
    
    /**
     *  Constructs an empty list
     */
    public SortedDoublyLinkedList(Comparator<? super E> comparator) 
    {
      c = comparator;
    }
    
  /**
   *  Returns true if the list is empty
   */
   public boolean isEmpty()  {  return size == 0; }

  /**
   *  Returns the length of the list
   */
   public int size()  { return size; }
   
  /**
   *  Gets the value of the property comparator
   */
   Comparator<? super E> getComparator()  { return c; }
   
   /**
    *  Returns the first element in the list.
    *
    */
   public E getFirst()
   {
	   if(head == null) throw new NoSuchElementException();
       return head.data;
   }

  /**
    *  Removes the first element in the list.
    *
    */
    public E removeFirst()
    {
 	  if (head == null) throw new NoSuchElementException(); // size == 0
       E elem = head.data;
       head = head.next;
       if (head == null) tail = null; // empty list
       else head.prev = null;
       size--;
       return elem;
    }
    
    /**
     *  Returns the last element in the list.
     *
     */
     public E getLast()
     {
        if (tail == null) throw new NoSuchElementException(); // size == 0
        return tail.data;
     }


   /**
     *  Removes the last element in the list.
     *
     */
     public E removeLast()
     {  
    	 if (tail == null) throw new NoSuchElementException();  // size == 0
    	 E elem = tail.data;
    	 if (size == 1) return removeFirst();
    	 else { // there are at least two nodes
    		 tail = tail.prev;
    		 tail.next = null;
    		 size--;
    	 }
    	 return elem;
     }


   /**
     *  Removes all nodes from the list.
     *
     */
     public void clear()
     {
    	 head = tail = null; size=0;
     }

   /**
     *  Returns the data at the specified position in the list.
     *
     */
     public E get(int index)
     {
        if (head == null || index < 0 || index > size - 1 ) throw new IndexOutOfBoundsException();
        Node<E> cur;
        int count;
        // la direzione dell'iterazione dipende dalla posizione index
        if (index <= size/2)
        	 for (cur = head, count = 0; count < index; count++) cur = cur.next;
        else for (cur = tail, count = size-1; count > index; count--) cur = cur.prev; 
        return cur.data;
     }


   /**
     *  Returns a string representation
     *
     */
     public String toString()
     {
    	 StringBuffer result = new StringBuffer();  
    	 for(Object x : this) result.append(x + " ");
    	 return result.toString();
     }
        

   /**
     *  Removes the first occurrence of the specified element in this list.
     *
     */
     
     private boolean lessThan(E x, E y){
    	   if (c == null) return (x.compareTo(y) < 0);
    	   else return (c.compare(x, y)) < 0;
     }
     
     public boolean remove(Object key)
     {
    	 return false;
     }
     
     
     public boolean remove(E key)
     {
    	 if ( key == null || head == null || lessThan(key, head.data) ) return false;

    	 Node<E> cur  = head;
    	 while(cur != null && lessThan(cur.data, key)) cur = cur.next;
    	 //  this list does not contain the specified element,
    	 if(cur == null || !cur.data.equals(key)) return false;
    	 // removes the first occurrence of the specified element from this list,
    	 if (cur == head) removeFirst();
    	 else if (cur == tail) removeLast();
    	 else {
    		 cur.prev.next = cur.next;
    		 cur.next.prev = cur.prev;
    		 cur.next = cur.prev = null;
    		 size--;
    	 }
    	 return true;	
     }
     
     /**
      *  Removes the first occurrence of the specified element in this list.
      *  (for teaching purposes)
      *
      */
      public boolean removeRec (E key)
      {
         if ( (key == null) || (head == null) || lessThan(key, head.data) ) return false;
         if (head.data.equals(key)) { 
       	  removeFirst();
       	  return true; 
         } else return removeRec(head.next, key);
      }


      private boolean removeRec (Node<E> cur, E key){
         if (cur == null ||  lessThan(key, cur.data) ) return false;
         if (cur.data.equals(key)) {
      	    if (cur == tail) removeLast();
      	    else {
      	    	  cur.prev.next = cur.next;
      	    	  cur.next.prev = cur.prev;
      	    	  cur.next = cur.prev = null;
      	    	  size--;
      	    }
       	  return true;
         }
         else return removeRec(cur.next, key);
          	
      }
      
      
      
      /**
       *  Removes the element at the specified position in this list
       */   
      public E remove (int index) {
    	  if ((head == null) || (index < 0) || (index > size-1)) throw new IndexOutOfBoundsException(); 
    	  if (index == 0) return this.removeFirst();
    	  if (index == size-1) return this.removeLast();
    	  // 1 <= index <= size-2
          Node<E> cur = head.next; // index 1          
          for (int count = 1; count < index; count++) cur = cur.next;  //migliorabile
          //removes current node
      	  E item = cur.data;
      	  cur.prev.next = cur.next;
          cur.next.prev = cur.prev;
          cur.next = cur.prev = null;
          size--;
          return item;
      }
              
      /**
       *  Returns true if this list contains the specified element.
       *
       */
      public boolean contains(Object x) {return false;}
      
      public boolean contains(E key)  
       {
    	  for(E curEl : this)
       			if(curEl.equals(key)) return true;
       			else if (lessThan(key, curEl)) break;
          return false;
       }
      
      
      
      /********************************************************************
      					             II PARTE
      ********************************************************************/ 
    
   /** Inserts the element into the proper sorted location.
    */
   public boolean add(E item)
   { 
	   return add(item,c);
   }
   
   private boolean add(E item, Comparator<? super E> comparator) { 
	   
	   if (item == null) return false; 
	   // we insert the first element
	   if (size == 0) {  
		   tail = head = new Node<E>(item, null, null);
		   size++;
		   return true;
  	   }
	   // we insert the element at the first position 
	   if (lessThan(item, head.data)) {  
		   head = new Node<E>(item, head, null);
		   head.next.prev = head;
		   size++;
		   return true;
	   }
	   // we insert the element into the proper sorted location   
  	   Node<E> cur = head;
  	   /* We continue until cur reaches the node before which we need to make an insertion:
  	    * if cur reaches null, we insert the element at the last position (after tail), 
		* otherwise we insert the element between prev and cur
  	    */
  	   while (cur!= null && lessThan(cur.data, item)) cur = cur.next;
  	   if (cur == null) {
  		   // inserts the element at the last position
  		   tail.next = new Node<E>(item, null, tail);
  		   tail = tail.next;
  	   } else { 
  		   // (cur.data >= item) inserts the element between prev and cur
  		   Node<E> prev = cur.prev;
  		   Node<E> newnode = new Node<E>(item, cur, prev);
  		   cur.prev = newnode;
  		   // remark: prev could be null if item is equal to the first element
  		   if (prev!=null) prev.next= newnode; else head =  newnode;
  	   }
  	   size ++;
  	   return true;
   } //end-add 
    				
      
    /**
      *  A Comparator based ordering method
      */
     
   public void insertionSort()
   /* we sort the list into ascending order, according to the natural ordering 
    * of its elements.*/
   {
	   insertionSort(null);
   }
     
   /**
	 * Sorts the list according to the order induced by the specified comparator.
	 */
   public void insertionSort(Comparator<? super E> comparator) //O(n^2)
   {
	   SortedDoublyLinkedList<E> list = new SortedDoublyLinkedList<E>();
       for (E item: this)  list.add( item, comparator);
       head = list.head;
       tail = list.tail;
       c = comparator;
   }
   
   
   /**
    * toArray() method returns an array containing all of
    * the elements in this list in proper sequence (from
    * first to last element). 
    * */ 

    public Object[] toArray() {
 	   if (head == null) return null;
        Object[] array = new Object[size];
        int i=0;	
        for (E item: this) {array[i++] = item; }
        return array;
      }
   
    
   private void append(E item) {
	   if (size == 0) head = tail = new Node<E> (item, null, null);
	   else {
		   tail.next = new Node<E>(item, null, tail);
		   tail = tail.next;
	   }
	   size++;
   }
   
   public void sort() //O(n lgn)
   {
	   sort(null);
   }
   
   public void sort(Comparator<? super E> comparator) 
   //O(n lgn) Mergesort-based
   {
	   if (this.isEmpty()) return;
	   List<E> array = new ArrayList<E>(this);
       if (comparator == null) Collections.sort(array); 
       else  Collections.sort(array, comparator);
	   SortedDoublyLinkedList<E> list = new SortedDoublyLinkedList<E>();
	   // for (E item: array) list.add(item);  // inefficiente O(n^2)
	   for (E item: array) list.append(item);
	   head = list.head;
	   tail = list.tail;
	   c = comparator; 
   }
   /* NOTA In sort si potrebbe usare un array come: Object[] array = this.toArray()
      Tuttavia si rilevano warnings (unchecked cast from Object to E) e si hanno problemi run time
      Preferibile usare ArrayList<E> */
   
      
      
   /**
     *  Sets the value of the property comparator
     */
   public void  setComparator(Comparator<? super E> comparator)
   	{
   		//insertionSort(comparator); //O(n^2)
   		sort(comparator); //O(n log n)
   	}
   
   
   public boolean equals (Object obj) {
	   return (this == obj);
   }
   
   
   public void add(int index, E item) //potrebbe violare l'ordinamento
   // Inserts the specified item at the specified position in this list.
   { throw new UnsupportedOperationException(); }
   
   public E set(int index, E element) //potrebbe violare l'ordinamento
   // Replaces the element at the specified position in this list with the specified element.
   { throw new UnsupportedOperationException(); }


   
   /*******************************************************
   *
   *  The Iterator class
   *
   ********************************************************/
   
     public Iterator<E> iterator()
     {
        return new DoublyLinkedListIterator();
     }

     
     /** 
      * Returns a list iterator over the elements in this list (in proper sequence)
      * 
      */
     public ListIterator<E> listIterator()
     { 
         return new DoublyLinkedListIterator();   
     }
     
     public ListIterator<E> listIterator(int index)
     { 
         return new DoublyLinkedListIterator(index);   
     }


     private class DoublyLinkedListIterator  implements ListIterator<E>
     {  
    	/* Recall:  ListIterator has no current element; its cursor position 
        always lies between the element that would be returned by a call to 
        previous() and the element that would be returned by a call to next(). */
    	 
    	 private Node<E> nextNode;
         private Node<E> prevNode;
         private Node<E> lastNode = null; //last returned         
    	 private int posNext;   	 

    	 
        public DoublyLinkedListIterator()
        {
        	// riferimento al nodo contenente l'elemento accessibile invocando next()
        	nextNode = head;
        	// riferimento al nodo contenente l'elemento restituito con l'ultima invocazione di next()
        	prevNode = null;
        	posNext = 0;  // position of the "next" node
        	// posNext-1 is the position of the "prev" node //
        }
        
        
        
        public DoublyLinkedListIterator(int index)
        {
        	if ((index < 0) || (index > size)) throw new IndexOutOfBoundsException(); 
      	  	if (index == size) {
      	  		nextNode = null;
      	  		prevNode = tail;
      	  		posNext = size;
      	  	} else {
      	  		for (nextNode = head, posNext = 0; posNext<index; posNext++)
      	  			nextNode = nextNode.next;
      	  		prevNode = nextNode.prev; 
      	  	}
        }
        

        public boolean hasNext()
        {
           return nextNode != null;
        }
        
        public boolean hasPrevious() 
        { 
        	return prevNode != null;
        }	

        public E next()
        {
           if (!hasNext()) throw new NoSuchElementException();
           E res = nextNode.data;
           lastNode = prevNode = nextNode;
           nextNode = nextNode.next;
           posNext++;
           return res; // in prevNode
        }
        
        public E previous()
        {
            if (!hasPrevious()) throw new NoSuchElementException();
            E res = prevNode.data;
            lastNode = nextNode = prevNode;
            prevNode = prevNode.prev;
            posNext--;
            return res;  // in nextNode
        }

        public int nextIndex()
 	   	{ return posNext; }
        
        public int previousIndex()
 	   	{ return posNext-1; }
        
        public void remove() {
        	/* next()/previous() has not been called yet or 
        	   remove has already been called */
        	if (lastNode == null) throw new NoSuchElementException();
        	
        	//if the last object is returned by a call to next()
        	if (lastNode == prevNode) prevNode = prevNode.prev;
        	else //the last object is returned by a call to previous()
        		nextNode = nextNode.next;
        	
        	// remove lastNode between prevNode and nextNode
       	  	if (lastNode == head) { //prevNode == null
       	  		head=head.next;
       	  		head.prev = null;
       	  	} else if (lastNode == tail) { //nextNode == null
       	  			tail = tail.prev; 
       	  			tail.next = null;
       	  		   } else {
       	  			   prevNode.next = nextNode;
       	  			   nextNode.prev = prevNode;
       	  		   }
   	  		lastNode = null;
       	  	posNext--;
            size--;
        }
               
        public void add(E e) //potrebbe violare l'ordinamento
 	   	{ throw new UnsupportedOperationException(); }
        
        public void set(E e)  // potrebbe violare l'ordinamento
        { throw new UnsupportedOperationException(); }
            
     }  //end class LinkedListIterator

           


     public List<E> subList(int fromIndex, int toIndex)
     // Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. 
     { throw new UnsupportedOperationException(); }

     public int indexOf(Object o)
     // Returns the index of the first occurrence of the specified element in this list,
     // or -1 if this list does not contain the element.
     { throw new UnsupportedOperationException(); }

     public int lastIndexOf(Object o)
     // Returns the index of the last occurrence of the specified element in this list,
     // or -1 if this list does not contain the element.
     { throw new UnsupportedOperationException(); }
     
   public boolean retainAll(Collection<?> c)
   { throw new UnsupportedOperationException(); }

   public boolean removeAll(Collection<?> c)
   { throw new UnsupportedOperationException(); }
   
   public boolean addAll(int index, Collection<? extends E> c)
   { throw new UnsupportedOperationException(); }
   
   public boolean containsAll(Collection<?> c)
   { throw new UnsupportedOperationException(); }

   public <T> T[] toArray(T[] a)
   { throw new UnsupportedOperationException(); }
   

    
   
} // end-class 