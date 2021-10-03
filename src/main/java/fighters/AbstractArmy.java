package fighters;

import static org.hamcrest.CoreMatchers.nullValue;

import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class AbstractArmy implements CombatArmy {

	protected Deque<AbstractFighter> units = new ArrayDeque<>();
	protected AbstractFighter currentFighter;
	protected Warloard warloard;

	
	 @Override
	 public void addUnits(FighterType type, int number) {
			try {
				var constructor=type.getTypeClass().getConstructor();
				for (int i = 0; i < number; i++) {
					if(type.getTypeClass()==Warloard.class && warloard==null) {
						warloard=(Warloard)constructor.newInstance();
						warloard.setArmy(this);
						units.add(warloard);
					}
					else if(type.getTypeClass()!=Warloard.class) {
					AbstractFighter fighter=constructor.newInstance();
					units.add(fighter);
					fighter.setArmy(this);
					}
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	 
	 @Override
	public AbstractFighter get(int index) {
         if(index>=units.size() || index<0)
        	 return null;
         
		Iterator<AbstractFighter> iterator=units.descendingIterator(); 
		AbstractFighter fighter=null;
		int counter=0;
        while(iterator.hasNext()) {
        	fighter=iterator.next();
        	counter++;
        	if(counter==index) {
        		break;
        	}
        }
        
		return fighter;
	}
	 
	AbstractFighter getCurrentUnit() {
		if (currentFighter == null || !currentFighter.isAlive())
			currentFighter = units.poll();
		    
		return currentFighter;
	}
	
	AbstractFighter getUnit() {
		return units.poll();
	}
	
	void addExistingUnit(AbstractFighter fighter) {
		if(fighter!=null && fighter.isAlive())
			units.add(fighter);
	}

	boolean hasUnits() {
		if(currentFighter!=null && currentFighter.isAlive())
			return true;
		
		return !units.isEmpty();
	}
	
	boolean hasLivingUnit() {
		return units.stream().anyMatch(AbstractFighter::isAlive);
	}
	
	AbstractFighter getNextLivingUnit() {
		return units.stream()
				    .filter(AbstractFighter::isAlive)
				    .findFirst()
				    .orElse(null); 
	}
	
	void healArmy() {
		if(hasUnits()) {
			healCurrentWarrior();
		    healRestOfArmy();
		}
	}
	
	void healCurrentWarrior() {
		if(hasLivingUnit()) {
			AbstractFighter fighter=getNextLivingUnit();
			if(fighter instanceof CombatHealer) {
				CombatHealer healer=(CombatHealer)fighter;
				healer.heal(currentFighter);
			}
		}
	}
	
	void healRestOfArmy() {
		Iterator<AbstractFighter> iterator=units.iterator();
		AbstractFighter toHeal=null;
		AbstractFighter healer=null;
		
		if(iterator.hasNext())
			toHeal=iterator.next();
			
	    while(iterator.hasNext()) {
	    	healer=iterator.next();
	    	if(healer instanceof CombatHealer) {
	    		CombatHealer realHealer=(Healer)healer;
	    		realHealer.heal(toHeal);
	    	}
	    	toHeal=healer;
	    }
	}
	
	int size(){
		if(currentFighter==null || !currentFighter.isAlive())
			return units.size();
		else
			return units.size()+1;
	}
	
	void setNullArmyForUnits() {
		units.forEach(x->x.setArmy(null));
	}
	
	AbstractFighter getUnitByType(FighterType type) {
		var clazz=type.getTypeClass();
		return units.
				stream().
				filter(x->x.getClass()==clazz && x.isAlive()).
				findFirst().
				orElse(null);
	}
	
	protected AbstractFighter getAnyUnitExcept(FighterType... types) {
		
		List<Class<? extends AbstractFighter>> fighterTypes=new LinkedList<>();
		for(FighterType type: types) {
			fighterTypes.add(type.getTypeClass());
		}
		
		return units.
		stream().
		filter(x->!fighterTypes.contains(x.getClass()) && x.isAlive()).
		findFirst().
		orElse(null);
	}
	
	@Override
	public void moveUnits() {
		if(warloard!=null) {
		    clearFromDeadUnit();
			if(currentFighter==null || !currentFighter.isAlive())
				warloard.chooseCurrentFighter();
			
			warloard.sortRestOfArmy();
		}
	}
	
	protected void clearFromDeadUnit() {
		List<AbstractFighter> aliveFighters=units.stream()
				                                 .filter(AbstractFighter::isAlive)
				                                 .collect(Collectors.toList());
		
		units=new ArrayDeque<>(aliveFighters);
	}
}
