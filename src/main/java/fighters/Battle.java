package fighters;

import java.util.Iterator;

public class Battle {

	public static boolean fight(AbstractFighter fighter1, AbstractFighter fighter2) {
		if (fighter1 == null)
			return false;
		if (fighter2 == null)
			return true;
		killIfHealer(fighter1);
		killIfHealer(fighter2);

		while (fighter1.isAlive() && fighter2.isAlive()) {
			fighter1.hit(fighter2);
			if (fighter2.isAlive())
				fighter2.hit(fighter1);
		}

		return fighter1.isAlive();
	}

	public static boolean fight(Army army1, Army army2) {
		army1.moveUnits();
		army2.moveUnits();

		while (army1.hasUnits() && army2.hasUnits()) {
			fight(army1.getCurrentUnit(), army2.getCurrentUnit());
			army1.moveUnits();
			army2.moveUnits();
		}

		return army1.hasUnits();
	}

	public static boolean straightFight(Army army1, Army army2) {
		army1.setNullArmyForUnits();
		army2.setNullArmyForUnits();

		while (army1.hasUnits() && army2.hasUnits()) {
			Iterator<AbstractFighter> armyIterator1 = army1.units.iterator();
			Iterator<AbstractFighter> armyIterator2 = army2.units.iterator();

			straightFight(armyIterator1, armyIterator2);

			army1.clearFromDeadUnit();
			army2.clearFromDeadUnit();
		}
		return army1.hasUnits();
	}

	private static void straightFight(Iterator<AbstractFighter> armyIterator1,
			Iterator<AbstractFighter> armyIterator2) {
		AbstractFighter fighter1 = null;
		AbstractFighter fighter2 = null;

		while (armyIterator1.hasNext() || armyIterator2.hasNext()) {
			fighter1 = null;
			fighter2 = null;

			if (armyIterator1.hasNext())
				fighter1 = armyIterator1.next();
			if (armyIterator2.hasNext())
				fighter2 = armyIterator2.next();

			fight(fighter1, fighter2);
		}
	}

	private static void killIfHealer(AbstractFighter fighter) {
		if (fighter instanceof CombatHealer)
			fighter.setHealth(0);
	}

}
