package tn.cynapsys.entities;

import javax.persistence.Embeddable;

@Embeddable
public class City {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
