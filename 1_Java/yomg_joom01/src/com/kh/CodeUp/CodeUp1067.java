package com.kh.CodeUp;

import java.util.Scanner;

public class CodeUp1067 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(); //a를 사용자로부터 입력받음
		
		if(a < 0) {//a가 0보다 작다면
			System.out.println("minus"); // minus 출력
			if(a % 2== 0) { // a가 짝수라면
				System.out.println("even"); //even출력
			}else { // 아니면
				System.out.println("odd"); //odd출력
			}
		}else { //아니면
			System.out.println("plus"); //plus출력
			if(a% 2 == 0) { // a가짝수이면
				System.out.println("even"); //even출력
			}else {// 아니면
				System.out.println("odd");//odd출력
			}
		}
	}
}
