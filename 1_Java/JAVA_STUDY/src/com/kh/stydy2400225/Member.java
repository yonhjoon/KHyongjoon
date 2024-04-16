package com.kh.stydy2400225;

public class Member {

	private String id;
	private String name;
	private String passwprd;
	private String email;
	private char gender;
	private int age;
	
	
	public Member() {
		super();
	}


	public Member(String id, String name, String passwprd, String email, char gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.passwprd = passwprd;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPasswprd() {
		return passwprd;
	}


	public void setPasswprd(String passwprd) {
		this.passwprd = passwprd;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String inform() {
		return null;
	}
	
	@Override
	public String toString() { //Member 클래스의 모든 필드값들을 합쳐 반환
		return "Member [id=" + id + ", name=" + name + ", passwprd=" + passwprd + ", email=" + email + ", gender="
				+ gender + ", age=" + age + "]";
	}
	
	
	
}
