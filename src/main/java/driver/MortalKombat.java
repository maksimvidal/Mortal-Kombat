package driver;

import fighters.Fighter;

public class MortalKombat {

	public static boolean fight(Fighter fighter1,Fighter fighter2) {
		
		while(fighter1.isAlive() && fighter2.isAlive()) {
			fighter1.hit(fighter2);
			if(fighter2.isAlive())
			    fighter2.hit(fighter1);
		}
		return fighter1.isAlive();
	}
}
