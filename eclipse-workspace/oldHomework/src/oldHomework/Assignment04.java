package oldHomework;
// CSE 110     : Summer 2021 A
// Assignment  : <Assignment 04>
// Author      : Steven Kosanke, skosanke
// Description : <Program that has a user guess a random 4 digit number, and tells them which digits are correct>
import java.util.Scanner;
import java.lang.Math;
public class Assignment04 {

    public static void main(String[] args) {
    	//Setting up variables, strings, doubles, and integers to initialize
    	Scanner scan = new Scanner(System.in);
    	String Response = new String ("yes");
    	double Guess = 0; int trial = 1; int score2 = 0; int choice;  
    	
    	 //Start of program, Response initialized at "yes", will repeat as long as user says yes 
   	 	while (Response.equals("yes"))
   	 	{
   	 		//Create a random 4 digit variable
   	 	double rand = Math.random();
   	 	double randomnumber = rand * 10000;
    	
    	System.out.print("Guess 1:");
    	Guess = scan.nextDouble();
    	
    	score2=0; //I initialized a scare variable inside and outside this while loop
    	
    	//repeat this as long as score is not 4
		while (score2 <= 3)
		{
    	int score = 0; double num1; double num2;
    	double math1; double math2;
    	score2 = score;
    	
    	//thousands place comparison calculation
    	num1 =Math.floor( Guess / 1000);
        num2 = Math.floor(randomnumber / 1000);
        if (num1 == num2)
		{
			score = score + 1;
			score2 = score;
		}
        
       //hundreds place comparison calculation
        math1 =Math.floor( Guess / 100);
        math1 = math1 %10;
        num1 =Math.floor(math1);        
        math2 =Math.floor( randomnumber / 100);
        math2 = math2 %10;
        num2 =Math.floor(math2); 
        if (num1 == num2)
		{
			score = score + 1;
			score2 = score;
        }        
        
        //tens place comparison calculation
        math1 =Math.floor( Guess / 10);
        num1 = math1 %10;
       
        math2 =Math.floor( randomnumber / 10);
        num2 = math2 %10;
 
        if (num1 == num2)
		{
			score = score + 1;
			score2 = score; 
		}        
        		
        //ones place comparison calculation

        math1 = Guess %10;
        math1 =Math.floor(math1);        
        //
        math2 = randomnumber %10;
        math2 =Math.floor(math2); 
        if (num1 == num2)
		{
			score = score + 1;
			score2 = score;
		}

        //if score  is less than 4, you try again
        if (score <= 3)
        {    
        System.out.print("You matched " + score);
        trial = trial + 1;
        System.out.print(". Guess " + trial);
        System.out.print(":");
    	Guess = scan.nextDouble();         	
        }       

		//If score is 4, you WIN
        if (score == 4)
        { 
		System.out.print("You guessed the right number in " + trial);
		System.out.println(" guesses.");
		System.out.println("Would you like to play again (yes/no)?");
		
		String u = scan.next();
		Response = u; 
    	//Go back to initial while loop
   	 	}}}
   	 	System.out.println("Thanks for playing!");
   	 	
    }}

