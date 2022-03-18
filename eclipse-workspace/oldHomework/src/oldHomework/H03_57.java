package oldHomework;
import java.util.ArrayList;

//**************************************************************************************************
// CLASS: H03_57
//
// Recursive method that uses binary search to search for a keyword.  Instead of 
// traditional splitting in half, this method splits the search into 3 parts.
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************


public class H03_57 {

	/**
	 * Binary search but in thirds instead of halves
	 */	
	public static int ternarySearch(ArrayList<Integer> pList, Integer pKey, int pLow, int pHigh) {
		int searchResult = -1;
		int oneThirdIdx = (int)Math.round(pLow + (pHigh - pLow) / 3);
		int twoThirdIdx = (int) Math.round(pLow + (pHigh - pLow) / 1.333333333333);
		
		if (pKey.equals(pList.get(oneThirdIdx))) {
			searchResult = oneThirdIdx;
		}
		if (pKey.equals(pList.get(twoThirdIdx))) {
			searchResult = twoThirdIdx;
		}
		if (pKey < pList.get(oneThirdIdx)) {
			ternarySearch(pList, pKey, pLow, oneThirdIdx - 1);
		}
		if (pKey > pList.get(twoThirdIdx)) {
			ternarySearch(pList, pKey, twoThirdIdx+1, pHigh);
		}
		else {
			pLow = pLow + 1; pHigh = pHigh - 1;	
		}
		
		return searchResult; }
}
