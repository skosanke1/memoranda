package oldHomework;
/*-------------------------------------------------------------
  // AUTHOR: Steven Kosanke
  // FILENAME: Shape Building Program
  // SPECIFICATION: User inputs group number and grades and the program outputs the group averages and group sizes
  // FOR: CSE 110-Lab #6
  // TIME SPENT: 3 hours 
//-----------------------------------------------------------*/
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
      
       //Initialize variables
       int numStudents = -1;
       int[] studentGroups = null;//arrays are objects
       double[] studentGrades = null;
       int numGroups = -1;  // Part 2
      
       //ask for number of students
   		System.out.print("Number of Students:");
   		numStudents = scanner.nextInt();

       //initalize the array based on user input
   		studentGroups = new int[numStudents];
   		studentGrades = new double[numStudents];
   		int i = 0;
   		
   		//input grades in order
   		for (i = 1; i <= studentGroups.length; i++)
   		{
   		int studentgroupnumber; double studentgrade = 0;
   		System.out.print("Input student " + i);
   		System.out.print(" group number ");
   		studentgroupnumber= scanner.nextInt();
   		studentGroups[i-1] = studentgroupnumber;
   		System.out.print("Input student " + i);
   		System.out.print(" grade");
   		studentgrade = scanner.nextDouble();
   		studentGrades[i-1] = studentgrade;
   		
   		
   		// Part 2: Find the number of groups
   		if (studentGroups[i-1] > numGroups)  {
               numGroups = studentGroups[i-1];
           }}
       
        // Print out the records
        // The code below is only for Part 2
   		int j;
   		System.out.println("==== List of Student Records =====");
   		for (j=0; j< studentGroups.length; j++) 
   		{
   		System.out.print("Group " + studentGroups[j]);
   		System.out.print(" - " + studentGrades[j]);
   		System.out.println(" Points");
   		}
   		
        double[] groupAverages = new double[numGroups + 1];  // Avoid group 0
        int[] groupSizes = new int[numGroups + 1];  // Avoid group 0
    	int grouptemp; int k; int grouptemp1;

    //This is the second part of the Lab, optional part
    for (k=0; k<numStudents; k++ )
    {	
    	grouptemp = studentGroups[k];
    	groupSizes[grouptemp] = groupSizes[grouptemp]+1;
    	groupAverages[grouptemp] = studentGrades[k]/(groupSizes[grouptemp]) + groupAverages[grouptemp]*(groupSizes[grouptemp]-1)/(groupSizes[grouptemp]);
    }

    //Display part 2 results
    int l; int groupnumber;
		System.out.println("==== Group Statistics ===");
		for (j=0; j< groupSizes.length-1; j++) 
		{
			groupnumber = j+1;
		System.out.print("Group #" + groupnumber);
		System.out.print(" has " + groupSizes[j+1]);
		System.out.print(" students, average is "+ groupAverages[j+1]);
		System.out.println();

		}
    scanner.close();
    }  

       


  }
