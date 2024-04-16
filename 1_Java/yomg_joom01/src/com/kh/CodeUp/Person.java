package com.kh.CodeUp;

public class Person {

	 String Name = "장용준";

	public Person(String name) {
		super();
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Person [Name=" + Name + "]";
	}
	
	

}
