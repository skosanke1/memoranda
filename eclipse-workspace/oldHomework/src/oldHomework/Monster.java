package oldHomework;
import Weapon;

// CSE 110     : Summer 2021 A
// Assignment  : <Assignment 07>
// Author      : Steven Kosanke, skosanke
// Description : <Monster program for Assignment 07>

class Monster {
	private String name; private Weapon weapon; 
	private int healthScore;

	public Monster(String name, int healthScore, Weapon weapon) 
	{
		this.name = name;
		this.healthScore = healthScore;
		this.weapon = weapon;	
	}
	
	
	public int getHealthScore()
	{
		return healthScore;
	}
	
	public String getName()
	{
		return name;
	}

	public String getWeaponName()
	{
		return weapon.getName();
	}
	
	public int attack(Monster opponent)
	{
		int damage = (int) (Math.random() * weapon.getMaxDamage());
		opponent.healthScore -= damage;
		return damage;
	}
}
