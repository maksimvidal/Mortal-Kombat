package fights;

import org.junit.jupiter.api.Test;

import driver.MortalKombat;
import warriors.Knight;
import warriors.Warrior;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

public class FightTest {

	@Test
	public void test1() {
        Warrior carl=new Warrior();
        Knight jim=new Knight();
        assertFalse(MortalKombat.fight(carl, jim));
        
	}

	@Test
	public void test2() {
		 Warrior slavine=new Warrior();
	     Knight raimon=new Knight();
	     assertTrue(MortalKombat.fight(raimon, slavine));
	}

	@Test
	public void test3() {
		Warrior bob=new Warrior();
		Warrior mars=new Warrior();
		assertTrue(MortalKombat.fight(bob, mars));
	}

	@Test
	public void test4() {
		Warrior godkiller=new Warrior();
	    Knight zeus=new Knight();
	    assertTrue(MortalKombat.fight(zeus, godkiller));
	}

	@Test
	public void test5() {
		Warrior husband=new Warrior();
		Warrior wife=new Warrior();
		assertTrue(MortalKombat.fight(husband, wife));
	}
	
	@Test
	public void test6() {
		Warrior dragon=new Warrior();
	    Knight knight=new Knight();
	    assertTrue(MortalKombat.fight(knight, dragon));
	}
	
	@Test
	public void test7() {
		Warrior unit_1=new Warrior();
	    Knight unit_2=new Knight();
	    Warrior unit_3=new Warrior();
	    
	    MortalKombat.fight(unit_1, unit_2);
	    assertFalse(MortalKombat.fight(unit_2, unit_3));
	}
}
