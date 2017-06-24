package refactored;


//HARI PATEL && ALEX PRICE

public class HeroFactory {

	
	public static Hero createHero(String name)
	{
		Hero hero;
		
		switch(name) // need to create flyweight factory that will create and set the attack behaviors instead of in heroFactory
		{
		case "Warrior":
			return new Hero("Warrior", 125, 4, .8, 35, 60, .2);
		case "Thief":
			return new Hero("Thief", 75, 6, .8, 20, 40, .5);
		case "Sorceress":
			return new Hero("Sorceress", 75, 5, .7, 25, 50, .3);
		case "Monk":
			return new Hero("Monk", 100,8,.7,35,55,.6);
		case "Archer":
			return new Hero("Archer",55,5,.4,44,66,.1);
		default:
			return new Hero("Warrior", 125, 4, .8, 35, 60, .2);
		
		}
		
	}
	
	
	
}
