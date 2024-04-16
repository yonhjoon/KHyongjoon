package Array;

import java.util.Scanner;

public class 문제4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력받을 숫자의 개수를 입력하세요 : ");
		int A = sc.nextInt();
		
		System.out.println(A+"개의 정수를 입력하세요");
		
		int[] B = new int[A];
		int total = 0;
		
		for(int i = 0; i < B.length; i++) {
			B[i] = sc.nextInt();
			total += B[i];
		}
		
		double avg = total/B.length;
		
		System.out.println("입력한 정수의 합계 : " + total);
		System.out.println("입력한 정수의 평균 : " + avg);

	}

}
