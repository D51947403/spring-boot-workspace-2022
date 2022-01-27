package com.singraul.versioning.model;

public class StudentV2 {
	private Name name;

	
	public StudentV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return this.name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}
