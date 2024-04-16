package Array1차원;

import java.util.Scanner;

public class A01_가장큰값작은값구하기10818번 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 길이
		int[] num = new int[N]; // 배열
		
		
		for(int i = 0; i < N; i++) {
			num[i] = sc.nextInt(); // 배열안에 입력값 넣기
		}
		
		int min = num[0]; // 먼저 min안에 0번째 index넣어서 비교값 만들기
		for(int i = 0; i < N; i ++) {
			if(num[i] < min) { // num[i]번째보다 min[0]번쨰 값이 작으면 min안으로
				min = num[i];
			}
		}
		int max = num[0]; // 똑같이 0번째 index넣어서 비교값 만들기
		for(int i = 0; i < N; i ++) {
			if(num[i] > max) { // num[i]번째 보다 작으면 max안에 들어간다
				max = num[i];
			}
		}
		System.out.println(min + " " +max);

	}

}
