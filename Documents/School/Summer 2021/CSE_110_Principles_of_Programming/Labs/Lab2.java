// All imports has to be outside class
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
        System.out.print("Please enter first name: ");
        firstName = scan.nextLine();
        // Use Scanner to ask the user for last name
        System.out.print("Please enter last name: ");
        lastName = scan.nextLine();

        // Add firstName to lastName variables using "+" sign, don't forget the space.
        // store the result in the fullName variable


        // Convert fullName variable to upper case

        // Find the length of fullName and store it


        // Print fullName, it should be in upper case

        // Print nameLength, this should be number of characters


        // Define two String variables, title1 and title2 using String constructor to initialize them


        // Compare the two strings and print which one of the two ways works

    } //end main method
} //end Lab2 class