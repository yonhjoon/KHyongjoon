package yomg_joom01;

import java.util.Scanner;

public class A_구구단 {

	//스케너 입력받고
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	int num;
	
	System.out.print("정수를 입력 : ");
		num=sc.nextInt();
	
	//정수 num을 입력받고
	
	for (int i = 2; i < 10; i++) {
		//2*1 2*2 2*3...2*9
		if(i % 2 !=0) {
			continue;
		}
		for(int j = 1; j < 10; j++) {
			System.out.printf("%d * %d = %d\n", i , j, i*j);
		}
		System.out.println(" ");
	}
	//반복문을 통해 한다 i = 2단 부터 i < 10 9단까지 i++ +1증감 ++은 무조건 1 증감
	// if 로 홀수 혹은 짝수를 진실 혹은 거짓 으로 조건을 건다 ( i % 2 !=0) i를 2로 나눴을때 0으로 나오지 않는
	// continue 로 아래 반복문은 보지않고 출력
	//for 안에 for 을 만들어 어떤 정수를 곱할지를 정한다
	}
}
