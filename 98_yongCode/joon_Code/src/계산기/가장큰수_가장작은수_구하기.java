package 계산기;

import java.util.Scanner;

public class 가장큰수_가장작은수_구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int min;
		int max;
		
		System.out.println("입력받을 숫자의 개수를 입력하세요 : ");
		int A = sc.nextInt();
		int[] number = new int[A];
		
		System.out.println(A + "개의 정수를 입력하세요 : ");
		
		for(int i = 0; i < number.length; i++) {
			number[i] = sc.nextInt(); 
		}
		min = max = number[0];
		
		for(int i = 1; i < A; i++) {
			if(number[i] < min) {
				min = number[i];
			}
			if(number[i] > max) {
				max = number[i];
			}
		}
		System.out.println("가장 작은 정수: " + min);
		System.out.println("가장 큰 정수: " + max);

	}

}
