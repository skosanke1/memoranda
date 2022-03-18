package oldHomework;
/*-------------------------------------------------------------
  // AUTHOR: Steven Kosanke
  // FILENAME: Loop Switch Program
  // SPECIFICATION: Input a number to output either sum, factorial, or left digit
  // FOR: CSE 110-Lab #4
  // TIME SPENT: 3 hours 
//-----------------------------------------------------------*/

import java.util.Scanner;
public class Lab4 {
	
	
    private static void displayMenu() {
        System.out.println("Please choose one option from the following menu:");
        System.out.println("1) Calculate the sum of integers from 1 to m");
        System.out.println("2) Calculate the factorial of a given number");
        System.out.println("3) Display the leftmost digit of a given number");
        System.out.println("4) Quit");
    }
    
    public static void main(String[] args) {
    	
    	        Scanner scanner = new Scanner(System.in);
    	        int sumInt = 0, Factorial = 0, Number = 0;
    	        int choice = 0;
    	        do {
                	
    	            displayMenu();
    	            choice= scanner.nextInt();
    	           
    	            if ((choice >= 1) || (choice <= 4)) {
    	                if (choice == 1) 
    	                {System.out.println("Enter a number: ");
    	                int a= scanner.nextInt();
    	                int total = 1;
    	                for (int count = 2; count<=a; count++) {
    	                	total = total + count;
    	                }
    	                System.out.print("The sum of 1 to " + a);
    	                System.out.println(" is " + total);
    	                }
    	                
    	                }
    	                if (choice == 2) 
    	                {System.out.println("Enter a number: ");
    	                int b= scanner.nextInt();
    	                int factorial = 1;
    	                for (int counter = 2; counter<=b; counter++) {
    	                	factorial = factorial * counter;
    	                }
    	                
    	                System.out.println();
    	                System.out.print("The factorial of " + b);
    	                System.out.println(" is " + factorial);
    	                }
    	               
    	                if (choice == 3) 
    	                {System.out.println("Enter a number: ");
    	                int c= scanner.nextInt();
    	                int leftdigit = c;
    	                do {
    	                	leftdigit = leftdigit/10;
    	                }
    	                while (leftdigit >= 10 || leftdigit <= -10);

    	                System.out.println();
    	                System.out.print("The leftmost number of " + c);
    	                System.out.println(" is " + leftdigit);
    	                }
    	                
    	                if (choice == 4) {
    	                	System.out.println("Bye");
    	                	break;
    	                } 
    	            
    	            else {
    	            	System.out.println("Please enter a number between 1 and 4.");	
    	            }
    	            }while (choice != 4); 
    	        	scanner.close();
    	            }}
    	            