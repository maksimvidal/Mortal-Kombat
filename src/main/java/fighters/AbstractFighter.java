package fighters;

public abstract class AbstractFighter implements Fighter {
	
	protected double health;
	protected double attack;
	
	@Override
	public boolean isAlive() {
		return health<=0?false:true;
	}
	
	double getHealth() {
		return health;
	}
	
	double hit (AbstractFighter fighter) {
		fighter.consumeDamage(attack);
		return attack;
	}
	
	double getAmountOfDamage() {
		return attack;
	}

	double consumeDamage(double damage) {
		health-=damage;
		return damage;
	}
}
