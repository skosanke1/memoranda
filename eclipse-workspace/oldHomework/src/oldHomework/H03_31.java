package oldHomework;
//**************************************************************************************************
// CLASS: H03_31
//
// Recursive method that will return a sum of integers from 1 to n.
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************


public class H03_31 {
	/**
	 * This method inputs an integer, and will solve the sum from 1 to n recursively.
	 */	
public static int sumitoN(int n) {
	if (n <= 1) {
		return n; }
	return n + sumitoN(n-1);		
}

}