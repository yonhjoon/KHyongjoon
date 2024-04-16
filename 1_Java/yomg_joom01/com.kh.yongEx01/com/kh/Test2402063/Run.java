package com.kh.Test2402063;

public class Run {

	public static void main(String[] args) {
		//Human Class 하나 만들어주세요
		// 필드에서는 String name, int age, int mathScore, int enScort
		// toString, getter, setter
		
		
		//Human객체 3개를 생성하세요
		//내부에 값은 임의로 넣어주시면 됩니다.
		//클래스이름 객체이름 = new 생성자명();
		
		
		// 클래스이름 객체이름 = new 생성자명(매게변수);
		Human hmn = new Human("최지원", 20, 50 , 100);
		Human hmn1 = new Human("장용준", 27, 80 , 100);
		Human hmn2 = new Human();
		hmn2.setName("윤세련");
		hmn2.setAgr(26);
		hmn2.setMathScore(70);
		hmn2.setEnScort(90);
		
		System.out.println(hmn2.toString());
		System.out.println("========");
		System.out.println(hmn2); //toString을 안 적어도 자동으로 오버라이딩이 되어있어 출력된다.
		
		String name = hmn1.getName();
		
	}
}
