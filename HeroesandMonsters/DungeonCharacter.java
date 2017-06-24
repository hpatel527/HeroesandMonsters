package refactored;

import java.io.Serializable;

/**
 * Title: DungeonCharacter.java
 *
 * Description: Abstract Base class for inheritance hierarchy for a
 *              role playing game
 *
 *  class variables (all will be directly accessible from derived classes):
 *    name (name of character)
 *    hitPoints (points of damage a character can take before killed)
 *    attackSpeed (how fast the character can attack)
 *    chanceToHit (chance an attack will strike the opponent)
 *    damageMin, damageMax (range of damage the character can inflict on
 *     opponent)
 *
 *  class methods (all are directly accessible by derived classes):
 *    DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	  public String getName()
	  public int getHitPoints()
	  public int getAttackSpeed()
	  public void addHitPoints(int hitPoints)
	  public void subtractHitPoints(int hitPoints) -- this method will be
	    overridden
	  public boolean isAlive()
	  public void attack(DungeonCharacter opponent) -- this method will be
	    overridden
 *
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

//HARI PATEL && ALEX PRICE

public abstract class DungeonCharacter implements Comparable, Serializable,Attack
{

	protected String name;
	protected  String className;
	protected int hitPoints;
	protected  int attackSpeed;
	protected  double chanceToHit;
	protected  int damageMin, damageMax;
	protected int numTurns;
	

	public int compareTo(Object o)
	{
		return 1;
	}

//-----------------------------------------------------------------
//explicit constructor to initialize instance variables -- it is called
// by derived classes
	public DungeonCharacter(String className, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	{

		this.className = className;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;

	}//end constructor

//-----------------------------------------------------------------
	public String getName()
	{
		return name;
	}//end getName

	public String getClassName()
	{
		return className;
	}
//-----------------------------------------------------------------
	public int getHitPoints()
	{
		return hitPoints;
	}//end getHitPoints
//-----------------------------------------------------------------
	public int getAttackSpeed()
	{
		return attackSpeed;
	}//end getAttackSpeed


/*-------------------------------------------------------
addHitPoints is used to increment the hitpoints a dungeon character has

Receives: number of hit points to add
Returns: nothing

This method calls: nothing
This method is called by: heal method of monsters and Sorceress
---------------------------------------------------------*/
	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			this.hitPoints += hitPoints;
			//System.out.println("Remaining Hit Points: " + hitPoints);

		}
	}//end addHitPoints method

/*-------------------------------------------------------
subtractHitPoints is used to decrement the hitpoints a dungeon character has.
It also reports the damage and remaining hit points (these things could be
done in separate methods to make code more modular ;-)

Receives: number of hit points to subtract
Returns: nothing

This method calls: nothing
This method is called by: overridden versions in Hero and Monster
---------------------------------------------------------*/
	public void subtractHitPoints(int hitPoints)
	{
		if (hitPoints <0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints >0)
		{
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(getName() + " has been hit " +
								" for <" + hitPoints + "> points damage.");
			System.out.println(getName() + " now has " +
								getHitPoints() + " hit points remaining.");
			System.out.println();
		}//end else if

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");


	}//end method

/*-------------------------------------------------------
isAlive is used to see if a character is still alive by checking hit points

Receives: nothing
Returns: true is hero is alive, false otherwise

This method calls: nothing
This method is called by: unknown (intended for external use)
---------------------------------------------------------*/
    public boolean isAlive()
	{
	  return (hitPoints > 0);
	}//end isAlive method

/*-------------------------------------------------------
attack allows character to attempt attack on opponent.  First, chance to hit
is considered.  If a hit can occur, then the damage is calculated based on
character's damage range.  This damage is then applied to the opponenet.

Receives: opponent being attacked
Returns: nothing

This method calls: Math.random(), subtractHitPoints()
This method is called by: overridden versions of the method in monster and
hero classes and externally
---------------------------------------------------------*/
	public void attack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;
		String atkString = "";
			
		switch(this.getClassName())
		{
		case "Warrior":
				atkString = this.getName() + " " + "swings a sword at " + opponent.getName();
				break;
		case "Thief":
			atkString = this.getName() + " " + "jabs a dagger at " + opponent.getName();
			break;
		case "Sorceress":
			atkString = this.getName() + " " + "flings magic at " + opponent.getName();
			break;
		case "Monk":
			atkString = this.getName() + " " + "throws his fist at " + opponent.getName();
			break;
		case "Archer":
			atkString = this.getName() + " " + "fires an arrow at " + opponent.getName();
			break;
		case "Gnarltooth the Gremlin":
			atkString = this.getName() + " " + "swings a blade at " + opponent.getName();
			break;
		case "Oscar the Ogre":
			atkString = this.getName() + " " + "swings a club at " + opponent.getName();
			break;
		case "Stu the Skeleton":
			atkString = this.getName() + " " + "yells angrily at " + opponent.getName();
			break;
		case "Dave the Dragon":
			atkString = this.getName() + " " + "breaths fire at " + opponent.getName();
			break;
		case "Zed the Zergling":
			atkString = this.getName() + " " + "tries to bite " + opponent.getName();
			break;
		
		}
		
		System.out.println(atkString);
		canAttack = Math.random() <= chanceToHit;

		if (canAttack)
		{
			damage = (int)(Math.random() * (damageMax - damageMin + 1))
						+ damageMin ;
			opponent.subtractHitPoints(damage);



			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}//end else

	}//end attack method

//-----------------------------------------------------------------

	public abstract void resetHP();

	public int getTurns()
	{
		return this.numTurns;
	}
	
	public void setTurns(int newTurns)
	{
		if(newTurns < 0)
			System.out.println("Please enter a valid integer for adding turns");
		else
			this.numTurns += newTurns;
	}
}//end class Character