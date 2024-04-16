package com.kh.CodeUp;

public class Fruit {

	String tkrhk;
	String torRkf;
	
	public Fruit() {
		super();
	}
	
	public Fruit(String tkrhk, String torRkf) {
		super();
		this.tkrhk = tkrhk;
		this.torRkf = torRkf;
	}

	public String getTkrhk() {
		return tkrhk;
	}
	public void setTkrhk(String tkrhk) {
		this.tkrhk = tkrhk;
	}
	public String getTorRkf() {
		return torRkf;
	}
	public void setTorRkf(String torRkf) {
		this.torRkf = torRkf;
	}
	
	public String showInfo() {
		return "이름 : " + tkrhk + "색깔 : " + torRkf;
	}
	
	
}
