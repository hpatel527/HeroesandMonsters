package refactored;

//HARI PATEL && ALEX PRICE


public class FalconPunch implements Attack {

	@Override
	public void specialAttack(DungeonCharacter opponent, DungeonCharacter owner) {
		if (Math.random() <= .05)
		{
			int blowPoints = (int)(Math.random() * 76) + 100000;
			System.out.println(owner.getName() + " lands a FALCON PUNCH for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(owner.getName() + " missed their FALCON PUNCH completely!");

		}//blow failed

	}

}
