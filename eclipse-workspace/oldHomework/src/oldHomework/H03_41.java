package oldHomework;
import java.util.ArrayList;

//**************************************************************************************************
// CLASS: H03_41
//
// Recursive method that searches a part of a list for a keyword, 
// Returns -1 if the key was not found and the index value if it was found.
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************


public class H03_41 {
	/**
	 * This method input a string and will recursively reverse the order and return the reverse String.
	 */	
	public static int recLinearSearch(ArrayList<String> pList, String pKey, int pBeginIndex, int pEndIndex) {
	int foundItem = -1; 
	if (pBeginIndex <= pEndIndex) {
		String temp = pList.get(pBeginIndex);
		if (pKey.equals(temp)) {
			foundItem = pBeginIndex; }
		else {
			recLinearSearch(pList, pKey, pBeginIndex+1, pEndIndex);
		}}
	return foundItem;
	}	
}
