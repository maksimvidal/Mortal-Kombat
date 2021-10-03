package fighters;

public class Defender extends Warrior {

	private double defense;
	private static final double DEFAULT_DEFENSE=2.0;
	private static final double DEFAULT_HEALTH=60.0;
	private static final double DEFAULT_ATTACK=3.0;
	
	public Defender() {
		setDefense(DEFAULT_DEFENSE);
		setHealth(DEFAULT_HEALTH);
		setAttack(DEFAULT_ATTACK);
	}
	
	@Override
	double consumeDamage(double damage) {
		double realDamage=damage-getRealDefense();
		double currentHealth=getHealth();
		
		if(realDamage>0)
			currentHealth-=realDamage;
		setHealth(currentHealth);
		
		return  realDamage;
	}

	protected double getDefense() {
		return defense;
	}

	protected void setDefense(double defense) {
		this.defense = defense;
	}
	
	@Override
	protected double getDefaultAttack() {
		return DEFAULT_ATTACK;
	}
	
	@Override
	protected double getDefaultHealth() {
		return DEFAULT_HEALTH;
	}
	
	protected double getDefaultDefense() {
		return DEFAULT_DEFENSE;
	}
	
	protected double getRealDefense() {
		double realDefense=getDefense();
		 for(AbstractWeapon weapon:getWeapons()) {
			 realDefense+=weapon.getDefense();
		 }
		 
		 if(realDefense<0)
			 return 0;
		 return realDefense;
	}
	
}
