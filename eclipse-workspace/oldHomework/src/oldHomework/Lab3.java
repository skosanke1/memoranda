package oldHomework;
//------------------------------------------------------------
  // AUTHOR: Steven Kosanke
  // FILENAME: Course Grader
  // SPECIFICATION: Input three course grades and calculated weighted average
  // FOR: CSE 110-Lab #3
  // TIME SPENT: 3 hours 
  //-----------------------------------------------------------*/

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        // This scanner is prepared for you to get inputs
        Scanner in = new Scanner(System.in);
        // Declare three variables for HW, midterm, and final exam grades
        int homework = 0;
        int midterm = 0;
        int finalgrade = 0;
        int i = 0;
        while (i < 3) {
           

            if (i == 0) {
            	System.out.println("Enter the homework grade: ");
            	int hw = in.nextInt();
                if (hw > 100 || hw < 0) {
                	System.out.println("Please enter a grade between 0-100.");

                } else {
                	homework = hw;
                	i = i + 1;
                }
            }
            if (i == 1) {
            	System.out.println("Enter the midterm grade: ");
            	int mid = in.nextInt();
                if (mid > 100 || mid < 0) {
                	System.out.println("Please enter a grade between 0-100.");

                } else {
                	midterm = mid;
                	i = i + 1;
                }
            }
            if (i == 2) {
            	System.out.println("Enter the final grade: ");
            	int fin = in.nextInt();
                if (fin > 200 || fin < 0) {
                	System.out.println("Please enter a grade between 0-200.");

                } else {
                	finalgrade = fin;
                	i = i + 1;
                }
            }
        }

        // Calculate the weighted total by the formula showed in the PDF
        // -->
        double weighted_total = (finalgrade /2 * .5) + (midterm * .25) + (homework * .25);
        System.out.println("The student's weighted total is: "  + weighted_total);
        // Show the weighted total and tell the user s/he passed or not
        // -->
        if (weighted_total >= 50 ) {
        	System.out.println("The student PASSED the class.");
        } else {
        	System.out.println("The student FAILED the class.");
        }

        in.close();

    }  // End of main
}  // End of class
