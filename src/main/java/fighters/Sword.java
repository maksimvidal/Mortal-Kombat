package fighters;

public class Sword extends Weapon {

	private static final double DEFAULT_ATTACK = 2.0;
	private static final double DEFAULT_HEALTH = 5.0;

	public Sword() {
		setAttack(DEFAULT_ATTACK);
		setHealth(DEFAULT_HEALTH);
	}
}
