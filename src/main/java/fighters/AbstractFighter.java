package fighters;

public abstract class AbstractFighter implements Fighter {
	
	protected double health;
	protected boolean isAlive;
	protected double amountOfDamage;
	
	protected AbstractFighter() {
		isAlive=true;
	}
	
	@Override
	public boolean isAlive() {
		return isAlive;
	}
	
	public double getHealth() {
		return health;
	}
	
	public double getAmountOfDamage() {
		return amountOfDamage;
	}
}
