package oldHomework;
// CSE 110     : Summer 2021 A
// Assignment  : <Assignment 07>
// Author      : Steven Kosanke, skosanke
// Description : <Weapon program for Assignment 7

class Weapon {

	private String name; private int maxDamage;
	
	public Weapon(String name, int maxDamage)
	{
		this.name = name;
		this.maxDamage = maxDamage;	
	}
	
	public Weapon()
	{
		this.name = "Pointy Stick";
		this.maxDamage = 1;	
		
	}
	
	public String getName()
	{
		return name;
	}
	public int getMaxDamage()
	{
		return maxDamage;
	}
	public void setName(String abc)
	{
		this.name = abc;
	}
	public void setMaxDamage(int xyz)
	{
		
		this.maxDamage = xyz;
	}
}
