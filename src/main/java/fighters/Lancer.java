package fighters;

public class Lancer extends Warrior {

	private static final double DEFAULT_ATTACK = 6.0;
	private static final double DEFAULT_HEALTH = 50.0;

	public Lancer() {
		setHealth(DEFAULT_HEALTH);
		setAttack(DEFAULT_ATTACK);
	}

	@Override
	double hit(AbstractFighter fighter) {

		if (fighter.getFighterArmy() == null)
			return super.hit(fighter);
		else
			return hit(fighter.getFighterArmy());
	}

	double hit(AbstractArmy army) {
		double realDamage = super.hit(army.getCurrentUnit());
		double nextDamage = 50 * realDamage / 100.0;

		if (army.hasLivingUnit())
			nextDamage = army.getNextLivingUnit().consumeDamage(nextDamage);

		return realDamage + nextDamage;
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