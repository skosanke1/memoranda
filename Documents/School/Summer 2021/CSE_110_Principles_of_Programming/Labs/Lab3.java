/*-------------------------------------------------------------
// AUTHOR: your name.
// FILENAME: title of the source file.
// SPECIFICATION: your own description of the program.
// FOR: CSE 110- Lab #3
// TIME SPENT: how long it took you to complete the assignment.
//-----------------------------------------------------------*/

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        // This scanner is prepared for you to get inputs
        Scanner scanner = new Scanner(System.in);
        // Declare three variables for HW, midterm, and final exam grades
        // -->
        // Declare a loop control variable i
        // -->

        while (/* Put in the condition involving i */) {
            // Design if-else control flow:
            //
            // if i is 0, asks for the homework grade
            // if i is 1, asks for the midterm exam grade
            // if i is 2, asks for the final exam grade
            //
            // You have to let the user re-try if any of the inputs is invalid.
            // - homework grade is in [0, 100]
            // - midterm grade is in [0, 100]
            // - final exam grade is in [0, 200]
            //
            // The first if-else statement is attached for your reference. You have to
            // finish the last two statments by yourself.
            // -->

            if (i == 0) {
                // Ask the user for homework grade
                // -->

                // Do input validation
                // -->
                if (/* the HW grade is not valid */) {
                    // Show the error message
                    // -->
                } else {
                    // Update the loop variable
                    // -->
                }
            }

            // The other two if-else statments go here
            // -->
        }

        // Calculate the weighted total by the formula showed in the PDF
        // -->
        double weighted_total = ...;

        // Show the weighted total and tell the user s/he passed or not
        // -->
        if (/* ... */) {
            // Print "the student PASSED the class."
        } else {
            // Print "the student FAILED the class."
        }

        scanner.close();

    }  // End of main
}  // End of class
