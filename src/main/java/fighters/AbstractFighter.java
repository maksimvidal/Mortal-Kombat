package fighters;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractFighter implements Fighter {

	private double health;
	private double attack;
	private AbstractArmy fighterArmy;
	private List<AbstractWeapon> weapons = new LinkedList<>();

	@Override
	public boolean isAlive() {
		return getRealHealth() > 0;
	}

	@Override
	public void equipWeapon(AbstractWeapon weapon) {
		if (weapon != null)
			weapons.add(weapon);
	}

	double getHealth() {
		return health;
	}

	double hit(AbstractFighter fighter) {
		double realDamage = fighter.consumeDamage(getRealAttack());
		if (getFighterArmy() != null)
			getFighterArmy().healArmy();

		return realDamage;
	}

	double consumeDamage(double damage) {
		if (damage >= 0)
			health -= damage;
		else
			return 0;

		return damage;
	}

	void setArmy(AbstractArmy army) {
		fighterArmy = army;
	}

	AbstractArmy getFighterArmy() {
		return fighterArmy;
	}

	protected double getAttack() {
		return attack;
	}

	protected void setAttack(double attack) {
		this.attack = attack;
	}

	protected void setHealth(double health) {
		this.health = health;
	}

	protected void setFighterArmy(AbstractArmy fighterArmy) {
		this.fighterArmy = fighterArmy;
	}

	protected List<AbstractWeapon> getWeapons() {
		return weapons;
	}

	protected abstract double getDefaultAttack();

	protected abstract double getDefaultHealth();

	protected abstract double getMaxHealth();

	protected double getRealHealth() {
		double realHealth = getHealth();
		for (AbstractWeapon weapon : weapons) {
			realHealth += weapon.getHealth();
		}

		return realHealth;
	}

	protected double getRealAttack() {
		double realDamage = getAttack();
		for (AbstractWeapon weapon : weapons) {
			realDamage += weapon.getAttack();
		}

		if (realDamage < 0)
			return 0;
		return realDamage;
	}
}
