package com.kh.Array;

import java.util.Scanner;

public class Array01 {
	public static void main(String[] args) {
		/* 
		 * 변수선언 방법 :      자료형 변수이름; ex) int num;
		 * 					 변수이름 = 값;      num = 5;
		 * 
		 * 배열선언 방법 :		자료형[] 배열이름;  		ex) int[] arr;
		 * 					배열이름 = new 자료형[길이]; 		arr = new int[10];
		 * 
		 * 배열을 실제 사용할 때 -> index값을 이용해서 사용함
		 * index값은 0부터 (길이 -1) 
		 */
		
//		int[] arr1 = new int[10];
//		arr1[0] = 10;
//		arr1[1] = 15;
//		
//		// 1차원 배열은 보통 for과 함께 많이 사용된다.
//		// 필수로 알아둬야하는 공식 -> 배열의 모든 index값에 순차적으로 접근할 수 있는 방법
//		// 1. for (int i = 0; i < 배열의길이; ㅑ++) {실행할 코드}
//		for (int i = 0; i < arr1.length; i++) {
//			arr1[i] = i;
//		}
//		
//		// 2. for (int :n : 배열) {실행할 코드}
//		for (int n : arr1) {
//			System.out.println(n);
//		}
//		
//		// 길이가 5인 double형 배열 만들기
//		// 모든 index값에 3.14넣고 전부 출력하기
//		
//		double[] dArr = new double[5];
//		double d = 3.14;
//		
//		for (int i = 0;  i < dArr.length; i++) {
//			System.out.println(d);
//		}
		
		
		//길이가 6인 boolean형 배열 만들기
		//모든 index값에 true,false번 갈아가며 넣기
		//모든 index값에 들어있는 결과 출력하기
		
		
		// 코드엡에서 문제 -> 문제집 -> 기초5-1(1차원배열) ->
		// 1095, 1402, 1409, 1411, 1440
		
		Scanner sc= new Scanner(System.in);
//		int count = sc.nextInt();
//		sc.nextLine();
//		
//		int[] numArr = new int[23];
//		// [0,0,0,0,0,0,0,0,0,0,0, ... ]
//		for(int i = 0; i < count; i++) {
//			numArr[sc.nextInt() -1]++; // 1
//			//numArr[sc.nextInt() -1] += 1;	numArr[sc.nextInt() -1]++; numArr[sc.nextInt() +1]
//			// num += 1; num++; num + 1;
//			
//			int index = sc.nextInt() -1;
//			numArr[index] = numArr[index] +1;
//		}
			
//		for(int i = 0; i < count; i++) {
//			numArr[i] = sc.nextInt();
//		}
//		
//		for(int i =0; i < numArr.length; i++) {
//			System.out.print(numArr[i]+ " ");
//		}
		
		// 번호가 불릴때 긱번호가 총 몇회 호출됬는지 알고싶음
		
		
//		int[] num = new int[23];
//		int n = sc.nextInt();
//		sc.nextLine();
//		
//		for(int i = 0; i < n;i++) {
//			num[sc.nextInt()-1]++;
//		}
//		for(int i = 1; i < num.length; i++) 
//			System.out.println(num[i] + " ");
//		
//
//	}
//}
		int count = sc.nextInt(); //출석 번호를 부른 횟수
		int[] numArr = new int[23]; //  int 형 numArr배열[23] idex[23]
		
		for (int i = 0; i < count; i++) {
			int num = sc.nextInt(); //무작위로 부른 n개의 번호(1 ~ 23)
			numArr[num - 1] += 1;
		}
		sc.close();
		
		//출력
		for (int i = 0; i < numArr.length; i++) {
			System.out.printf("%d ", numArr[i]);
		}
	}
}
