package oldHomework;
// CSE 110     : Summer 2021 A
// Assignment  : <Assignment 06>
// Author      : Steven Kosanke, skosanke
// Description : <Program contains public static methods that can alter or analyze arrays>

public class Assignment06 {

    public static void main(String[] args) {
        // Write any code here that you may wish to test your methods defined below.

    }
    
    // 1) Write a public static method named printArray, 
    //   that takes two arguments. The first argument is an Array of int 
    //   and the second argument is a String. The method should print out 
    //   a list of the values in the array, each separated by the value of the second argument.
    public static void printArray(int g[], String b)
    {
   
        	int length = g.length; int i; 
        	for (i=0 ; i<length-1 ; i++)
        	{
        		System.out.print(g[i] + b);
        	}
        	System.out.print(g[i] );
    }
    
    // 2) Write a public static method named getFirst, 
    //    that takes an Array of int as an argument and returns 
    //    the value of the first element of the array.
    public static int getFirst(int x[])
    {
    	return x[0];
    }
    
    // 3) Write a public static method named getLast, 
    //    that takes an Array of int as an argument and returns 
    //    the value of the last element of the array.
    public static int getLast(int y[])
    {
    	int length = y.length;
    	return y[length-1];
    }
    
    // 4) Write a public static method named getAllButFirst, 
    //    that takes an Array of int as an argument and creates and returns 
    //    a new array with all of the values in the argument array except the first value.
    public static int[] getAllButFirst(int z[])
    {
    	int length = z.length; int i; int[] newArray = new int[z.length-1];
    	for (i=1 ; i<length ; i++)
    	{
    		newArray[i-1] = z[i];
    	}
    	return newArray;
    }
    
    // 5) Write a public static method named getIndexOfMin, 
    //    that takes an Array of int as an argument and returns 
    //    the index of the least value in the array.
    public static int getIndexOfMin(int a[])
    {
    	int length = a.length; int i; int minimum = a[0]; int index = 0;
    	for (i=1 ; i<length ; i++)
    	{
    		if (minimum > a[i])
    		{
    			minimum = a[i];
    			index = i;
    		}
    	}
    	return index;
    }
    
    // 6) Write a public static method named getIndexOfMax, 
    //    that takes an Array of int as an argument and returns 
    //    the index of the largest value in the array.
    public static int getIndexOfMax(int b[])
    {   
    	int length = b.length; int i; int maximum = b[0]; int index = 0;
    	for (i=1 ; i<length ; i++)
    	{
    		if (maximum < b[i])
    		{
    			maximum = b[i];
    			index = i;
    		}
    	}
    	return index;
    }   
    // 7) Write a public static method named swapByIndex, 
    //    that takes three arguments. The first argument is an Array of int, 
    //    and the second and third arguments are int indexes. 
    //    This method will swap the values at the two given index arguments 
    //    in the array, and return a reference to the array.
    public static int[] swapByIndex(int c[], int a, int b)
    {
    	int temp = c[a];
    	c[a] = c[b];
    	c[b] = temp;
    	return c;
    }
    
    //8) Write a public static method named removeAtIndex, 
    //  that takes two arguments. The first argument is an Array of int, 
    //  and the second argument is an int index. This method create and return 
    //  a new array with all of the values in the argument array 
    //  except the value at the argument index.
    public static int[] removeAtIndex(int d[], int a)
    {
    	int length = d.length; int i;int j=0; int[] newArray = new int[d.length-1];
    	for (i=0 ; i<length ; i++)
    	{
    		if(i != a)
    		{
    		newArray[j] = d[i];	
    		j++;
    		}
    			
    	}
    	return newArray;
    }  
    
    //9) Write a public static method named insertAtIndex, 
    //   that takes three arguments. The first argument is an Array of int, 
    //   the second argument is an int index, and the third argument is an int value. 
    //   This method create and return a new array with all of the values 
    //   in the argument array and including the third argument value 
    //   inserted at the index specified by the second argument value.
    public static int[] insertAtIndex(int e[], int b, int x)
    {
    	int length = e.length; int i;int j=0; int[] newArray = new int[e.length+1];
    	for (i=0 ; i<length ; i++)
    	{
    		if(i != b)
    		{
    		newArray[j] = e[i];	
    		j++;
    		}
    		else
    		{
    			newArray[j] = x; 
    			newArray[j+1] = e[i];
    			j = j+2;
    				
    		}
    			
    	}
    	if (newArray[length] == 0)
    	{
    		newArray[length] = x;
    	}
    	return newArray;
    }  
    //*****This part doesnt work when the insertion is at the end of array*****//
    
    
    //10) Write a public static method named isSorted, 
    //    that takes an Array of int as an argument. 
    //    This method should return the boolean value true 
    //    if all the element values in the array are in ascending order; 
    //    otherwise the method should return the boolean value false.
    public static boolean isSorted(int f[])
    {
    	int length = f.length; int i; boolean result = true;
    	for (i=1 ; i<length ; i++)
    	{
    		if(f[i] < f[i-1])
    		{
    		result = false;
    		}
    			
    	}
    	return result;
    }  
    

}
