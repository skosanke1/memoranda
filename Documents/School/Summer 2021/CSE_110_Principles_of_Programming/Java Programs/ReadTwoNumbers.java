// Read an integer and a double with the
// help of several classes and methods from Java API instead of using the Scanner class

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadTwoNumbers
{
  public static void main( String[] args )
  {
    InputStreamReader bytesToChar = new InputStreamReader( System.in );
    BufferedReader keyboard = new BufferedReader( bytesToChar );
    String intAsString = "";
    String doubleAsString = "";

    try
    {
      System.out.print( "Enter an int: " );
      intAsString = keyboard.readLine( );
      System.out.print( "Enter a double: " );
      doubleAsString = keyboard.readLine( );
    }
    catch( IOException ioe )
    {
      System.out.println( "Could not read keyboard input: " + ioe );
    }

    int theInt = Integer.parseInt( intAsString );
    double theDouble = Double.parseDouble( doubleAsString );
    System.out.println( "int: " + theInt );
    System.out.println( "double: " + theDouble );
  }
}
