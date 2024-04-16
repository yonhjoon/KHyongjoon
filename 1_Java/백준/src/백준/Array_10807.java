package 백준;

import java.util.Scanner;

public class Array_10807 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 길이값 입력
		int[] num = new int[N]; // N의 길이인 num배열
		int count = 0; // 같은수를 발견했을때 올라가는 count
		
		for(int i = 0; i < N; i++) { 
			// 반복문을 통해
			num[i] = sc.nextInt(); //num배열안에 값 입력후
			// index안에 순서대로 저장
		}
		int V = sc.nextInt(); // 같은값인지 비교할 값
		
		for(int i = 0; i < num.length; i++) {
			// 반복문을 통해
			if(V == num[i]) {
				// 안에있는 값이 V(비교값)랑 같다면
				count += 1;
				// count안에 1개씩 더해서 넣는다
				
				//반복문안에 있으므로 num의 길이만큼 반복을 하며 for에 들어와 if문을 돌며
				// 조건이 맞다면 count에 +1 을 넣는다
			}
		}
		System.out.println(count);
		// 그 다음 값 비교후 +된 값을 출력
	}
}