package oldHomework;
//**************************************************************************************************
// CLASS: H01_43
//
// Recursive method that will return a sum of integers from 1 to n.
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steve
 */
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
public class H01_43 {


public static void main(String args[]) {

//Open a scanner that will read the text file input, 
//save String name file1
Scanner scan = new Scanner(System.in);
System.out.println("Name of source file code?");
String file1 = scan.next();
String line = ""; int count = 1;


scan.close();

//Now start scanning the lines of file1, and transposing them to file temp.

//Initiate the Document Scanner, check for file readability
Scanner scandoc = null;

try {
	scandoc = new Scanner(file1);

//Initiate the Printer, check file writeability &
//Create a file output that can be written to
PrintWriter printer = null;
String fileoutput = file1 + ".txt";
File temp = new File (fileoutput);

try {
	printer = new PrintWriter(temp);
	
	while (scandoc.hasNextLine())
	{
	line = scandoc.nextLine();
	printer.print("[");
	String b = String.format("%03d", count);
	printer.print(b);
	printer.print("] ");
	printer.println(line);
	count++;
	}
	
	//Close all readers and writers still open
	printer.close();
	scandoc.close();

} catch (IOException e) {
	System.out.println("Sorry, Writing Exception Occured");
	System.exit(-200);
}
finally {
System.out.println("Sorry, IO Exception occured");
}

}
finally {
System.out.println("Sorry, IO Exception occured");

}}}
