package oldHomework;
// CSE 110     : Summer 2021 A
// Assignment  : <Assignment 05>
// Author      : Steven Kosanke, skosanke
// Description : <Program that contains numerous methods that compare inputs and display or return analyzed results>

public class Assignment05 {

    public static void main(String[] args) {
        // Codes below will test your methods:
        displayGreeting();
        displayText("test");
        printTotal(1,2,3);
        int total = getTotal(1,2,3);
        System.out.println(total);
        double average= getAverage(1,2,3);
        System.out.println(average);
        average= averageLength("test","test21", "testtest");
        System.out.println(average);
        int shortest = lengthOfShortest("test","test21");
        System.out.println(shortest);
        String stars=stringOfStars("test");
         System.out.println(stars);
        stars=maxStringOfStars("test","test21");
        System.out.println(stars);
        stars=midStringOfStars("test","test21", "testtest");
        System.out.println(stars);

    }
     
    //  When this function is called, it should print the text "Hello, and welcome!".
    public static void displayGreeting()
    {
    	System.out.println("Hello, and welcome!");
    }
   
    //  When this function is called, it should print the value of the argument that was passed to it.
    public static void displayText(String text)
    {
    	System.out.println(text);
    }    
     
    //  When this function is called, it should print the sum of the three arguments passed to it. 
    public static void printTotal(int x,int y,int z)
    {
    	int total = x + y + z;
    	System.out.println(total);
    }
     
    //  When this function is called, it should return the sum of the three arguments passed to it as an int.
    public static int getTotal(int a, int b, int c)
    {
    	int total = a + b + c;
    	return total;
    }
    
    //  When this function is called, it should return the average of the three arguments passed to it as a double. 
    public static double getAverage(int a, int b, int c)
    {
    	double total = (a + b + c) / 3;
    	return total;
    }
    
    //6) Write (define) a static method named averageLength, 
    //  that takes three String arguments. 
    //  When this function is called, it should return the average length (number of characters) 
    //  of the String arguments passed to it as a double.
    public static double averageLength(String a, String b,String c)
    {
    	double avg = ((a.length() + b.length() + c.length()));
    	avg = avg / 3;
    	return avg;
    }
    
    //When this function is called, it should return the length (number of characters) of the shortest String argument passed to it as an int.

    public static int lengthOfShortest(String a, String b)
    {
    	if (a.length() < b.length())
    		return a.length();
    	else
    		return b.length();
    }
    
    //8) Write (define) a static method named stringOfStars, 
    //  that takes one String argument.
    //  When this function is called, it should return a String of asterisks (*) 
    //  that is the same length as the string argument passed to it.
    public static String stringOfStars(String a)
    {
    	int length = a.length(); String result = "*"; int i=1;
    	while (i < length)
    	{
    		result = result + "*";
    		i = i + 1;
    		
    	}
    	return result;
    		
    }
    
    public static Object i(int length, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	//9) Write (define) a static method named maxStringOfStars, 
    //  that takes two String arguments. 
    //  When this function is called, it should return a String of asterisks (*) 
    //  that is the same length as the longest string argument passed to it.
    public static String maxStringOfStars(String a, String b)
    {
    	if (a.length() > b.length())
    	{
    		int length = a.length(); String result = "*"; int i=1;
    	
    		while (i < length)
    			{
    				result = result + "*";
    				i = i + 1;
    			}
    	return result;
    	}
    	else
    	{
        	int length = b.length(); String result = "*"; int i=1;
        	while (i < length)
        	{
        		result = result + "*";
        		i = i + 1;
        		
        	}
        	return result;	
    	}}
    
   
    
    //////////////////////////////////////////////////////////////////////////////
    //   When this function is called, it should return a String of asterisks (*) that is the same length as the string argument with the length that would be in the middle if the lengths of the arguments were arranged in ascending order.    
    public static String midStringOfStars(String a, String b, String c)
{String result = "*";
	if (a.length() > b.length() && a.length() < c.length())
	{int length = a.length(); int i=1;
	//b < a < c
			while (i < length)
				{
					result = result + "*";
					i = i + 1;
				}
		
		
	}

	else if (a.length() < b.length() && a.length() > c.length())
	{	//c < a < b

			int length = a.length(); int i=1;
			while (i < length)
				{
					result = result + "*";
					i = i + 1;
				}

	}
	
	else if (b.length() < a.length() && b.length() > c.length())
	{	//c < b < a
			int length = b.length(); int i=1;
			while (i < length)
				{
					result = result + "*";
					i = i + 1;
				}	
	} 
	
	else if (b.length() < c.length() && b.length() > a.length())
	{	//a < b < c

			int length = b.length(); int i=1;
			while (i < length)
				{
					result = result + "*";
					i = i + 1;
				}	
	}
	//C is mid
	else if (c.length() < a.length() && c.length() > b.length())
	{
		
			int length = c.length(); int i=1;
			
			while (i < length)
				{
					result = result + "*";
					i = i + 1;
				}

		
	}	
	else if (c.length() < b.length() && c.length() > a.length())
	{
		
			int length = c.length(); int i=1;
			
			while (i < length)
				{
					result = result + "*";
					i = i + 1;
				}

		
	}return result;}	
}
