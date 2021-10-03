package fighters;

public interface CombatArmy {

	void addUnits(FighterType type ,int number);
	
	AbstractFighter get(int index);
	
	void moveUnits();
}
