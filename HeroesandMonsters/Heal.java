package refactored;

//HARI PATEL && ALEX PRICE

import java.io.Serializable;

public class Heal implements Attack,Serializable {


	@Override
	public void specialAttack(DungeonCharacter opponent,DungeonCharacter owner) {
		int hPoints;

		hPoints = (int)(Math.random() * (50 - 25 + 1)) + 25;
		owner.addHitPoints(hPoints);
		System.out.println(owner.getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ owner.getHitPoints());
		 System.out.println();
}

	@Override
	public String toString()
	{
		return "Heal";
	}
	
	
}