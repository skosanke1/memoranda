// Name: ...
// filename: ...
import java.util.Scanner;

public class Lab1 
{
	public static void main(String[] args) 
	{
		double test1 = 0;
		double test2;
		double test3;
		final double NUM_TESTS = 3;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Plz input test 1 score:");
		test1 = keyboard.nextDouble();
		System.out.println("Your test 1 is " + test1);
		
		System.out.println("Plz input test 2 score:");
		test2 = keyboard.nextDouble();
		System.out.println("Your test 2 is " + test2);
		
		System.out.println("Plz input test 3 score:");
		// -->
		
		double avg;
		avg = (test1 + test2) / NUM_TESTS;
		System.out.println("Your avg is " + avg);
		
	}
}
