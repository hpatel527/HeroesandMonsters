package refactored;

import java.io.Serializable;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

//HARI PATEL && ALEX PRICE

public class Monster extends DungeonCharacter implements Serializable
{
	protected double chanceToHeal;
	protected int minHeal, maxHeal;
	

//-----------------------------------------------------------------
  public Monster(String className, int hitPoints, int attackSpeed,
				     double chanceToHit, double chanceToHeal,
					 int damageMin, int damageMax,
					 int minHeal, int maxHeal)
  {
	super(className, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.name = className;
	this.chanceToHeal = chanceToHeal;
	this.maxHeal = maxHeal;
	this.minHeal = minHeal;

  }//end monster construcotr

//-----------------------------------------------------------------
  public void heal()
  {
	boolean canHeal;
	int healPoints;
	
	canHeal = (Math.random() <= chanceToHeal) && (hitPoints > 0);

	if (canHeal)
	{
		healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		addHitPoints(healPoints);
		System.out.println(name + " healed itself for " + healPoints + " points.\n"
							+ "Total hit points remaining are: " + hitPoints);
		System.out.println();
	}//end can heal


  }//end heal method

//-----------------------------------------------------------------
 public void subtractHitPoints(int hitPoints)
 {
		super.subtractHitPoints(hitPoints);
		heal();

 }//end method

@Override
public void specialAttack(DungeonCharacter opponent, DungeonCharacter owner) {
	
	return;
}

@Override
public void resetHP()
{
	switch(this.getClassName())
	{
	case "Gnarltooth":
		this.hitPoints = 70;
	case "Oscar":
		this.hitPoints = 200;
	case "Stu":
		this.hitPoints = 100;
	case "Dave":
		this.hitPoints = 200;
	case "Zed":
		this.hitPoints = 10;
	default:
		this.hitPoints = 70;
	
	}
	
	
}

}//end Monster class