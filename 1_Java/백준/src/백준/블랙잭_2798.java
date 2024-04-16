package 백준;

import java.util.Scanner;

public class 블랙잭_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int A = sc.nextInt(); // 카드갯수
		int B = sc.nextInt();  // 블랙잭 (넘지않고 제일 근접한 숫자)
		int C = 0; // 3개 수의 합
		int D = 0; // 제일 가까운 수 저장
		
		int[] num = new int[A]; // 카드갯수를 담는 객체배열
		
		for(int i = 0; i < A; i ++) { //입력받은 A의 갯수만큼 반복하면서
			num[i] = sc.nextInt(); // 입력한 숫자를 num의 i번째 배열에 저장
		}
		
		for(int i = 0; i < A; i++) {  // 1번쨰 카드 반복
			for(int j = i; j < A; j++) { //2번째 카드 반복
				for(int m = j; m < A; m++) { //3번째 카드 반복
					C = (num[i]+num[j]+num[m]); // 1,2,3번째 안에 들어있는 값들을 꺼내 다 합친 후 C에 넣는다.
					if(C < B && C > D) {
						D = C;
					}
				}
			}
		}
		
		System.out.print(D);
		
		
	}
}