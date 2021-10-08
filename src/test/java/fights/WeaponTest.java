package fights;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fighters.AbstractFighter;
import fighters.Army;
import fighters.Battle;
import fighters.Defender;
import fighters.FighterType;
import fighters.GreatAxe;
import fighters.Healer;
import fighters.Katana;
import fighters.Knight;
import fighters.Lancer;
import fighters.MagicWand;
import fighters.Shield;
import fighters.Sword;
import fighters.Vampire;
import fighters.Warrior;
import fighters.Weapon;

public class WeaponTest {

	@Test
	@DisplayName("Weapon 1")
	void test1() {
		Warrior unit1 = new Warrior();
		Vampire unit2 = new Vampire();

		Weapon weapon1 = new Weapon(-10, 5, 0, 40, 0);
		Sword weapon2 = new Sword();

		unit1.equipWeapon(weapon1);
		unit2.equipWeapon(weapon2);

		assertTrue(Battle.fight(unit1, unit2));
	}

	@Test
	@DisplayName("Weapon 2")
	void test2() {
		Defender unit1 = new Defender();
		Lancer unit2 = new Lancer();

		Shield weapon1 = new Shield();
		GreatAxe weapon2 = new GreatAxe();

		unit1.equipWeapon(weapon1);
		unit2.equipWeapon(weapon2);

		assertFalse(Battle.fight(unit1, unit2));
	}

	@Test
	@DisplayName("Weapon 3")
	void test3() {
		Healer unit1 = new Healer();
		Knight unit2 = new Knight();

		MagicWand weapon1 = new MagicWand();
		Katana weapon2 = new Katana();

		unit1.equipWeapon(weapon1);
		unit2.equipWeapon(weapon2);

		assertFalse(Battle.fight(unit1, unit2));
	}

	@Test
	@DisplayName("Weapon 4")
	void test4() {
		Defender unit1 = new Defender();
		Vampire unit2 = new Vampire();

		Shield weapon1 = new Shield();
		MagicWand weapon2 = new MagicWand();
		Shield weapon3 = new Shield();
		Katana weapon4 = new Katana();

		unit1.equipWeapon(weapon1);
		unit1.equipWeapon(weapon2);
		unit2.equipWeapon(weapon3);
		unit2.equipWeapon(weapon4);

		assertFalse(Battle.fight(unit1, unit2));
	}

	@Test
	@DisplayName("Weapon 5")
	void test5() {
		MagicWand weapon1 = new MagicWand();
		GreatAxe weapon2 = new GreatAxe();

		Army myArmy = new Army();
		Army enemyArmy = new Army();

		myArmy.addUnits(FighterType.KNIGHT, 1);
		myArmy.addUnits(FighterType.LANCER, 1);
		enemyArmy.addUnits(FighterType.VAMPIRE, 1);
		enemyArmy.addUnits(FighterType.HEALER, 1);

		myArmy.get(0).equipWeapon(weapon1);
		myArmy.get(1).equipWeapon(weapon2);
		enemyArmy.get(0).equipWeapon(weapon1);
		enemyArmy.get(1).equipWeapon(weapon2);

		assertTrue(Battle.fight(myArmy, enemyArmy));
	}

	@Test
	@DisplayName("Weapon 6")
	void test6() {
		Sword weapon1 = new Sword();
		GreatAxe weapon2 = new GreatAxe();

		Army myArmy = new Army();
		Army enemyArmy = new Army();

		myArmy.addUnits(FighterType.DEFENDER, 1);
		myArmy.addUnits(FighterType.WARRIOR, 1);
		enemyArmy.addUnits(FighterType.KNIGHT, 1);
		enemyArmy.addUnits(FighterType.HEALER, 1);

		myArmy.get(0).equipWeapon(weapon2);
		myArmy.get(1).equipWeapon(weapon2);
		enemyArmy.get(0).equipWeapon(weapon1);
		enemyArmy.get(1).equipWeapon(weapon1);

		assertTrue(Battle.fight(myArmy, enemyArmy));
	}

	@Test
	@DisplayName("Weapon 7")
	void test7() {
		Katana weapon1 = new Katana();
		Shield weapon2 = new Shield();

		Army myArmy = new Army();
		Army enemyArmy = new Army();

		myArmy.addUnits(FighterType.DEFENDER, 2);
		enemyArmy.addUnits(FighterType.KNIGHT, 1);
		enemyArmy.addUnits(FighterType.VAMPIRE, 1);

		myArmy.get(0).equipWeapon(weapon1);
		myArmy.get(1).equipWeapon(weapon1);
		enemyArmy.get(0).equipWeapon(weapon1);
		enemyArmy.get(1).equipWeapon(weapon1);

		assertFalse(Battle.fight(myArmy, enemyArmy));
	}

	@Test
	@DisplayName("Weapon 8")
	void test8() {
		Weapon weapon1 = new Weapon(-20, 6, 1, 40, -2);
		Weapon weapon2 = new Weapon(20, -2, 2, -55, 3);

		Army myArmy = new Army();
		Army enemyArmy = new Army();

		myArmy.addUnits(FighterType.KNIGHT, 3);
		enemyArmy.addUnits(FighterType.WARRIOR, 1);
		enemyArmy.addUnits(FighterType.DEFENDER, 2);

		myArmy.get(0).equipWeapon(weapon1);
		myArmy.get(1).equipWeapon(weapon1);
		myArmy.get(2).equipWeapon(weapon2);
		enemyArmy.get(0).equipWeapon(weapon1);
		enemyArmy.get(1).equipWeapon(weapon2);
		enemyArmy.get(2).equipWeapon(weapon2);

		assertTrue(Battle.fight(myArmy, enemyArmy));
	}

	@Test
	@DisplayName("Weapon 9")
	void test9() {
		Weapon weapon1 = new Weapon(-20, 6, 1, 40, -2);
		Weapon weapon2 = new Weapon(20, -2, 2, -55, 3);

		Army myArmy = new Army();
		Army enemyArmy = new Army();

		myArmy.addUnits(FighterType.VAMPIRE, 3);
		enemyArmy.addUnits(FighterType.WARRIOR, 1);
		enemyArmy.addUnits(FighterType.DEFENDER, 2);

		myArmy.get(0).equipWeapon(weapon1);
		myArmy.get(1).equipWeapon(weapon1);
		myArmy.get(2).equipWeapon(weapon2);
		enemyArmy.get(0).equipWeapon(weapon1);
		enemyArmy.get(1).equipWeapon(weapon2);
		enemyArmy.get(2).equipWeapon(weapon2);
	}

	@Test
	@DisplayName("Weapon 11")
	void test11() {
		Sword weapon1 = new Sword();
		GreatAxe weapon2 = new GreatAxe();

		Army myArmy = new Army();
		Army enemyArmy = new Army();

		myArmy.addUnits(FighterType.VAMPIRE, 3);
		enemyArmy.addUnits(FighterType.WARRIOR, 1);
		enemyArmy.addUnits(FighterType.DEFENDER, 1);

		myArmy.get(0).equipWeapon(weapon2);
		myArmy.get(1).equipWeapon(weapon2);
		myArmy.get(2).equipWeapon(weapon2);
		enemyArmy.get(0).equipWeapon(weapon1);
		enemyArmy.get(1).equipWeapon(weapon1);

		assertTrue(Battle.fight(myArmy, enemyArmy));
	}

}
