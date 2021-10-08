package fighters;

public class GreatAxe extends Weapon {

	private static final double DEFAULT_ATTACK = 5.0;
	private static final double DEFAULT_HEALTH = -15.0;
	private static final double DEFAULT_DEFENSE = -2.0;
	private static final int DEFAULT_VAMPIRISM = 10;

	public GreatAxe() {
		setAttack(DEFAULT_ATTACK);
		setDefense(DEFAULT_DEFENSE);
		setHealth(DEFAULT_HEALTH);
		setVampirism(DEFAULT_VAMPIRISM);
	}

}
