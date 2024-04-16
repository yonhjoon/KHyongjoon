package com.kh.CodeUp;

import java.util.Scanner;

public class Rum {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = " ";
			
		while ( !str.equals("exit") ) {
			System.out.print("문자열 입력 :");
			str = sc.next();
			if ( !str.equals("exit"))
				System.out.println(str.length() + "글자 입니다.");
				}
			
			System.out.println("종료합니다");
					
		}

	}
		
//		System.out.println("문자열 입력 : ");
//		String str = sc.next();
//		
//		while(str == ("exit") {
//			System.out.println("프로그램을 종료합니다.");
//			
//			break;
//		}if(str != "exit") {
//			System.out.println(str.length() + "글자입니다.");
//		}
//	}
