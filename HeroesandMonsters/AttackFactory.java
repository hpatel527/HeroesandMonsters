package refactored;
import java.util.ArrayList;
import java.util.HashMap;

//HARI PATEL && ALEX PRICE

public class AttackFactory {

	private static final HashMap<String,Attack> attackMap = new HashMap();

	
	public static Attack getSpecialAttack(String specialAttack,DungeonCharacter owner) // need to refactor
	{
		switch(specialAttack)
		{
			case "CrushingBlow":
				CrushingBlow blow = (CrushingBlow)attackMap.get(specialAttack);

				if(blow == null)
				{
					blow = new CrushingBlow();
					attackMap.put(specialAttack,blow);
					System.out.println(owner.getName() + " has been equipped with a Crushing Blow!");
				}
				return blow;
			
			case "Heal":
				Heal heal = (Heal) attackMap.get(specialAttack);
				
				if(heal == null)
				{
					heal = new Heal();
					attackMap.put(specialAttack,heal);
					System.out.println(owner.getName() + " has been equipped with a heal!");
				}
				return heal;
				
			case "Tetanus":
				Tetanus tet = (Tetanus) attackMap.get(specialAttack);
				
				if(tet == null)
				{
					tet = new Tetanus();
					attackMap.put(specialAttack,tet);
					System.out.println(owner.getName() + " has been equipped with a heal!");
				}
				return tet;
			case "Suplex":
				Suplex sup = (Suplex) attackMap.get(specialAttack);
				
				if(sup == null)
				{
					sup = new Suplex();
					attackMap.put(specialAttack,sup);
					System.out.println(owner.getName() + " befriends John Cena!");
				}
				return sup;	
			case "FalconPunch":
				FalconPunch punch = (FalconPunch) attackMap.get(specialAttack);
				
				if(punch == null)
				{
					punch = new FalconPunch();
					attackMap.put(specialAttack,punch);
					System.out.println(owner.getName() + " can now Falcon Punch!");
				}
				return punch;	
				
			case "BackStab":
				BackStab stab = (BackStab) attackMap.get(specialAttack);
				
				if(stab == null)
				{
					stab = new BackStab();
					attackMap.put(specialAttack,stab);
					System.out.println(owner.getName() + " can now BACKSTAB!");
				}
				return stab;
				
			default:
				System.out.println("Invalid special attack entered. Defaulting to a CrushingBlow");
				CrushingBlow blow2 = (CrushingBlow)attackMap.get(specialAttack);
				
				if(blow2 == null)
				{
					blow2 = new CrushingBlow();
					attackMap.put(owner.toString(),blow2);
					System.out.println(owner.getName() + " has been equipped with a CrushingBlow!");
				}
				return blow2;
		}

	}
	
	
	
}
