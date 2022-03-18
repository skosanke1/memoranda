// Read the numbers from a file and compute the sum
// help of several classes and methods.

import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFromFile
{
  public static void main( String[] args )
  {
    //InputStreamReader bytesToChar = new InputStreamReader( System.in );

    String line;
    int inputLine, sum=0;

    try
    {
	  FileReader fr= new FileReader("numbers.txt");
	  Scanner in = new Scanner(fr);
	  line= in.nextLine();

      while (in.hasNextLine())
      {
		  line=in.nextLine();
		  inputLine = Integer.parseInt(line);
		 sum += inputLine;
       }

    }
    
    catch(IOException e)
    {	System.out.println("IO exception" + e);
    }

    System.out.println( "The sum is: " + sum );

  }
}
