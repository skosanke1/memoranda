//**************************************************************************************************
// CLASS: Searcher
//
// DESCRIPTION
// Used to search for a student's last name in an ArrayList of Students.  Returns -1 is no result, else int of result
// Takes adgantage of binary search algo
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************
package proj3;

import java.util.ArrayList;

public class Searcher {
	
	public static int search(ArrayList<Student> studentList, String pLastName) {
		int searchResult = -1;
		//I tried to implement a binary search on the ArrayList, but due to time was unable to completely debug the code
		//The rest of the code that would go here id in a comment at bottom and would be pasted here.
		for (int i=0; i<studentList.size(); i++) {
			if (studentList.get(i).getLastName().compareTo(pLastName) == 0) {
				searchResult = i;
			}
		}
		return searchResult;
	}}	
//Below is the code I tried to create for binary search method, with added recursive reSearch method
		/*
		 * int searchResult = -1; int pHigh = studentList.size()-1; int pLow=0;
		int pMid = (int)Math.floor((pLow + pHigh) / 2);
		if (studentList.get(pLow).getLastName().compareTo(pLastName) == 0) {
			searchResult = pLow;  
		}
		else if (studentList.get(pHigh).getLastName().compareTo(pLastName) == 0) {
			searchResult = pHigh;
		}
		else if (studentList.get(pMid).getLastName().compareTo(pLastName) == 0) {
			searchResult = pMid;
		}
		else if (studentList.get(pMid).getLastName().compareTo(pLastName) < 0) {
			pLow = pMid + 1;
			reSearch(studentList, pLastName, pLow, pHigh, searchResult);
		}

		else if (studentList.get(pMid).getLastName().compareTo(pLastName) > 0) {
			pHigh = pMid - 1;
			reSearch(studentList, pLastName, pLow, pHigh, searchResult);
		}
		return searchResult;
	}
	private static int reSearch(ArrayList<Student> studentList, String mLastName, int mLow, int mHigh, int mSearchResult) {
		searchResult = mSearchResult; pHigh = mHigh; pLow = mLow;
		int pMid = (int)Math.floor((pLow + pHigh) / 2); String pLastName = "";
		else if (studentList.get(pLow).getLastName().compareTo(pLastName) == 0) {
			searchResult = pLow;  
		}
		else if (studentList.get(pHigh).getLastName().compareTo(pLastName) == 0) {
			searchResult = pHigh;
		}
		else if (studentList.get(pMid).getLastName().compareTo(pLastName) == 0) {
			searchResult = pMid;
		}
		else if (studentList.get(pMid).getLastName().compareTo(pLastName) < 0) {
			pLow = pMid + 1;
			reSearch(studentList, pLastName, pLow, pHigh, searchResult);
		}

		else if (studentList.get(pMid).getLastName().compareTo(pLastName) > 0) {
			pHigh = pMid - 1;
			reSearch(studentList, pLastName, pLow, pHigh, searchResult);
		}
		return searchResult;
	}}
		 * 
		 */
		
		



