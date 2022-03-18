package oldHomework;
// CSE 110     : Summer 2021 A
// Assignment  : <Assignment 09 Player>
// Author      : Steven Kosanke, skosanke
// Description : <Program that creates player objects for assignment 9>


public class Player
{
	//Variables name, attackStat, blockStat
	String name = ""; double attackStat = 0; double blockStat = 0;

	//Constructor (name, attack, block)
	public Player(String namein, double attackin, double blockin)
	{
		this.name = namein;
		this.attackStat = attackin;
		this.blockStat = blockin;
	}
	public Player()
	{
		
	}

	//Methods public getName, getAttackStat,setAttackStat, getBlockStat
	// setBlockStat, printPlayerInfo
	public String getName()
	{
		return name;
	}
	
	public double getPlayerByName()
	{
		return attackStat;
	}
	
	public double getAttackStat()
	{
		return attackStat;
	}
	
	public void setAttackStat(double stat)
	{
		this.attackStat = stat;
	}
	
	public double getBlockStat()
	{
		return blockStat;
	}
	
	public void setBlockStat(double stat)
	{
		this.blockStat = stat;
	}
	
	public void printPlayerInfo()
	{
		System.out.print(name + " (attack = " + attackStat);
		System.out.print(", block = " + blockStat);
	}
}
