/*-------------------------------------------------------------
// AUTHOR: your name.
// FILENAME: title of the source file.
// SPECIFICATION: your own description of the program.
// FOR: CSE 110- Lab #4
// TIME SPENT: how long it took you to complete the assignment.
//-----------------------------------------------------------*/

// Import Scanner class

public class Lab4 {

    public static void main(String[] args) {
        // Declare some variables you need
        // -->

        do {
            // Display the menu
            displayMenu();

            // Ask the user for one option
            // -->

            switch (?????) {
                // Define four cases for different options. Don't forget "break".
                // -->
            }
        } while (?????);

    }

    /**
     * Print the menu
     */
    private static void displayMenu() {
        System.out.println("Please choose one option from the following menu:");
        System.out.println("1) Calculate the sum of integers from 1 to m");
        System.out.println("2) Calculate the factorial of a given number");
        System.out.println("3) Display the leftmost digit of a given number");
        System.out.println("4) Quit");
    }
}