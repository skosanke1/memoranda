package oldHomework;
//------------------------------------------------------------
  // AUTHOR: Steven Kosanke
  // FILENAME: Name Counter Program
  // SPECIFICATION: Input your full name and outputs the number of characters
  // FOR: CSE 110-Lab #2
  // TIME SPENT: 2 hours 
  //-----------------------------------------------------------*/
import java.util.Scanner;

// class name should match the file name
public class Lab2 {
    // we must have a main method to run the program
    public static void main(String[] args) {

        // declare variables of different types:
        String firstName = "";
        String lastName = "";
        String fullName = "";
        int nameLength;
        Scanner scan = new Scanner(System.in);

        // Use Scanner to ask the user for first name
        System.out.println("Please enter first name: ");
        firstName = scan.nextLine();
        System.out.println("Please enter last name: ");
        lastName = scan.nextLine();

        fullName = firstName + " " + lastName;
        fullName = fullName.toUpperCase();
        
        System.out.println("Full Name (in capitals): " + fullName);
        
        // Print nameLength, this should be number of characters
        nameLength = firstName.length() + lastName.length() + 1;
        System.out.println("Length of Full Name: " +nameLength );

        // Define two String variables, title1 and title2 using String constructor to initialize them
        String title1 = new String("Cse110");
        String title2 = "Cse110";
        		if (title1 == title2) {
        			System.out.println("String comparison using == sign works.");
        		}else {
        			System.out.println("String comparison using == sign does NOT work.");
        		}
if (title1.equals(title2)) {
	System.out.println("String comparison using equals works.");
} else {
	System.out.println("String comparison using equals does not work.");
}
        
    } //end main method
} //end Lab2 class