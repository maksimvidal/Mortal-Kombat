package fighters;

public class Vampire extends Warrior {

	private static final int DEFAULT_VAMPIRISM=50;
	private static final double DEFAULT_HEALTH=40.0;
	private static final double DEFAULT_ATTACK=4.0;
	
	private int vampirism;
	
	
	public Vampire() {
		setVampirism(DEFAULT_VAMPIRISM);
		setHealth(DEFAULT_HEALTH);
		setAttack(DEFAULT_ATTACK);
	}
	
	@Override
	double hit(AbstractFighter fighter) {
		double consumedDamage=fighter.consumeDamage(getRealAttack());
		double currentHealth=getHealth();
		
		currentHealth+=getRealVampirism()*consumedDamage/100.0;
		setHealth(Math.floor(currentHealth));
		if(getHealth()>getDefaultHealth())
			setHealth(getDefaultHealth());
		if(getFighterArmy()!=null)
			getFighterArmy().healArmy();
		
		return consumedDamage;
	}

	protected int getVampirism() {
		return vampirism;
	}

	protected void setVampirism(int vampirism) {
		this.vampirism = vampirism;
	}
	
	@Override
	protected double getDefaultAttack() {
		return DEFAULT_ATTACK;
	}
	
	@Override
	protected double getDefaultHealth() {
		return DEFAULT_HEALTH;
	}
	
	protected int getDefaultVampirism() {
		return DEFAULT_VAMPIRISM;
	}
	
	protected int getRealVampirism() {
		int realVampirism=getVampirism();
		 for(AbstractWeapon weapon:getWeapons()) {
			 realVampirism+=weapon.getVampirism();
		 }
		 
		 if(realVampirism<0)
			 return 0;
		 return realVampirism;
	}
}
