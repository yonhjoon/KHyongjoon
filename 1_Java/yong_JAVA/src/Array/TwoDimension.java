package Array;

public class TwoDimension {

	public static void main(String[] args) {
		
		// int[][] arr = new int [2][3];
		/*
		 * int : 자료형
		 * arr : 배열이름
		 * [2] : 행 갯수
		 * [3] : 열 갯수
		 */
		
		// 2차원 배열 선언과 동시에 초기화
//		int[][] arr = {{1,2,3},{4,5,6}};
//		
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println(); // 행 출력 끝난 후 안 줄 띄움
//		}
		
		
		
		// 이차원 배열 연습   알파벳 소문자를 2글자씩 13줄(13행 2열)로 출력하는 프로그램을 이차원 배열로 구현해보자!!
		
//		char[][] ch = {{'a','b','c','d','e','f','g','h','i','j','k','l','m',},{'n','o','p','q','r','s','t','u','v','w','x','y','z'}};
//			for(char i = 'a'; 'a' < ch.length; ) {
//				for(char j = 'b'; 'b' < ch['a'].length; ) {
//					System.out.println(ch['a']['b']);
//				}
//				System.out.println(ch[i][j]);
//		}
		
			char[][] charArr = {{'a','b'},{'c','d'},{'e','f'},{'g','h'},{'i','j'},{'k','l'},{'m','n'},{'o','p'},{'q','r'},{'s','t'},{'u','v'},{'w','x'},{'y','z'}};
			for(int i = 0; i < charArr.length; i++) {
				for(int j = 0; j < charArr[i].length; j++) {
			    	char ch = charArr[i][j];
			        System.out.print(ch + " ");
			    }
			    System.out.println();		//줄바꿈용
			}
	}

}
