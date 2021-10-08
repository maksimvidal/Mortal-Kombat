package fighters;

public class Shield extends Weapon {
	private static final double DEFAULT_ATTACK = -1.0;
	private static final double DEFAULT_HEALTH = 20.0;
	private static final double DEFAULT_DEFENSE = 2.0;

	public Shield() {
		setAttack(DEFAULT_ATTACK);
		setDefense(DEFAULT_DEFENSE);
		setHealth(DEFAULT_HEALTH);
	}
}
