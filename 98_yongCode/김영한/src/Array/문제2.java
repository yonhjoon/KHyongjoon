package Array;

import java.util.Scanner;

public class 문제2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5개의 정수를 입력하세요 : ");
		int[] num = new int[5]; //입력받을 수의 배열생성
		
		for(int i = 0; i < num.length; i ++) {
			num[i] = sc.nextInt(); //반복문을 통해 배열안에 값을 입력한다
		}
		System.out.println("출력"); // 출력문은 한번만 출력되야하므로 for문 밖에서 한다
		
		for(int i =0; i < num.length; i++) {
			System.out.print(num[i]); // 넣은값들을 보여준다
			if(i<num.length -1) { // 만약 i가 num의 길이의 -1 이면
				System.out.print(", "); // , 를 넣어라
				
				//5개의 정수를 입력하세요 : 
				//1
				//2
				//3
				//4
				//5
				//출력
				//1, 2, 3, 4, 5
			}
		}
	}

}
