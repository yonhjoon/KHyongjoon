package com.kh.Test240213;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 홀수 짝수 출력하기
		
//		int num,sum;
//		for ( int i = 0; i <= 10; i ++) {
//			if(i%2 == 1 ) {
//				System.out.println("홀수 : "+i);
//			}else {
//				System.out.println("짝수 : "+i);
//			}
//		}
		
		
		// 랜덤으로 숫자 5개 입력받아 출력하기
		
		
//		for (int i = 0; i < 5; i++) {
//			System.out.println((int)(Math.random()* 100) + 1);
//		}
		
		//랜덤으로 숫자 10개 입력받아 짝수만 출력하기
		
//		for (int i =0; i < 10; i ++) {
//			int num = (int)(Math.random()*100);
//			if(num % 2 == 0) {
//				System.out.println(num);
//			}
//		}

		//문자열 입력받아서 문자열 한글자씩 출력하기
//		System.out.println("문자열 입력 : ");
//		String str = sc.next();
//		for (int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i));
//		}
		
		
		//문자열(영단어) 입력받아서 문자열 첫글자 대문자로 변경하기
//		System.out.println("문자열 입력 : ");
//		String str = sc.next();
//		str = str.substring(0,1).toUpperCase() + str.substring(1);
//		
//		System.out.println(str);
		
		
//		System.out.println("문자열 입력 : ");
//		String str = sc.next();
//		
//		str = str.substring(0, 1).toUpperCase() + str.substring(1);
//        System.out.println(str);
		
		
		//오버라이딩, 오버로딩 대한 문제
		//상속 관계에 있는 클래스 2개를 제공해주고 오버라이딩 메소드 출력시 어떤 결과가 출력되냐?
		
		// 오버라이딩 : 자식클래스가 상속받고 있는 부모 클래스의 메소드를 재정의(재작성) 하는 것이다.
		// 오버 로딩 : 매게변수 객수, 자료형, 순서가 동일하게 작성하는것
		
		//(오버라이딩)
		//클래스하나 주어진 상태에서 해당 클래스를 상속받는 새로운 클래스를 만들고 다음과 같은 결과가 되도록 오버라이딩을 해라
		
		//(오버로딩)
		//똑같은 이름의 메소드 한 10개 제공해주고 에러가 발생하는 이유를 기술해라
		
		// void sample(int n); -> sample(3); sample(5, 7.0); 해당 코드가 문제가 되지않도록 코드를 수정해라
		
		
		//배열 -> 길이가 정해져있는 것 -> 배열의 범위를 초과하는 코드조심
		//배열을 제공하고 모든 객체를 출력해라
		
//		int[] num = {12,33,5322,6123};
//		for (int i = 0; i < num.length; i ++) {
//			System.out.println(num[i]);
//		}
		
		//다형성 -> 다운캐스팅 조심
		
		//Human 을 담을 수 있는 ArrayList 1개를 생성하고 임의로 Human 객체 5개를 생성해서 담아라
		//단 해당 List 에는 Human 객체만 담을 수 있게 구성하세요.
		
		ArrayList<human> hum = new ArrayList<>();
		hum.add(new human());
		
		
		//(제네릭)
		//ArrayList<Human> arr = new ArrayList<>();
		//arr.add(new Human("최지원")); 
		//arr.add("김수민"); xxx
		
		//(IO)
		//파일에 내용 작성하기, 파일로부터 내용 가져오기
		//파일에 객체정보 저장하기(직렬화), 파일로부터 객체정보 가져오기(역직렬화)
		
		
		//udp또는 tcp에서 클라이언트, 서버 구성하게
		}	
}