//**************************************************************************************************
// CLASS: Sorter
//
// DESCRIPTION
// Take an ArrayList<Student> and search it by last name alphabetically
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************
package proj3;

import java.util.ArrayList;

public class Sorter {

	/* This function takes last element as pivot, places
	   the pivot element at its correct position in sorted
	   array, and places all smaller (smaller than pivot)
	   to left of pivot and all greater elements to right
	   of pivot */
	static int partition(ArrayList<Student> pList, int pLow, int pHigh)
	{
	    String pivot = pList.get(pHigh).getLastName();
	    int i = (pLow - 1);
	    for(int j = pLow; j <= pHigh - 1; j++)
	    {
	         
	        // If current element is smaller
	        // than the pivot
	    	String tempLast = "";
	    	tempLast = pList.get(j).getLastName();
	        if (tempLast.compareTo(pivot) < 0) 
	        {
	             
	            // Increment index of
	            // smaller element
	            i++;
	            swap(pList, i, j);
	        }
	    }
	    swap(pList, i + 1, pHigh);
	    return (i + 1);
	}
	
	/* Function that implements QuickSort
*/
static void quickSort(ArrayList<Student> pList, int pLow, int pHigh) {
if (pLow < pHigh)
{
  int pi = partition(pList, pLow, pHigh);
  quickSort(pList, pLow, pi - 1);
  quickSort(pList, pi + 1, pHigh);
}}
	
public static void sort(ArrayList<Student> pList) {
	quickSort(pList, 0, pList.size()-1);	
}
	

static void swap(ArrayList<Student> pList, int i, int j)
{
    Student temp = pList.get(i);
    pList.set(i,pList.get(j));
    pList.set(j, temp);
}

}