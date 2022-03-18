 //------------------------------------------------------------
 * // AUTHOR: Steven Kosanke
 * // FILENAME: Test Averages
 * // SPECIFICATION: Takes 3 test scores and outputs the final average.
 * // FOR: CSE 110-Lab #1
 * // TIME SPENT: HOW LONG IT TOOK YOU TO FINISH THIS LAB 
 * //-----------------------------------------------------------*/
package Test;

public class test 
{
	public static void main(String[] args) 
	{
		double test1 = 0;
		double test2 = 0;
		double test3 = 0;
		final double NUM_TESTS = 3;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Plz input test 1 score:");
		test1 = keyboard.nextDouble();
		System.out.println("Your test 1 is " + test1);
		
		System.out.println("Plz input test 2 score:");
		test2 = keyboard.nextDouble();
		System.out.println("Your test 2 is " + test2);
		
		System.out.println("Plz input test 3 score:");
		test3 = keyboard.nextDouble();
		System.out.println("Your test 3 is " + test2);
		// -->
		
		double avg;
		avg = (test1 + test2 + test3) / NUM_TESTS;
		System.out.println("Your avg is " + avg);
		
	}
}
