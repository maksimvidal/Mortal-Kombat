package fighters;

public class Defender extends Warrior {

	protected double defense;
	
	public Defender() {
		defense=2.0;
		health=60;
		attack=3;
	}
	
	@Override
	double consumeDamage(double damage) {
		double realDamage=damage-defense;
		if(realDamage>0)
			health-=realDamage;
		return  realDamage;
	}
}
