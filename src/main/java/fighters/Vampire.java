package fighters;

public class Vampire extends Warrior {

	protected int vampirism;
	
	public Vampire() {
		vampirism=50;
		health=40.0;
		attack=4.0;
	}
	
	@Override
	double hit(AbstractFighter fighter) {
		double consumedDamage=fighter.consumeDamage(attack);
		health+=vampirism*consumedDamage/100.0;
		
		if(health>40)
			health=40;
		
		return attack;
	}
}
