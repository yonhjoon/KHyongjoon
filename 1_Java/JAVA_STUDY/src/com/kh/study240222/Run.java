package com.kh.study240222;

public class Run {
		public static void mian(String[] args) {
			// 객체배열 : 객체를 저장하는 배열 -> 자료형이 클래스명으로 지정되어있다. (자료형이 클래스라 객체배열인거다)
			// 클래스명[] 배열명 = new 클래스명[배열의 길이]; -> 특정 객체를 담을 수 있는 공간 n개만큼 만들었다.
			
			//문자열(String)을 담을 수 있는 String 배열 10개를 만들어라
			//String[] strArr = new String[10];
			//실제로 사용하기 위해서는 각 공간마다 객체를 생성해줘야한다.
			//strArr[0] = new String("안녕")
			
			StudentMenu sm = new StudentMenu();
			System.out.println(sm);
	}
}
