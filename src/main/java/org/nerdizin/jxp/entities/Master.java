package org.nerdizin.jxp.entities;

public class Master {

	private String name;

	public Master(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Master{" + "name='" + name + '\'' + '}';
	}
}
