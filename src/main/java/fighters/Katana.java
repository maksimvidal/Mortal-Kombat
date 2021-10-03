package fighters;

public class Katana extends Weapon {
	
	private static final double DEFAULT_ATTACK=6.0;
	private static final double DEFAULT_HEALTH=-20.0;
	private static final double DEFAULT_DEFENSE=-5.0;
	private static final int DEFAULT_VAMPIRISM=50;
	
	public Katana() {
		setAttack(DEFAULT_ATTACK);
		setDefense(DEFAULT_DEFENSE);
		setHealth(DEFAULT_HEALTH);
		setVampirism(DEFAULT_VAMPIRISM);
	}
}
