package fighters;

public class Healer extends Warrior implements CombatHealer {

	private static final double DEFAULT_HEALTH=60.0;
	private static final double DEFAULT_ATTACK=0.0;
	private static final double DEFAULT_HEALPOWER=2.0;
	
	private double healPower;
	
	public Healer() {
	    setAttack(DEFAULT_ATTACK);
	    setHealth(DEFAULT_HEALTH);
	    setHealPower(DEFAULT_HEALPOWER);
	}
	
	@Override
	double hit(AbstractFighter fighter) {
		return 0;
	}
	
	@Override
	public double heal(AbstractFighter fighter) {
		double fighterHealth=0.0;
		if(fighter.isAlive()) {
			fighterHealth = fighter.getHealth();
			fighterHealth+=getRealHealPower();
			if(fighterHealth>fighter.getDefaultHealth()) 
				fighterHealth=fighter.getDefaultHealth();
			fighter.setHealth(fighterHealth);
		}
		
		return fighterHealth;
	}

	protected double getHealPower() {
		return healPower;
	}

	protected void setHealPower(double healPower) {
		this.healPower = healPower;
	}

	@Override
	protected double getDefaultAttack() {
		return DEFAULT_ATTACK;
	}
	
	@Override
	protected double getDefaultHealth() {
		return DEFAULT_HEALTH;
	}
	
	public double getDefaultHealPower() {
		return DEFAULT_HEALPOWER;
	}
	
	protected double getRealHealPower() {
		double realHealPower=getHealPower();
		 for(AbstractWeapon weapon:getWeapons()) {
			 realHealPower+=weapon.getHealPower();
		 }
		 
		 if(realHealPower<0)
			 return 0;
		 return realHealPower;
	} 
}
