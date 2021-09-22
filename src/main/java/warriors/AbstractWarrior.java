package warriors;

import fighters.AbstractFighter;
import fighters.Fighter;

public abstract class AbstractWarrior extends AbstractFighter {
	
	@Override
	public void hit(Fighter fighter) {
		double damage=getAmountOfDamage();
		 
		fighter.consumeDamage(damage);
	}

	@Override
	public void consumeDamage(double damage) {
		health-=damage;
		if (health<=0) {
			isAlive=false;
		}
	}
	
}
