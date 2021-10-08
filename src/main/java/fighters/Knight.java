package fighters;

public class Knight extends Warrior {

	private static final double DEFAULT_ATTACK = 7.0;
	private static final double DEFAULT_HEALTH = 50.0;

	public Knight() {
		setAttack(DEFAULT_ATTACK);
		setHealth(DEFAULT_HEALTH);
	}

	@Override
	protected double getDefaultAttack() {
		return DEFAULT_ATTACK;
	}

	@Override
	protected double getMaxHealth() {
		return DEFAULT_HEALTH;
	}

}
