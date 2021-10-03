package fights;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fighters.Army;
import fighters.Battle;
import fighters.FighterType;
import fighters.Warrior;

public class BattleTest {

	@Test
	@DisplayName("Battle:1")
	public void test1() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.WARRIOR, 1);
	    army2.addUnits(FighterType.WARRIOR, 2);
	    assertFalse(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:2")
	public void test2() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.WARRIOR, 2);
	    army2.addUnits(FighterType.WARRIOR, 3);
	    
	    assertFalse(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:3")
	public void test3() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.WARRIOR, 5);
	    army2.addUnits(FighterType.WARRIOR, 7);
	    
	    assertFalse(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:4")
	public void test4() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.WARRIOR, 20);
	    army2.addUnits(FighterType.WARRIOR, 21);
	    
	    assertTrue(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:5")
	public void test5() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.WARRIOR, 10);
	    army2.addUnits(FighterType.WARRIOR, 11);
	    
	    assertTrue(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:6")
	public void test6() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.WARRIOR, 11);
	    army2.addUnits(FighterType.WARRIOR, 7);
	    
	    assertTrue(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:7")
	public void test7() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.WARRIOR, 5);
	    army1.addUnits(FighterType.DEFENDER, 4);
	    army1.addUnits(FighterType.DEFENDER, 5);
	    army2.addUnits(FighterType.WARRIOR, 4);
	    
	    assertTrue(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:8")
	public void test8() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.DEFENDER, 5);
	    army1.addUnits(FighterType.WARRIOR, 20);
	    army2.addUnits(FighterType.WARRIOR, 21);
	    army1.addUnits(FighterType.DEFENDER, 4);
	    
	    assertTrue(Battle.fight(army1, army2));
	}
	
	
	@Test
	@DisplayName("Battle:9")
	public void test9() {
		Army army1=new Army();
		Army army2=new Army();
		
		 army1.addUnits(FighterType.WARRIOR, 10);
		 army1.addUnits(FighterType.DEFENDER, 5);
		 army2.addUnits(FighterType.WARRIOR, 5);
		 army1.addUnits(FighterType.DEFENDER, 10);
	    
	    assertTrue(Battle.fight(army1, army2));
	}
	
	
	@Test
	@DisplayName("Battle:10")
	public void test10() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.DEFENDER, 2);
	    army1.addUnits(FighterType.WARRIOR, 1);
	    army1.addUnits(FighterType.DEFENDER, 1);
	    army2.addUnits(FighterType.WARRIOR, 5);
	    
	    assertFalse(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:11")
	public void test11() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.DEFENDER, 5);
	    army1.addUnits(FighterType.VAMPIRE, 6);
	    army1.addUnits(FighterType.WARRIOR, 7);
	    army2.addUnits(FighterType.WARRIOR, 6);
	    army2.addUnits(FighterType.DEFENDER, 6);
	    army2.addUnits(FighterType.VAMPIRE, 6);
	    
	    assertFalse(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:12")
	public void test12() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.DEFENDER, 2);
	    army1.addUnits(FighterType.VAMPIRE, 3);
	    army1.addUnits(FighterType.WARRIOR, 4);
	    army2.addUnits(FighterType.WARRIOR, 4);
	    army2.addUnits(FighterType.DEFENDER, 4);
	    army2.addUnits(FighterType.VAMPIRE, 3);
	    
	    assertFalse(Battle.fight(army1, army2));
	}
	
	
	@Test
	@DisplayName("Battle:13")
	public void test13() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.DEFENDER, 11);
	    army1.addUnits(FighterType.VAMPIRE, 3);
	    army1.addUnits(FighterType.WARRIOR, 4);
	    army2.addUnits(FighterType.WARRIOR, 4);
	    army2.addUnits(FighterType.DEFENDER, 4);
	    army2.addUnits(FighterType.VAMPIRE, 13);
	    
	    assertTrue(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:14")
	public void test14() {
		Army army1=new Army();
		Army army2=new Army();
		
	    army1.addUnits(FighterType.DEFENDER, 9);
	    army1.addUnits(FighterType.VAMPIRE, 3);
	    army1.addUnits(FighterType.WARRIOR, 8);
	    army2.addUnits(FighterType.WARRIOR, 4);
	    army2.addUnits(FighterType.DEFENDER, 4);
	    army2.addUnits(FighterType.VAMPIRE, 13);
	    
	    assertTrue(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:15")
	public void test15() {
		Army army1=new Army();
		Army army2=new Army();
		
		army1.addUnits(FighterType.LANCER, 5);
		army1.addUnits(FighterType.VAMPIRE, 3);
		army1.addUnits(FighterType.WARRIOR, 4);
		army1.addUnits(FighterType.DEFENDER, 2);
		army2.addUnits(FighterType.WARRIOR, 4);
		army2.addUnits(FighterType.DEFENDER, 4);
		army2.addUnits(FighterType.VAMPIRE, 6);
		army2.addUnits(FighterType.LANCER, 5);
	
	    assertFalse(Battle.fight(army1, army2));
	}
	
	
	@Test
	@DisplayName("Battle:16")
	public void test16() {
		Army army1=new Army();
		Army army2=new Army();
		
		army1.addUnits(FighterType.LANCER, 7);
		army1.addUnits(FighterType.VAMPIRE, 3);
		army1.addUnits(FighterType.WARRIOR, 4);
		army1.addUnits(FighterType.DEFENDER, 2);
		army2.addUnits(FighterType.WARRIOR, 4);
		army2.addUnits(FighterType.DEFENDER, 4);
		army2.addUnits(FighterType.VAMPIRE, 6);
		army2.addUnits(FighterType.LANCER, 4);
	
	    assertTrue(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:17")
	public void test17() {
		Army army1=new Army();
		Army army2=new Army();
		
		army1.addUnits(FighterType.LANCER, 7);
		army1.addUnits(FighterType.VAMPIRE, 3);
		army1.addUnits(FighterType.HEALER, 1);
		army1.addUnits(FighterType.WARRIOR, 4);
		army1.addUnits(FighterType.HEALER, 1);
		army1.addUnits(FighterType.DEFENDER, 2);
		army2.addUnits(FighterType.WARRIOR, 4);
		army2.addUnits(FighterType.DEFENDER, 4);
		army2.addUnits(FighterType.HEALER, 1);
		army2.addUnits(FighterType.VAMPIRE, 6);
		army2.addUnits(FighterType.LANCER, 4);
	
	    assertTrue(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:18")
	public void test18() {
		
		Army army1=new Army();
		Army army2=new Army();
		
		army1.addUnits(FighterType.LANCER, 1);
		army1.addUnits(FighterType.WARRIOR, 3);
		army1.addUnits(FighterType.HEALER, 1);
		army1.addUnits(FighterType.WARRIOR, 4);
		army1.addUnits(FighterType.HEALER, 1);
		army1.addUnits(FighterType.KNIGHT, 2);
		
		army2.addUnits(FighterType.WARRIOR, 4);
		army2.addUnits(FighterType.DEFENDER, 4);
		army2.addUnits(FighterType.HEALER, 1);
		army2.addUnits(FighterType.VAMPIRE, 6);
		army2.addUnits(FighterType.LANCER, 4);
	
	    assertFalse(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:19")
	public void test19() {
		
		Army army1=new Army();
		Army army2=new Army();
		
		army1.addUnits(FighterType.LANCER, 5);
		army1.addUnits(FighterType.VAMPIRE, 3);
		army1.addUnits(FighterType.WARRIOR, 4);
		army1.addUnits(FighterType.DEFENDER, 2);
		
		army2.addUnits(FighterType.WARRIOR, 4);
		army2.addUnits(FighterType.DEFENDER, 4);
		army2.addUnits(FighterType.VAMPIRE, 6);
		army2.addUnits(FighterType.LANCER, 5);
	
	    assertFalse(Battle.straightFight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:20")
	public void test20() {
		
		Army army1=new Army();
		Army army2=new Army();
		
		army1.addUnits(FighterType.LANCER, 7);
		army1.addUnits(FighterType.VAMPIRE, 3);
		army1.addUnits(FighterType.WARRIOR, 4);
		army1.addUnits(FighterType.DEFENDER, 2);
		
		army2.addUnits(FighterType.WARRIOR, 4);
		army2.addUnits(FighterType.DEFENDER, 4);
		army2.addUnits(FighterType.VAMPIRE, 6);
		army2.addUnits(FighterType.LANCER, 4);
	
	    assertTrue(Battle.straightFight(army1, army2));
	}
	
	
	@Test
	@DisplayName("Battle:21")
	public void test21() {
		
		Army army1=new Army();
		Army army2=new Army();
		
		army1.addUnits(FighterType.LANCER, 7);
		army1.addUnits(FighterType.VAMPIRE, 3);
		army1.addUnits(FighterType.HEALER, 1);
		army1.addUnits(FighterType.WARRIOR, 4);
		army1.addUnits(FighterType.HEALER, 1);
		army1.addUnits(FighterType.DEFENDER, 2);
		
		army2.addUnits(FighterType.WARRIOR, 4);
		army2.addUnits(FighterType.DEFENDER, 4);
		army2.addUnits(FighterType.HEALER, 1);
		army2.addUnits(FighterType.VAMPIRE, 6);
		army2.addUnits(FighterType.LANCER, 4);
	
	    assertFalse(Battle.straightFight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:22")
	public void test22() {
		
		Army army1=new Army();
		Army army2=new Army();
		
		army1.addUnits(FighterType.WARLOARD, 1);
		army1.addUnits(FighterType.WARLOARD, 2);
		army1.addUnits(FighterType.LANCER, 2);
		army1.addUnits(FighterType.HEALER, 2);
		
		army2.addUnits(FighterType.WARLOARD, 1);
		army2.addUnits(FighterType.VAMPIRE, 1);
		army2.addUnits(FighterType.HEALER, 2);
		army1.addUnits(FighterType.KNIGHT, 2);
	
	    assertTrue(Battle.straightFight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:23")
	public void test23() {
		
		Army army1=new Army();
		Army army2=new Army();
		
		army1.addUnits(FighterType.WARLOARD, 1);
		army1.addUnits(FighterType.WARRIOR, 2);
		army1.addUnits(FighterType.LANCER, 2);
		army1.addUnits(FighterType.HEALER, 2);
		
		army2.addUnits(FighterType.WARLOARD, 1);
		army2.addUnits(FighterType.VAMPIRE, 1);
		army2.addUnits(FighterType.HEALER, 2);
		army2.addUnits(FighterType.KNIGHT, 2);
	
	    assertTrue(Battle.fight(army1, army2));
	}
	
	@Test
	@DisplayName("Battle:24")
	public void test24() {
		
		Army army1=new Army();
		Army army2=new Army();
		
		army1.addUnits(FighterType.WARRIOR, 2);
		army1.addUnits(FighterType.LANCER, 2);
		army1.addUnits(FighterType.DEFENDER, 1);
		army1.addUnits(FighterType.WARLOARD, 3);
		
		army2.addUnits(FighterType.WARLOARD, 2);
		army2.addUnits(FighterType.VAMPIRE, 1);
		army2.addUnits(FighterType.HEALER, 5);
		army2.addUnits(FighterType.KNIGHT, 2);
	
	    assertFalse(Battle.fight(army1, army2));
	}
	
}
