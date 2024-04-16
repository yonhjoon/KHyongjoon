package com.kh.Test2402063;

public class Human {
	//필드
	//접근제한자 자료형 변수이름
	String name;
	int age;
	int mathScore;
	int enScort;
	
	//생성자
	// 접근제한자 생성자명(매게변수){초기화}
	public Human() {
		super();
	}

	public Human(String name, int age, int mathScore, int enScort) {
		super();
		this.name = name;
		this.age = age;
		this.mathScore = mathScore;
		this.enScort = enScort;
	}
	
	//메소드
	//접근제한자 (static) 반환형 메소드이름(매게변수){메소드내용}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAgr() {
		return age;
	}

	public void setAgr(int agr) {
		this.age = agr;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEnScort() {
		// 반환형 : 리턴뒤에 어떤타입이 오냐
		//		   함수의 결과값으로 어떤 값을 보낼꺼냐?
		return enScort;
	}

	public void setEnScort(int enScort) {
		this.enScort = enScort;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\n나이 : " + age+ "세" + "\n수학점수 : " + mathScore + "점" + "\n영어점수 : " + enScort + "점" + "\n입니다.";
	}
	
	
	
}
