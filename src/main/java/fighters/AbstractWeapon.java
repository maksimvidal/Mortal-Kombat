package fighters;

public abstract class AbstractWeapon {

	private double health;
	private double attack;
	private int vampirism;
	private double defense;
	private double healPower;
	
	protected AbstractWeapon() {
		
	}

	protected AbstractWeapon(double health, double attack, int vampirism, double defense, double healPower) {
		setHealPower(healPower);
		setAttack(attack);
		setDefense(defense);
		setHealth(health);
		setVampirism(vampirism);
	}



	protected double getHealth() {
		return health;
	}
	protected void setHealth(double health) {
		this.health = health;
	}
	protected double getAttack() {
		return attack;
	}
	protected void setAttack(double attack) {
		this.attack = attack;
	}
	protected double getVampirism() {
		return vampirism;
	}
	protected void setVampirism(int vampirism) {
		this.vampirism = vampirism;
	}
	protected double getDefense() {
		return defense;
	}
	protected void setDefense(double defense) {
		this.defense = defense;
	}
	protected double getHealPower() {
		return healPower;
	}
	protected void setHealPower(double healPower) {
		this.healPower = healPower;
	}
}
