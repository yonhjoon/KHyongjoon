package Array;

public class TwoDimension2 {
	public static void main(String[] args) {
		int[][] arr = new int[2][3]; //2행3열 이차원 배열 선언
		
		for(int i = 0; i < arr.length; i++) { // arr.length : 행 길이
			for(int j =0; j < arr[i].length; j++) { // arr[i]length : 열 길이
				System.out.print(arr[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println("\n행 길이 : "+arr.length); // 행 길이
		System.out.println("열 길이 : "+arr[0].length); // 열길이
	}
}
