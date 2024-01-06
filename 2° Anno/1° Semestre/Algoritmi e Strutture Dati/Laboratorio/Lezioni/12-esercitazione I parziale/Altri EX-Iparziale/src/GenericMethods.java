public class GenericMethods {

/**
 * Write a generic static method to find largest element in an array.
 * Then use the method on the Integer type.
 **/

public static <T extends Comparable<? super T>> T findMax( T [ ] a ) {
	int maxIndex = 0;

	for( int i = 1; i < a.length; i++ )
		if( a[i].compareTo( a[maxIndex] ) > 0 ) maxIndex = i;

	return a[ maxIndex ];
}

/**
  * Write a generic static method which accepts an array and returns the
  * smallest item. Then use the method on the String type.
 **/

public static <T extends Comparable<? super T>> T findMin( T [ ] a ) {
	T min = a[0];

	for( int i = 1; i < a.length; i++ )
		if( a[i].compareTo( min ) < 0 ) min = a[i];

	return min;
}

public static void main(String[] args) {
	Integer[] arrayOfInt = {13, 15, 2, 100, 45, 245, 24, 2};
	Integer x = GenericMethods.<Integer>findMax(arrayOfInt);
	System.out.println("Max: " + x);
	
	String[] arrayOfString = {"Exam", "Algorithm", "Laboratory", "Class"};
	String s = GenericMethods.<String>findMin(arrayOfString);
	System.out.println("Min: " + s);
	
}
	

} //end-class
