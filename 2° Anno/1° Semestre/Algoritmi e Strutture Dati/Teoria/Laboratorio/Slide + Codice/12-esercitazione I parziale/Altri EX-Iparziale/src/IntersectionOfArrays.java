/*
 * Write a generic static method which accepts two arrays and returns a linked list
 * of all elements that are common to both arrays. Then use the method on the Integer type. 
 * The output should be sorted into decreasing order. 
 */


import java.util.*;

public class IntersectionOfArrays {

	
	public static <E extends Comparable<? super E>> LinkedList<E> createIntersectionList( E [ ] a,  E [ ] b) {	
		LinkedList<E> list = new LinkedList<E>();
		int i=0, j=0;
		Arrays.sort(a);
		Arrays.sort(b);
		while (i < a.length && j < b.length) {
			if (a[i].compareTo(b[j]) < 0) i++;
			else if (a[i].compareTo(b[j]) > 0) j++;
			else { // a[i] is equal to b[j]
				if (list.isEmpty() || ! a[i].equals(list.getFirst())) list.addFirst(a[i]); 
				i++; j++; 
			}
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		Integer[] a= {4, 15, 1, 10, 15, 12, 3};
		Integer[] b= {2, 25, 1, 12, 11, 15, 3};
		LinkedList<Integer> list = IntersectionOfArrays.<Integer>createIntersectionList(a, b);
		for (int i=0; i < a.length; i++) System.out.print(a[i] + " ");
		System.out.println();
		for (int i=0; i < b.length; i++) System.out.print(b[i] + " ");
		System.out.println();
		System.out.println(list);

	}

}