package fighters;

public class Battle {

	public static boolean fight(AbstractFighter fighter1,AbstractFighter fighter2) {
		if(fighter1==null)
			return false;
		if(fighter1 instanceof CombatHealer) 
			fighter1.setHealth(0);
	    if(fighter2==null)
	    	return true;
	    if(fighter2 instanceof CombatHealer)
	    	fighter2.setHealth(0);
		
		while(fighter1.isAlive() && fighter2.isAlive()) {
			fighter1.hit(fighter2);
			if(fighter2.isAlive())
			    fighter2.hit(fighter1);
		}
		
		return fighter1.isAlive();
	}
	
	public static boolean fight(Army army1,Army army2) {
		army1.moveUnits();
		army2.moveUnits();
		
		while(army1.hasUnits() && army2.hasUnits()) {
			fight(army1.getCurrentUnit(), army2.getCurrentUnit());
			army1.moveUnits();
			army2.moveUnits();
		}
		
		return army1.hasUnits();
	}
	
	public static boolean straightFight(Army army1, Army army2) {
		army1.setNullArmyForUnits();
		army2.setNullArmyForUnits();

		while (army1.hasUnits() && army2.hasUnits()) {
			int maxArmySize;
			int minArmySize;
			int firstArmySize = army1.size();
			int secondArmySize = army2.size();

			if (firstArmySize >= secondArmySize) {
				maxArmySize = army1.size();
				minArmySize = army2.size();
			} else {
				maxArmySize = army2.size();
				minArmySize = army1.size();
			}

			int j = minArmySize;
			for (int i = 0; i < maxArmySize; i++, j--) {
				AbstractFighter fighter1 = null;
				AbstractFighter fighter2 = null;
				if (j > 0 || minArmySize != firstArmySize) {
					fighter1 = army1.getUnit();
					if (fighter1 instanceof CombatHealer) {
						fighter1.setHealth(0);
					}
				}

				if (j > 0 || minArmySize != secondArmySize) {
					fighter2 = army2.getUnit();
					if (fighter2 instanceof CombatHealer) {
						fighter2.setHealth(0);
					}
				}

				if (fight(fighter1, fighter2))
					army1.addExistingUnit(fighter1);
				else
					army2.addExistingUnit(fighter2);
			}
		}

		return army1.hasUnits();
	}
}
