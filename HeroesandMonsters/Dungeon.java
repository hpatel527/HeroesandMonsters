package refactored;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;



/**
 * Title: Dungeon.java
 *

 * version 1.0
 */
// HARI PATEL && ALEX PRICE


/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class Dungeon
{
	private static int numberOfHeros = 0;
	private static ArrayList<Hero> heroList = new ArrayList<Hero>();
	private static ArrayList<Monster> monsterList = new ArrayList<Monster>();
	private static ArrayList<Double> attackSpeed = new ArrayList<Double>();
	
    public static void main(String[] args)
	{
    	System.out.println("Do you want to load a save file? Please type 'yes' or 'no'.");
    	String load = Keyboard.readString();
    	boolean loadBool = false;
    	
    	if(load.equalsIgnoreCase("yes"))
    		loadBool = true;
    	
    		if(loadGame(loadBool,heroList,monsterList))
    		{
    			do
    			{
    				ArrayList<Hero> heroListt = new ArrayList<Hero>(heroList);
    				ArrayList<Monster> monsterListt = new ArrayList<Monster>(monsterList);
    				
    				BattlePhase.startBattle(heroListt, monsterListt);
    			}while(playAgain());
    			
    			
    		}
    		else
    		{
    			createHeros();
    			do
    			{
    				ArrayList<Hero> heroListPass = new ArrayList<Hero>();
    				
    				for(Hero h : heroList)
    				{
    					h.resetHP();
    					heroListPass.add(h);
    				}
    				
    				ArrayList<Monster> monsterListPass = new ArrayList<Monster>();
    				
    				
    				
    				for(Monster m : monsterList)
    				{
    					m.resetHP();
    					monsterListPass.add(m);
    				}
    			
    				
    				BattlePhase.startBattle(heroListPass, monsterListPass);
    			}while(playAgain());
    			
    		
    		}
    		System.out.println("Thanks for playin guy");
    		System.exit(1);
    		
    		
    		
    		
    		
    	

		
		
		
		/* BattlePhase.startBattle(heroList, monsterList);
		if(playAgain())
		{
			BattlePhase.startBattle(heroList, monsterList);
		} */
		
		
		    
			

		
		
		
		
		

    }//end main method
    
    
    public static void createHeros()
    {
    	do
		{
			
			 Hero cur = chooseHero();
			 
			cur.setSpecialAttack(chooseSpecialAttack(cur));
			 heroList.add(cur);
			 
		
			 monsterList.add(generateMonster());
			 numberOfHeros++;
			 
		}while(anothaOne(numberOfHeros));
    	
    }
    
    
    
    public static void saveGame(List<Hero> heroes, List<Monster> monsters)
	{
		
		try{
			
			FileOutputStream fout = new FileOutputStream("save.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject("" +heroes.size());
			for(Hero curHero : heroes)
			{
				oos.writeObject(curHero);
			}
			oos.writeObject("" + monsters.size());
			for(Monster curMon : monsters)
			{
				oos.writeObject(curMon);
			}
			System.out.println("Game has been saved");
			oos.close(); 
			
			
			}catch(Exception e){
				System.out.println("Error has occured in saving game.");
			}
		
		
	}
    
    
    


    
    public static boolean loadGame(boolean loadBool,ArrayList<Hero> heroes, ArrayList<Monster> monsters)
	{
    	if(loadBool)
    	{
		ObjectInputStream objectinputstream = null;
		try{
	    	FileInputStream streamIn = new FileInputStream("save.ser");
	    	objectinputstream = new ObjectInputStream(streamIn);
	    	
	    	String heroNumStr = (String) objectinputstream.readObject();
	    	int heroNum = Integer.parseInt(heroNumStr);
	    	
	    	for(int i = 0; i < heroNum ; i++)
	    	{
	    		heroes.add((Hero) objectinputstream.readObject());
	    	}
	    	
	    	String monNumStr = (String) objectinputstream.readObject();
	    	int monsterNum = Integer.parseInt(monNumStr);
	    	
	    	for(int i = 0; i < monsterNum ; i++)
	    	{
	    		monsters.add((Monster) objectinputstream.readObject());
	    	}
	    	
	    	/*theHero = (Hero) objectinputstream.readObject();
	    	theMonster = (Monster) objectinputstream.readObject(); */
	    	System.out.println("Previous Game loaded. Now continuing battle.");
	    	objectinputstream.close();
	    	return true;
	    	}catch(Exception e){
	    		System.out.println("No save file found");
	    		
	    	}
    	}
		return false;
		
	}
    
    
    /*-------------------------------------------------------------------
    chooseHero allows the user to select a hero, creates that hero, and
    returns it.  It utilizes a polymorphic reference (Hero) to accomplish
    this task
    ---------------------------------------------------------------------*/
    
    
    public static Attack chooseSpecialAttack(Hero hero)
    {
    	int choice;
    	
    	System.out.println("Choose a weapon for your Hero:\n" +
    						"1. CrushingBlow\n" +
    						 "2. Heal\n" +
    						"3. Tetanus\n"+
    						 "4. Suplex\n"+
    						 "5. FalconPunch\n"+
    						  "6. BackStab\n");
    	
    	
    	
    		choice = Keyboard.readInt();
    		if(choice == Long.MIN_VALUE)
    		{
    			choice = 1;
    		}
    	
    	
    	
    	switch(choice)
    	{
    	case 1:return AttackFactory.getSpecialAttack("CrushingBlow", hero );
    	case 2: return AttackFactory.getSpecialAttack("Heal", hero );
    	case 3: return AttackFactory.getSpecialAttack("Tetanus", hero );
    	case 4: return AttackFactory.getSpecialAttack("Suplex",hero );
    	case 5: return AttackFactory.getSpecialAttack("FalconPunch", hero );
    	case 6: return AttackFactory.getSpecialAttack("BackStab" ,hero );
    	default: return AttackFactory.getSpecialAttack("CrushingBlow", hero );
    	
    	
    	}
    }
    
    
    
	public static Hero chooseHero()
	{
		int choice;
		

		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief\n"+
						   "4. Monk\n"+
						   "5. Archer");
		choice = Keyboard.readInt();
		if(choice == Long.MIN_VALUE)
		{
			choice = 1;
		}
		
		
		
		switch(choice)
		{
			case 1: return HeroFactory.createHero("Warrior");

			case 2: return HeroFactory.createHero("Sorceress");

			case 3: return HeroFactory.createHero("Thief");
			
			case 4: return HeroFactory.createHero("Monk");
			
			case 5: return HeroFactory.createHero("Archer");

			default: System.out.println("invalid choice, returning Thief");
				     return HeroFactory.createHero("Thief");
		}//end switch
	}//end chooseHero method

/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
a polymorphic reference (Monster) to accomplish this task.
---------------------------------------------------------------------*/
	public static Monster generateMonster()
	{
		int choice;

		choice = (int)(Math.random() * 5) + 1;

		switch(choice)
		{
			case 1: return MonsterFactory.createMonster("Ogre");

			case 2: return  MonsterFactory.createMonster("Gremlin");

			case 3: return  MonsterFactory.createMonster( "Skeleton");
			
			case 4: return MonsterFactory.createMonster("Zed");
			
			case 5: return MonsterFactory.createMonster("Dave");

			default: System.out.println("invalid choice, returning Skeleton");
				     return MonsterFactory.createMonster("Skeleton");
		}//end switch
	}//end generateMonster method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		return (again == 'Y' || again == 'y');
	}//end playAgain method


	
	public static boolean anothaOne(int numberOfHeros)
	{
		char again;
		if(numberOfHeros < 1)
		{
			return true;
		}
		
		System.out.println("add another Hero? (y/n)");
		
		again = Keyboard.readChar();
		
		return (again == 'Y' || again == 'y');
		
		
	}
	
	
/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	


}//end Dungeon class
