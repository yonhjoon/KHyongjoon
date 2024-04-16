package yomg_joom01;

import java.util.Scanner;

public class Run {

//	public void count() {
//		Scanner sc = new Scanner(System.in);
//		
//		while (false) {
//			System.out.println("문자열을 입력해주세요 : ");
//			String str = sc.next();
//			if(str == "exit") {
//				break;
//			}else {
//				System.out.println(str.length() + "글자 입니다.");
//			}
//		}
//		
//		System.out.println("프로그램 종료");
//		
//	}
//}

//public void count() {
//	Scanner sc = new Scanner(System.in);
//		// 1번째 false가 아닌 true가 들어와야한다 
//		// false일 경우 while문이 돌지않는다 while문은 true를 위한 문이다
//	while (true) {
//		System.out.println("문자열을 입력해주세요 : ");
//		String str = sc.next();
//		if(str.equals("exit")) { // String 은 equals로 해야된다.
//			break;
//		}else {
//			System.out.println(str.length()+ "글자 입니다.");
//		}
//	}
//	
//	System.out.println("프로그램 종료");
//	
//}






//	public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	
//	System.out.print("1~10 사이의 정수를 입력하세요 : ");
//	int num = sc.nextInt();
//	
//		for(int i = 1; i <= num; i++) {
//			if(num % 2 == 1) {
//			System.out.print(i + " ");
//	}else {
//		System.out.print("1과 10사이의 숫자가 아닙니다.");
//	}
//		}
//	
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~10 사이의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			if(i % 2 == 1) {
				System.out.print(i + " ");
			}if (i > 10 && i < 1){
				System.out.println("1과 10사이의 숫자가 아닙니다.");
			}
		}
		
	}
	
}