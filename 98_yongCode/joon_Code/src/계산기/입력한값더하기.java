package 계산기;

import java.util.Scanner;

public class 입력한값더하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("더할 숫자의 갯수를 적으세요(10+20+30 : 3개) : ");
		int A =sc.nextInt();//더할 숫자 갯수
		
		int[] number = new int[A]; // A개만큼 숫자를 넣을거다
		int total = 0; //더한값
		
		System.out.println("더할 숫자를 입력하세요 : ");
		for(int i = 0; i < number.length; i++) {
			number[i] = sc.nextInt();
		}
		
		for(int i = 0; i < number.length; i++) {
			total += number[i];
		}
		System.out.print("더한 값 : " + total);

	}

}
