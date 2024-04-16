package com.kh.Test2402063;

public class yongHuman {

	private String name;
	private int age;
	private String PhoneNumber;
	private String address;
	
	public yongHuman(String name, int age, String phoneNumber, String address) {
		super();
		this.name = name;
		this.age = age;
		PhoneNumber = phoneNumber;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\n나이 : " + age + "\n핸드폰 번호 : " + PhoneNumber + "\n사는곳 : " + address
				+ "입니다.\n======================================";
	}
	
	
	
	
}
	