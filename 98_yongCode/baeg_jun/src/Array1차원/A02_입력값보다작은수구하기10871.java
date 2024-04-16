package Array1차원;

import java.util.Scanner;

public class A02_입력값보다작은수구하기10871 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int A = sc.nextInt(); // 길이
		int[] num = new int[A]; // A길이를 담은 num배열
		int B = sc.nextInt(); // B보다 작은수 구하기
		
		for(int i = 0; i < A; i++) {
			num[i] = sc.nextInt(); // 배열안에 입력하기
		}
		
		for(int i = 0; i < A; i++) {
			if(num[i] < B) { // num[i]안에 있는 정수가 B보다 작다면
				System.out.print(num[i] + " "); // 출력 -- 반복문이라 A의 길이만큼 반복하며 출력한다
			}
		}
	}

}
