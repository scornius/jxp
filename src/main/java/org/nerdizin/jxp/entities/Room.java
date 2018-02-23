package org.nerdizin.jxp.entities;

import java.util.HashSet;
import java.util.Set;

public class Room {

	private String id;
	private String name;
	private Monster monster;

	public Room(final String id, final String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(final Monster monster) {
		this.monster = monster;
	}

	@Override
	public String toString() {
		return "Room{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", monster=" + monster + '}';
	}
}
