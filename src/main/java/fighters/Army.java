package fighters;

import java.lang.reflect.Constructor;
import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;

public class Army implements CombatArmy{

    protected Deque<AbstractFighter> units=new ArrayDeque<>();
	protected AbstractFighter currentFighter;
    
    @Override
	public void addUnits(FighterType type, int number) {
		try {
			var constructor=type.getTypeClass().getConstructor();
			for (int i = 0; i < number; i++) {
				AbstractFighter fighter=constructor.newInstance();
				units.add(fighter);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
     AbstractFighter getUnit() {  	 
    	   if (currentFighter==null ||!currentFighter.isAlive())
    		   currentFighter=units.poll();
    	   return currentFighter;
    	   
    }
    
    boolean hasUnits() {
    	if(units.isEmpty())
    		return currentFighter.isAlive();
    	return !units.isEmpty();
    }
}
