/*-------------------------------------------------------------
// AUTHOR: your name.
// FILENAME: title of the source file.
// SPECIFICATION: your own description of the program.
// FOR: CSE 110- Lab #6
// TIME SPENT: how long it took you to complete the assignment.
//-----------------------------------------------------------*/
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int numStudents = -1;
       int[] studentGroups = null;//arrays are objects
       double[] studentGrades = null;
       int numGroups = -1;  // Part 2
       //ask for number of students


       //initalize the array based on user input

	   //complete the code here for part 1

       // Part 2: Find the number of groups
       if (studentGroups[i] > numGroups)  {
               numGroups = studentGroups[i];
           }
       }

       // Print out the records
       // The code below is only for Part 2

       double[] groupAverages = new double[numGroups + 1];  // Avoid group 0
       int[] groupSizes = new int[numGroups + 1];  // Avoid group 0

       // For each student record,
       //   - find the group # and the grade, and
       //   - update groupAverages and groupSizes




       // Display the statistics of groups


       scanner.close();
    }
}
