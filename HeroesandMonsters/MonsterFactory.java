package refactored;

//HARI PATEL && ALEX PRICE

public class MonsterFactory {

	public static Monster createMonster(String name)
	{
		switch(name)
		{
		case "Gnarltooth":
			return new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
		case "Oscar":
			return new Monster("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
		case "Stu":
			return new Monster("Stu the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
		case "Dave":
			return new Monster("Dave the Dragon", 200, 6, .8, .6, 60, 50, 40, 60);
		case "Zed":
			return new Monster("Zed the zergling", 10, 4, .4, .2, 10, 10, 10, 10);
		default:
			return new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
		
		}
		
	}

	
}
