import java.util.Scanner;
public class Attay05 {

	public static void main(String[] args) {
		/*
		 *  사용자가 배열의 길이를 직접입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
		 *  *
		 *  사용자가 배열의 길이를 직접 입력
		 *  입력한 값 만큼 정수형 배열 선언
		 *  *
		 *  
		 *  배열의 크기만큼 사용자가 직적 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
		 *  그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
		 *  (전체 나열, 전체합구하기
		 *  
		 *  ex.
		 *  정수 : 5
		 *  배열 0번째 인덱스에 넣을 값 : 4
		 *  배열 1번째 인덱스에 넣을 값 : -4
		 *  배열 2번째 인덱스에 넣을 값 : 3
		 *  배열 3번째 인덱스에 넣을 값 : -3
		 *  배열 4번째 인덱스에 넣을 값 : 2
		 *  4 -4 3 -3 2
		 *  총합 : 2
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int size = sc.nextInt(); // 3 임의의 값을 넣어라0
		int sum = 0;
		
		int[] arr = new int[size];  // 크기가 3인 정수형 배열 arr 생성
		for(int i = 0; i < arr.length; i++) { // ㅑ => 0,1,2    0~ 배열의 끝까지
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i < arr.length; i++) { //0 , 1 , 2
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		System.out.println("총 합 : " + sum);
	}

}
