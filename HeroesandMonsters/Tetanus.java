package refactored;

import java.io.Serializable;

//HARI PATEL && ALEX PRICE

public class Tetanus implements Attack,Serializable {

	@Override
	public void specialAttack(DungeonCharacter opponent,DungeonCharacter owner) {
		System.out.println("You have been cut with a rusty sword, be careful of lockjaw! Deals 20 damage");
		opponent.subtractHitPoints(20);
		
	}
	@Override
	public String toString()
	{
		return "Tetanus";
	}
	
}
