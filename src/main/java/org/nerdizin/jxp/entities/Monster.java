package org.nerdizin.jxp.entities;

import org.w3c.dom.Document;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Monster {

	private String name;
	private Document definition;

	public Monster(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Document getDefinition() {
		return definition;
	}

	public void setDefinition(final Document definition) {
		this.definition = definition;
	}

	@Override
	public String toString() {

		String definitionString = "";
		if (definition != null) {
			try {
				definitionString =
					MonsterDefinitionFactory.printDocument(getDefinition(), System.out);
			} catch (IOException | TransformerException e) {
				e.printStackTrace();
			}
		}

		return "Monster{" + "name='" + name + '\'' +
				", definition=" + definitionString + '}';
	}
}
