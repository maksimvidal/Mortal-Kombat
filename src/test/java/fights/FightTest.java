package fights;

import org.junit.jupiter.api.Test;

import fighters.Army;
import fighters.Battle;
import fighters.Defender;
import fighters.Knight;
import fighters.Vampire;
import fighters.Warlord;
import fighters.Warrior;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.DefaultCellEditor;

import org.junit.jupiter.api.DisplayName;

public class FightTest {

	@Test
	public void test1() {
		Warrior carl = new Warrior();
		Knight jim = new Knight();
		assertFalse(Battle.fight(carl, jim));

	}

	@Test
	public void test2() {
		Warrior slavine = new Warrior();
		Knight raimon = new Knight();
		assertTrue(Battle.fight(raimon, slavine));
	}

	@Test
	public void test3() {
		Warrior bob = new Warrior();
		Warrior mars = new Warrior();
		assertTrue(Battle.fight(bob, mars));
	}

	@Test
	void test4() {
		Warrior godkiller = new Warrior();
		Knight zeus = new Knight();
		assertTrue(Battle.fight(zeus, godkiller));
	}

	@Test
	void test5() {
		Warrior husband = new Warrior();
		Warrior wife = new Warrior();
		assertTrue(Battle.fight(husband, wife));
	}

	@Test
	void test6() {
		Warrior dragon = new Warrior();
		Knight knight = new Knight();
		assertTrue(Battle.fight(knight, dragon));
	}

	@Test
	void test7() {
		Warrior unit_1 = new Warrior();
		Knight unit_2 = new Knight();
		Warrior unit_3 = new Warrior();

		Battle.fight(unit_1, unit_2);
		assertFalse(Battle.fight(unit_2, unit_3));
	}

	@Test
	void test8() {
		Defender unit1 = new Defender();
		Warlord unit2 = new Warlord();

		assertFalse(Battle.fight(unit1, unit2));
	}

	@Test
	void test9() {
		Warlord unit1 = new Warlord();
		Vampire unit2 = new Vampire();

		assertTrue(Battle.fight(unit1, unit2));
	}

	@Test
	void test10() {
		Warlord unit1 = new Warlord();
		Knight unit2 = new Knight();

		assertTrue(Battle.fight(unit1, unit2));
	}
}
