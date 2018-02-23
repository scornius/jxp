package org.nerdizin.jxp.entities;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {

	private String name;
	private Master master;
	private List<Level> levels = new ArrayList<Level>();

	public Dungeon(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(final List<Level> levels) {
		this.levels = levels;
	}

	public void addLevel(final Level level) {
		this.levels.add(level);
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(final Master master) {
		this.master = master;
	}

	@Override
	public String toString() {
		return "Dungeon{" + "name='" + name + '\'' + ", master=" + master + ", levels=" + levels + '}';
	}
}
