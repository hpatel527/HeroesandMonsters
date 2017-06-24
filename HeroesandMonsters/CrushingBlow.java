package refactored;

//HARI PATEL && ALEX PRICE

public class CrushingBlow implements Attack {

	
	
	@Override
	public void specialAttack(DungeonCharacter opponent, DungeonCharacter owner) 
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(owner.getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(owner.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}

	@Override
	public String toString()
	{
		return "CrushingBlow";
	}
}
