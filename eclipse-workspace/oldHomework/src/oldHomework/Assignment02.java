package oldHomework;
// CSE 110     : Summer 2021 A
// Assignment  : <Assignment 02>
// Author      : Steven Kosanke, skosanke
// Description : <Computes materials needed and cost for a road building project >

import java.util.Scanner;

public class Assignment02 {
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);

    	double length = 0;
    	int lanes = 0;
    	int depth = 0;
    	int days_to_complete = 0;
    	
    	
    	
    	System.out.println("Length of road project (miles)  :");	//Must be +
    	length = scan.nextDouble(); 	//units miles
    	System.out.println("Number of lanes                 :");	//Must be between 1-4
    	lanes = (int) scan.nextDouble();	//integer
    	System.out.println("Depth of asphalt (inches)       :");	//Must be +, cannot be 0
    	depth = (int) scan.nextDouble();	//units inches
    	System.out.println("Days to complete project        :");	//Must be +
    	days_to_complete = (int) scan.nextDouble();	//units days
    	
    	double truckwt = 10000;		//units lbs/truck
    	double roadwidth = 12;		//units ft
    	double conduit = Math.ceil(length*5280/24);	//integer round up
    	double conduit_cost = conduit * 500;	//500$/piece
    	double densityroad = 150; 	//units lbs/ ft^3
    	
    	double weightroad = roadwidth * lanes * length * 5280 * depth * densityroad/ 12;		//5280 feet/mile
    	double road_cost = weightroad / 2000 * 200; //2000 lbs/ton and 200$ / ton
    	double numbertruck = Math.ceil(weightroad / truckwt); 	//round up
        
    	double stoplight = Math.floor(length) * (2+ lanes);
    	double stoplight_cost = stoplight * 25000;
    	double crew = Math.ceil(50 * (length) * lanes / days_to_complete);
    	double crew_cost = days_to_complete * crew *8*25; //8 hours/day and 25$/hr*worker
    	double totalcost = crew_cost + conduit_cost + stoplight_cost + road_cost;
        // compute required values
      
        
        // display results
	
	System.out.println();
System.out.println("=== Amount of materials needed ===");
System.out.println("Truckloads of Asphalt  : " + numbertruck);
System.out.println("Stoplights             : " + stoplight);
System.out.println("Conduit pipes          : " + conduit);
System.out.println("Crew members needed    : " + crew);
System.out.println("=== Cost of Materials ===");
System.out.println("Cost of Asphalt        : $" + road_cost);
System.out.println("Cost of Stoplights     : $" + stoplight_cost);
System.out.println("Cost of Conduit Pipes  : $" + conduit_cost);
System.out.println("Cost of Labor          : $" + crew_cost);
System.out.println("=== Total Cost of Project ===");
System.out.println("Total cost             : $" + totalcost);


    }
}
