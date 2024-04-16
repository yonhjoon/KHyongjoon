package Array1차원;

import java.util.Scanner;

public class A04_가장큰수및몇번째인지2562번 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9]; // 서로다른 9개의 정수를 담을 배열
		
		int max = arr[0]; // 최대값 담을 변수
		int count = 0; // 최대값 위치를 담는 변수
		for(int i = 0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			if(max < arr[i]) { // 0번째 index에있는 max값보다 크다면 
				max = arr[i]; // max안에 넣는다
				count = i+1; // 그러면서 count안에 i번째 즉 인덱스순서값에 +1을 하여 1번부터 올라가게한다
			}
		}
		System.out.println("가장 큰수 :"+max);
		System.out.println("이값은 "+count + "번째 수이다");
		
	}

}
