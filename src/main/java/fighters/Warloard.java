package fighters;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Warloard extends Warrior {

	private double defense;
	private static final double DEFAULT_DEFENSE=2.0;
	private static final double DEFAULT_HEALTH=100.0;
	private static final double DEFAULT_ATTACK=4.0;
	
	public Warloard() {
		setDefense(DEFAULT_DEFENSE);
		setHealth(DEFAULT_HEALTH);
		setAttack(DEFAULT_ATTACK);
	}
	
	@Override
	double consumeDamage(double damage) {
		double realDamage=damage-getRealDefense();
		double currentHealth=getHealth();
		
		if(realDamage>0)
			currentHealth-=realDamage;
		setHealth(currentHealth);
		
		return  realDamage;
	}

	protected double getDefense() {
		return defense;
	}

	protected void setDefense(double defense) {
		this.defense = defense;
	}
	
	@Override
	protected double getDefaultAttack() {
		return DEFAULT_ATTACK;
	}
	
	@Override
	protected double getDefaultHealth() {
		return DEFAULT_HEALTH;
	}
	
	protected double getDefaultDefense() {
		return DEFAULT_DEFENSE;
	}
	
	protected double getRealDefense() {
		double realDefense=getDefense();
		 for(AbstractWeapon weapon:getWeapons()) {
			 realDefense+=weapon.getDefense();
		 }
		 
		 if(realDefense<0)
			 return 0;
		 return realDefense;
	}
 	
	protected void chooseCurrentFighter() {
		AbstractArmy army=getFighterArmy();
		if(army!=null) {
		   AbstractFighter chosenFighter=null;
		   chosenFighter=army.getUnitByType(FighterType.LANCER);
		   if(chosenFighter==null)
			   chosenFighter=army.getAnyUnitExcept(FighterType.WARLOARD,FighterType.HEALER);  
		   if(chosenFighter==null)
			   chosenFighter=army.getUnitByType(FighterType.HEALER);
		   if(chosenFighter==null)
			   army.currentFighter=this;
		   else
			   army.currentFighter=chosenFighter;
		}
	}
	
	protected void sortRestOfArmy() {
		if(getFighterArmy()!=null) {
		    AbstractArmy army=getFighterArmy();
		    List<AbstractFighter> sortedFighters=army.units.
		    		stream().
		    		sorted(new ArmyComparator()).
		    		collect(Collectors.toList());
		    army.units=new ArrayDeque<>(sortedFighters);
		}
	}
	
	protected class ArmyComparator implements Comparator<AbstractFighter>{
		
		@Override
		public int compare(AbstractFighter o1, AbstractFighter o2) {
			if(o1 instanceof CombatHealer && o2 instanceof CombatHealer)
				return 0;
			if(o1 instanceof CombatHealer)
				return -1;
			if(o2 instanceof CombatHealer)
			    return 1;
			
			if(o1.getClass()==Warloard.class && o2.getClass()==Warloard.class)
				return 0;
			if(o1.getClass()==Warloard.class)
				return 1;
			if(o2.getClass()==Warloard.class)
				return -1;
			
			return 0;
		}
		
	}
}
