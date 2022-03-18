package oldHomework;
//**************************************************************************************************
// CLASS: H03_35
//
// Recursive method that will return a String that is the exact reverse of the input string.
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************


public class H03_35 {
	/**
	 * This method input a string and will recursively reverse the order and return the reverse String.
	 */	
public static void main(String[] args) {
String abc = "StevenKosanke";
String cba = reverse(abc);
System.out.println(cba);
}

	public static String reverse(String s) {
	if ((null == s) || (s.length() <= 1)) {
		return s; }
	return reverse(s.substring(1)) + s.charAt(0);
	}
}
