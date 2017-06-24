package refactored;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

//HARI PATEL && ALEX PRICE

public class BattlePhase  {
	
	private static ArrayList<Hero> heroList;
	private static ArrayList<Monster> monsterList;
	
	
	public static void startBattle( ArrayList<Hero> heroList, ArrayList<Monster> monsterList)
	{
		BattlePhase.heroList = heroList;
		BattlePhase.monsterList = monsterList;
		boolean exit = false;
		while(heroList.size() > 0 && monsterList.size() > 0 && !exit)
		{
			exit = battle(heroList.get(ThreadLocalRandom.current().nextInt(0,heroList.size())), monsterList.get(ThreadLocalRandom.current().nextInt(0,monsterList.size() )));
			
		}
		
		if(exit)
		{
			return;
		}
		
		if(BattlePhase.heroList.size() == 0)
		{
			System.out.println("Monsters win!");
			return;
		}
		System.out.println("Heros win of course");
		
		
	}
	
	
	public static boolean battle(Hero theHero, Monster theMonster)
	{
		char pause = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		
		
		    //hero goes first
			theHero.attack(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			

		//end battle loop

		if (!theMonster.isAlive())
		{
		    System.out.println(theHero.getName() + " killed " + theMonster.getName());
			BattlePhase.monsterList.remove(theMonster);
		}
		if (!theHero.isAlive())
		{
			System.out.println(theHero.getName() + " was defeated by " + theMonster.getName());
			BattlePhase.heroList.remove(theHero);
		}	
		

		System.out.print("\n-->q to quit, anything else to continue: ");
		pause = Keyboard.readChar();
		
		if(pause =='q' || pause == 'Q')
		{
			System.out.println("Do you want to save your game (yes or no)?");
			String name = Keyboard.readString();
			if(name.equalsIgnoreCase("yes"))
			{
				Dungeon.saveGame(heroList,monsterList);
				System.exit(1);
			}
			
				
			return true;
		}
		
		return false;
		
		
	}//end battle method
	

}
