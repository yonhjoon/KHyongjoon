package com.kh.Test2401262;

public abstract class Animal {
	
	private String name;
	private	String kinds; 
	
	
	public Animal() {
		super();
	}
	
	public Animal(String name, String kinds) {
		super();
		this.name = name;
		this.kinds = kinds;
	}
	public abstract void speak();
	
	@Override
	public String toString() {
		return "저의 이름은" + this.name + "이고, 종류는 " + this.kinds + "입니다.";
}
}