package org.nerdizin.jxp;

import org.apache.commons.jxpath.JXPathContext;
import org.junit.Test;
import org.nerdizin.jxp.entities.*;

import java.util.Iterator;

public class PathTest {

	private static JXPathContext CONTEXT = JXPathContext.newContext(createDungeon());

	@Test
	public void testDumpDungeon() {
		System.out.println(createDungeon());
	}

	@Test
	public void testBeanProperty() {

		final String result = (String) CONTEXT.getValue("name");
		System.out.println("Result: " + result);
	}

	@Test
	public void testLenient() {

		final JXPathContext context = JXPathContext.newContext(createDungeon());
		context.setLenient(true);

		final String result = (String) context.getValue("bogus");
		System.out.println("Result: " + result);

		context.setLenient(false);
		try {
			final String result2 = (String) context.getValue("bogus");
			System.out.println("Result: " + result2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNestedProperty() {

		final String result = (String) CONTEXT.getValue("master/name");
		System.out.println("Result: " + result);
	}

	@Test
	public void testCollection() {

		final String result = (String) CONTEXT.getValue("levels[1]/name");
		System.out.println("Result: " + result);
	}

	@Test
	public void testMultipleResults() {

		final Iterator it = CONTEXT.iterate("levels");
		while(it.hasNext()) {
			final Level level = (Level) it.next();
			System.out.println("Result: " + level.getName());
		}
	}

	@Test
	public void testMapElementAccess() {

		final String result = (String) CONTEXT.getValue("levels[1]/rooms[@name='2']/name");
		System.out.println("Result: " + result);
	}

	@Test
	public void testDomAccess1() {

		final String result = (String) CONTEXT.getValue("levels[1]/rooms[@name='2']/monster/definition/monster/weapon");
		System.out.println("Result: " + result);
	}

	@Test
	public void testDomAccess2() {

		final Object result = CONTEXT.selectSingleNode("levels[1]/rooms[@name='2']/monster/definition/monster/armor");
		System.out.println("Result: " + result);
		System.out.println("Result: " + result.getClass());
	}

	private static Dungeon createDungeon() {

		final Dungeon dungeon = new Dungeon("Mines of Moria");
		dungeon.setMaster(new Master("Lord Scorn"));
		final Level level1 = new Level("Level 1");
		final Level level2 = new Level("Level 2");
		final Level level3 = new Level("Level 3");
		dungeon.addLevel(level1);
		dungeon.addLevel(level2);
		dungeon.addLevel(level3);

		final Room room1 = new Room("1", "Tunnel");
		level1.addRoom(room1);
		final Room room2 = new Room("2", "Little cave");
		level1.addRoom(room2);
		final Room room3 = new Room("3", "Staircase down");
		level1.addRoom(room3);

		final Room room4 = new Room("4", "Small hall");
		level2.addRoom(room4);
		final Room room5 = new Room("5", "Dark passage");
		level2.addRoom(room5);
		final Room room6 = new Room("6", "Slide down");
		level2.addRoom(room6);

		final Room room7 = new Room("7", "Dragon's lair");
		level3.addRoom(room7);

		final Monster goblin = new Monster("Goblin");
		goblin.setDefinition(MonsterDefinitionFactory.createMonsterDefinition(
				"Goblin", "Club", "None"));
		room2.setMonster(goblin);
		final Monster troll = new Monster("Troll");
		troll.setDefinition(MonsterDefinitionFactory.createMonsterDefinition(
				"Troll", "Rock", "Rough skin"));
		room4.setMonster(troll);
		final Monster dragon = new Monster("Dragon");
		dragon.setDefinition(MonsterDefinitionFactory.createMonsterDefinition(
				"Dragon", "Claws", "Scales"));
		room7.setMonster(dragon);

		return dungeon;
	}

}
