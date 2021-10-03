package fighters;

public class MagicWand extends Weapon {

	private static final double DEFAULT_ATTACK=3.0;
	private static final double DEFAULT_HEALTH=30.0;
	private static final double DEFAULT_HEALPOWER=3.0;
	
	public MagicWand() {
		setAttack(DEFAULT_ATTACK);
		setHealth(DEFAULT_HEALTH);
		setHealPower(DEFAULT_HEALPOWER);
	}
}
