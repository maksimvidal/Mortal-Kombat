package fighters;

public class Battle {

	public static boolean fight(AbstractFighter fighter1,AbstractFighter fighter2) {
		
		while(fighter1.isAlive() && fighter2.isAlive()) {
			fighter1.hit(fighter2);
			if(fighter2.isAlive())
			    fighter2.hit(fighter1);
		}
		return fighter1.isAlive();
	}
	
	public static boolean fight(Army army1,Army army2) {
		
		while(army1.hasUnits() && army2.hasUnits()) {
			fight(army1.getUnit(), army2.getUnit());
		}
		
		return army1.hasUnits();
	}
}
