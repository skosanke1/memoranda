package oldHomework;
import java.util.Scanner;

// CSE 110     : Summer 2021 A
// Assignment  : <Assignment 03>
// Author      : Steven Kosanke, skosanke
// Description : <Trading bot that determines whether a buy or sell is profitable>

import java.util.Scanner;
public class Assignment03 {

    public static void main(String[] args) {

    	
    	double transactionCost = 10;
    	double numberShares; double purchasePrice; double marketPrice; double totalFunds;
    	Scanner scan = new Scanner(System.in);
    	
    	//Input parameters numberShares, purchasePrice, marketPrice, totalFunds
    	System.out.println("Current Shares  :");
    	numberShares = scan.nextDouble(); 	   	
    	System.out.println("Purchase Price  :");	
    	purchasePrice = scan.nextDouble();    	
    	System.out.println("Market Price  :");	
    	marketPrice = scan.nextDouble(); 	   	
    	System.out.println("Available Funds  :");	
    	totalFunds = scan.nextDouble(); 
    	
    	
    	if (marketPrice < purchasePrice)
    	{ //If price has gone down, consider buying if value is greater than trade fee, otherwise hold
    		//New parameters to compare value of buying shares 
    		double totalBuyCost; double perShareBuyValue; 
    		double numberSharesBuy; double totalBuyValue;
    		numberSharesBuy = floor((totalFunds - 10) / marketPrice);
    		totalBuyCost = transactionCost + marketPrice * numberSharesBuy;
    		
    		perShareBuyValue = purchasePrice - marketPrice;
    		totalBuyValue = perShareBuyValue * numberSharesBuy;
    		
    		if (totalBuyValue > transactionCost)
    		{
    			System.out.print("Buy " + numberSharesBuy);
    			System.out.println(" shares");
    		}
    		else if (totalBuyValue <= transactionCost)
    		{
    			System.out.println("Hold Shares");
    		}
    		
    	}
    	
    	else if (marketPrice > purchasePrice)
    	{//If price has gone up, consider selling if value is greater than trade fee, otherwise hold
    		//New parameters to compare value of buying shares 
    		double perShareSellValue;

    		perShareSellValue = marketPrice - purchasePrice; 
    	
    		if (perShareSellValue * numberShares > transactionCost)
    		{
    			System.out.print("Sell " + numberShares);
    			System.out.println(" shares");
    		}
    		else if (perShareSellValue * numberShares <= transactionCost)
    		{
    			System.out.println("Hold Shares");
    		}
    	
    	
    	}
    		

    }

	private static double floor(double d) {
		double rounded;
		rounded = Math.floor(d);
		int output = (int) rounded;
		return output;
	}
}
