import java.util.Arrays;
import java.util.Scanner;
public class Array01 {

	public static void main(String[] args) {
		//사용자에게 입력받은 양의 정수만큼 배열의 크기를 할당하고
		//1부터 입력받은 값까지 배열에 초기화한 후 출력하세요.
		Scanner sc = new Scanner(System.in);
//		
//		int[] num = {0};
//		
//		System.out.print("배열의 크기를 입력하세요 : ");
//		int sum = sc.nextInt();
		
		
		int size; //size변수 선언
		
		System.out.print("정수 입력 : ");
		size = sc.nextInt(); // size에 사용자로부터 받은 값 대입 (일단 5라고 생각해보자)
		
		int[] arr = new int[size]; // 사용자로부터 받은 값만큼의 크기의 배열을 생성 (크기가 5인 배열 생성)
		for (int i = 0; i < arr.length; i++) { // 배열전체 탐색 인대 (index 0~4)
			arr[i] = i + 1; // 0 -> arr[0] = 0 + 1; arr[1] = 1 + 1 ; arr[2] = 2 + 1; arr[3] = 3+1;
		}
		
		for(int i = 0; i < arr.length; i++) { // 배열 전체 탐색 index 0~4 반복하겠구나
			System.out.print(arr[i] + " ");
		}
		// 1 2 3 4 5
		

	}

}
