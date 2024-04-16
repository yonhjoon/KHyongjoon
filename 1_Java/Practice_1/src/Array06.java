import java.util.Scanner;
public class Array06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 3 이상인 홀수 자연수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
		 * 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
		 * 단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 "다시 입력하세요"를 출력하고
		 * 다시 정수를 받도록 하세요.
		 * 
		 * 
		 * 3 이상인 홀수 자연수 입력받기
		 * 해당키기의 배열을 성생
		 * 배열 중간까지는 1부터 1씩 증가하여 값을 넣고
		 * 중간부터 1씩 감소하면서 값을 넣어하
		 * 
		 * ex.
		 * 정수 : 4
		 * 다시입력하세요
		 * 정수 : -6
		 * 다시 입력하세요.
		 * 정수 : 5
		 * 1, 2, 3, 2, 1
		 */
		
		System.out.print("정수 : ");
		int num = sc.nextInt(); // 3
		
		while(num % 2 !=1) {
			System.out.print("다시 입력하세요.");
			num = sc.nextInt();
			System.out.print("정수 : ");
			num = sc.nextInt();
		}
		
		
		int[] arr = new int[num];
		int mid = num / 2;
		int count = 0;
		
		arr[0] = 1;
		for (int i = 1; i <= mid; i++){
			arr[i] = arr[i - 1] + 1;
		}
		
		for (int i = mid + 1; i < arr.length; i++) {
			arr[i] = arr[i -1] -1;
		}
		
		
		
		//2번째 방법
//		for(int i = 0; i < arr.length; i++) {
//			if (i <= mid ) {
//				arr[i] = ++count;
//			}else {
//				arr[i] = --count;
//			}
//		}
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
		
	}
}

