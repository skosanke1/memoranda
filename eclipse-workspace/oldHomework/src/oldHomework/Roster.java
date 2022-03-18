package oldHomework;
// CSE 110     : Summer 2021 A
// Assignment  : <Assignment 09 Roster>
// Author      : Steven Kosanke, skosanke
// Description : <This program helps initiate the roster class for assignment 9>
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Roster{
	//Array list of Player objects



	ArrayList<Player> players = new ArrayList<Player>();

	//Initiate the vriables
	String name = ""; int i = 0;
	String tempName = ""; double tempAttackStat; double tempBlockStat;
	double blockStatOne; double attackStatOne;
	double blockStatTwo; double attackStatTwo;
	String tempName1; String tempName2;
	Player attackerOne = new Player();
	Player attackerTwo = new Player();
	Player blockerOne = new Player(); Player blockerTwo = new Player();
	//Names the roster
	public Roster(String filename)
	{
		///This needs to open the document and scan the inputs
		
		try {
			Scanner scnr = new Scanner(new File(filename));
			while ((scnr.hasNext() ))
			{
					
				Player tem= new Player();
				tempName1 = scnr.next();
				tempName2 = scnr.next();
				tempAttackStat = scnr.nextFloat();
				tempBlockStat = scnr.nextFloat();
				tem.name = tempName1 + " " + tempName2;
			
				tempBlockStat =(double) Math.round(tempBlockStat*100) / 100;
				tem.attackStat = tempAttackStat;
				tem.blockStat = tempBlockStat;
				players.add(tem);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}
	
	public Roster()
	{

	}

//Methods addPlayer, countPlayers, getPlayerByName, printTopAttackers
// printTopBlockers, printAllPlayers	

public void addPlayer(String name, double attk, double block)
{
	Player temp= new Player();
	temp.name = name;
	temp.attackStat = attk;
	temp.blockStat = block;
	players.add(temp);

}

public int countPlayers()
{
return players.size();	
}

public void printTopAttackers()
{
	blockStatOne = 0; blockStatTwo = 0; attackStatOne = 0; attackStatTwo = 0;
	for (Player player : players)
	{
		
		if (player.attackStat > attackStatOne)
		{
			attackStatOne = player.attackStat;
			attackerTwo = attackerOne;
			attackerOne = player;
		}
		else if (player.attackStat > attackStatTwo)
		{
			attackStatTwo = player.attackStat;
			this.attackerTwo = player;
		}	
	}	
	System.out.println(attackerOne.name + " (attack = " + attackerOne.attackStat + ", block = " + attackerOne.blockStat + ")");
	System.out.println(attackerTwo.name + " (attack = " + attackerTwo.attackStat + ", block = " + attackerTwo.blockStat + ")");

}


public void printTopBlockers()
{
	blockStatOne = 0; blockStatTwo = 0; attackStatOne = 0; attackStatTwo = 0;
	for (Player player : players)
	{
		
		if (player.blockStat > blockStatOne)
		{
			blockStatOne = player.blockStat;
			blockerTwo = blockerOne;
			blockerOne = player;
		}
		else if (player.blockStat > blockStatTwo)
		{
			blockStatTwo = player.blockStat;
			this.blockerTwo = player;
		}	
	}	
	System.out.println(blockerOne.name + " (attack = " + blockerOne.attackStat + ", block = " + blockerOne.blockStat + ")");
	System.out.println(blockerTwo.name + " (attack = " + blockerTwo.attackStat + ", block = " + blockerTwo.blockStat + ")");

}


public void printAllPlayers()
{
for (Player player : players)
	{
		tempName = player.getName();
		tempAttackStat = player.getAttackStat();
		tempBlockStat = player.getBlockStat();
		System.out.println(tempName + " (attack = " + tempAttackStat + ", block = " +tempBlockStat + ")");
	}
	}


public Player getPlayerByName(String fullname)
{
	Player playername = new Player();
	for (Player player : players)
	{
	tempName = player.getName();
	if (tempName.equals(fullname))
	{
		playername = player;
	
	}
	
	}
	return playername;
}


}

