package refactored;

//HARI PATEL && ALEX PRICE

public class BackStab implements Attack {

	@Override
	public void specialAttack(DungeonCharacter opponent, DungeonCharacter owner) {
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								owner.getName() + " gets an additional turn.");
			owner.setTurns(1);
			owner.attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}

	}
	@Override
	public String toString()
	{
		return "BackStab";
	}

}
