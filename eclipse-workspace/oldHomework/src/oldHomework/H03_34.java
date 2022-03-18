package oldHomework;
//**************************************************************************************************
// CLASS: H03_34
//
// Recursive method that will return a sum of integers from 1 to n.
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************


public class H03_34 {
	/**
	 * This method input a double x which will be recursively multiplied by itself 
	 * n number of times.
	 */	
public static double power(double x, int n) {
	if (n < 0) {
		System.out.println("exponent must be positive");}
	if (n == 0) {
		return 1; }
	else {		
	return x * power(x, n-1); }
}

}