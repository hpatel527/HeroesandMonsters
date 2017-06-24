package refactored;

//HARI PATEL && ALEX PRICE

public class Suplex implements Attack {

	@Override
	public void specialAttack(DungeonCharacter opponent, DungeonCharacter owner) {
			System.out.println("John Cena appears out of nowhere and suplexes " + opponent.getName());

				int blowPoints = (int)(Math.random() * 76) + 45;
				System.out.println(owner.getName() + " does " + blowPoints
									+ " damage!");
				opponent.subtractHitPoints(blowPoints);
	}
	
	@Override
	public String toString()
	{
		return "Suplex";
	}

}
