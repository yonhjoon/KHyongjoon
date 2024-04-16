package Array;

import java.util.Scanner;

public class 문제1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] score = {90,80,70,60,50}; // 배열안에 숫자를 저장
		int total = 0; // 총합
		double average = 0; // 평균
		
		for(int i = 0 ; i < score.length; i++) {
			total += score[i]; //배열안에있는값을 total안에 전부 더해서 넣는다
		}
		
		average = total/score.length; //평균값은 총합의 값을 스코어의 길이만큼 나눈다
		
		System.out.println("점수 총합 : " + total);
		System.out.println("점수 평균 : " + average);
		
		//점수 총합 : 350
		//점수 평균 : 70.0


	}

}
