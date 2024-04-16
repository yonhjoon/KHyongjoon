package A_연습문제복습;

import java.util.Scanner;

public class For {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i < 13; i++) {
			if(i % 3 == 0) {
				System.out.println(i);
			}
		}
	}
}