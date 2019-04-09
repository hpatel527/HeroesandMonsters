package refactored;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 */

//HARI PATEL && ALEX PRICE


public class Hero extends DungeonCharacter implements Serializable
{
	protected double chanceToBlock;
	protected Attack atkBehavior;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String className,int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {	
	super(className, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
  }
  
  

/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  public void readName()
  {
	 
	
		System.out.print("Enter character name: ");
		this.name = Keyboard.readString();
	

	 
  }//end readName method

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from DungeonCharacter promoting polymorphic behavior

Receives: hit points to subtract
Returns: nothing

This method calls: defend() or base version of method
This method is called by: attack() from base class
---------------------------------------------------------*/
public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(name + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	@Override
	public void attack(DungeonCharacter opponent)
	{
	    numTurns = attackSpeed/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);
		
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Special Attack");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    switch (choice)
		    {
			    case 1: super.attack(opponent);
			        break;
			    case 2: this.atkBehavior.specialAttack(opponent,this);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

	}//end battleChoices



	@Override
	public void specialAttack(DungeonCharacter opponent,DungeonCharacter owner) {
		// TODO Auto-generated method stub
		this.atkBehavior.specialAttack(opponent,owner);
	}
	
	public int getNumTurns()
	{
		return this.numTurns;
	}

	public void setSpecialAttack(Attack specialAttack) 
	{
		if(specialAttack == null)
			System.out.print("PLEASE ENTER VALID ATTACK.\n");
		else
		{
		this.atkBehavior = specialAttack;
		}
		}

	@Override
	public void resetHP()
	{
		switch(this.getClassName())
		{
		case "Warrior":
			this.hitPoints=  125;
		case "Thief":
			this.hitPoints=  75;
		case "Sorceress":
			this.hitPoints=  75;
		case "Monk":
			this.hitPoints=  100;
		case "Archer":
			this.hitPoints=  55;
		default:
			this.hitPoints=  125;
		
		
		}
		
		
	}
}//end Hero class
