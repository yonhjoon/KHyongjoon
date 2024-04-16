package Array;

public class Arryay_짝수출력 {

	public static void main(String[] args) {
		
		int[] num = new int[5]; // 길이가 5인 int[] num 배열 초기화
		
		int sum = 0; // 합계를 위한 int 형 sum을 0 으로 초기화
		
		for(int i = 1; i < 11; i++) {
			if(i % 2 ==0) {
				sum += i;
			}
			System.out.print(i + " ");
		}
		
		System.out.println("\n1부터 10까지의 짝수 합 : "+ sum);

	}

}
