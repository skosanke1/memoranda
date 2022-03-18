package oldHomework;
//------------------------------------------------------------
  // AUTHOR: Steven Kosanke
  // FILENAME: Test Averages
  // SPECIFICATION: Takes 3 test scores and outputs the final average.
  // FOR: CSE 110-Lab #1
  // TIME SPENT: 2 hours 
  //-----------------------------------------------------------*/

import java.util.Scanner;
public class Lab1 {

	public static void main(String[] args) {
			double test1 = 0;
			double test2 = 0;
			double test3 = 0;
			final double NUM_TESTS = 3;
			
			
			Scanner keyboard = new Scanner(System.in);
			
			System.out.println("Enter the score for the first test:");
			test1 = keyboard.nextDouble();
			System.out.println("Your test 1 is " + test1);
			
			System.out.println("Enter the score for the second test:");
			test2 = keyboard.nextDouble();
			System.out.println("Your test 2 is " + test2);
			
			System.out.println("Enter the score for the third test:");
			test3 = keyboard.nextDouble();
			System.out.println("Your test 3 is " + test3);
			
			double avg;
			avg = (test1 + test2 + test3) / NUM_TESTS;
			System.out.println("Your average score is " + avg);
			
	}

}