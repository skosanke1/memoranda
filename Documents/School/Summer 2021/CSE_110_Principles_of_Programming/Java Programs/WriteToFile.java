// write integers from 1 to 100 in separate line in a file named "numbers.txt"
// help of several classes and methods.
// we are throwing the IOException instead of catching it 

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class WriteToFile 
{
  public static void main( String[] args )throws IOException
  {
    //InputStreamReader bytesToChar = new InputStreamReader( System.in );
   
    String line;
    int inputLine, sum=0;
    
    FileWriter fw= new FileWriter("numbers.txt");
    BufferedWriter bw = new BufferedWriter( fw );
    PrintWriter outFile = new PrintWriter(bw);
	  
    for(int index=0; index<=100; index++)
	    outFile.println(index);
	  
     outFile.close();	 
    
  }
}
