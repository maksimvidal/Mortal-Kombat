package fighters;

public class Weapon extends AbstractWeapon {

	public Weapon() {
	}

	public Weapon(double health, double attack, int vampirism, double defense, double healPower) {
		super(health, attack, vampirism, defense, healPower);
	}
}
