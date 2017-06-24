package refactored;
import java.io.Serializable;

//HARI PATEL && ALEX PRICE

public interface Attack extends Serializable
{
	void specialAttack(DungeonCharacter opponent,DungeonCharacter owner);
	String toString();
}
