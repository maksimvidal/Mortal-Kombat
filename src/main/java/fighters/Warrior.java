package fighters;

public class Warrior extends AbstractFighter {
	
	private static final double DEFAULT_ATTACK=5.0;
	private static final double DEFAULT_HEALTH=50.0;
	
	public Warrior() {
		setAttack(DEFAULT_ATTACK);
		setHealth(DEFAULT_HEALTH);
	}

	@Override
	protected double getDefaultAttack() {
		return DEFAULT_ATTACK;
	}

	@Override
	protected double getDefaultHealth() {
		return DEFAULT_HEALTH;
	}

	@Override
	protected double getMaxHealth() {
		 double defaultHealth=getDefaultHealth();
		 for(AbstractWeapon weapon:getWeapons()) {
			 defaultHealth+=weapon.getHealth();
		 }
		 
		 if(defaultHealth<0)
			 return 0;
		 return defaultHealth;
	}
	
	

}
