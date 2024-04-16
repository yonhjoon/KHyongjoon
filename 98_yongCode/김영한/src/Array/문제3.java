package Array;

import java.util.Scanner;

public class 문제3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5개의 정수를 입력하세요 : ");
		
		int[] A = new int[5];
		int total = 0;
		int avg = 0;
		
		for(int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i = 0; i < A.length; i++) {
			total += A[i];
		}
		
		avg = total/A.length;
		
		System.out.println("입력한 정수의 합계 : " + total);
		System.out.println("입력한 정수의 평균 : " + avg);
	}
}
