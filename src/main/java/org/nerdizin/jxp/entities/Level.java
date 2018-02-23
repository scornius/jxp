package org.nerdizin.jxp.entities;

import java.util.HashMap;
import java.util.Map;

public class Level {

	private String name;
	private Map<String, Room> rooms = new HashMap<String,Room>();

	public Level(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Map<String,Room> getRooms() {
		return rooms;
	}

	public void setRooms(final Map<String,Room> rooms) {
		this.rooms = rooms;
	}

	public void addRoom(final Room room) {
		this.rooms.put(room.getId(), room);
	}

	@Override
	public String toString() {
		return "Level{" + "name='" + name + '\'' + ", rooms=" + rooms + '}';
	}
}
