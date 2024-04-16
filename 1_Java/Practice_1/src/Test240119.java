import java.util.Scanner;
public class Test240119 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 정수형 변수 age를 입력받아 7세 이하면 어린이, 19세 이하면 청소년 20새 이상이면 성인을 출력하세요.
		/*
		System.out.print("나이를 입력하세요 : ");
		int age  = sc.nextInt();
		
			if (age <= 7) {
				System.out.println("어린이 입니다");
				sc.nextInt();
			} else if(age <= 19) {
				System.out.println("청소년입니다.");
				sc.nextInt();
			}else {
				System.out.print("성인입니다");
			}
		*/
		
		
		
//		//정수 num1, num2두개를 입력받아 두 수 사이에 있는 3의 배수의 모든 합을 구하세요.
//		//( 트루 펄스 진실 거짓)
//		int num1,num2,min,max, sum = 0;
//		
//		System.out.print("정수 두개 입력 : ");
//		num1 = sc.nextInt(); //1
//		num2 = sc.nextInt(); //10
//		
//		min = num1 < num2 ? num1 : num2;
//		max = num1 > num2 ? num1 : num2;
//		// 1 2 3 4 5 6 7 8 9 10
//		for (int i = min; i <=max; i++) {
//			if (i % 3 ==0) {
//				sum =+ i; //3의 배수 누적
//			}
//		}
//		System.out.printf("%d의 %d 사이의 3의 배수의 총 합 : %d",min,max,sum);
		
		
		
			/*
			System.out.print("첫번째 정수 : ");
			int num1 = sc.nextInt();
			
			System.out.print("두번째 정수 : ");
			int num2 = sc.nextInt();
			
			 for (int i = 0; i < 1; i++) {
				 System.out.println((num1 + num2) / (num1 / num2));
			 }
			*/
			
	
		
		
		
//		//정수 num1과 num2를 입력받아 두 수 사이에 있는 모든 홀수의 합과 짝수의 합을 각각 구하세요.
//		int num1,num2, sum1 =0,sum2 = 0;
//		
//		System.out.print("정수 두개 입력 : ");
//		num1 = sc.nextInt();
//		num2 = sc.nextInt();
//		
//		// 이방법이 복잡하다면 위에 int로 정의해서 해도된다
//		for(int i = (num1 < num2 ? num1 : num2); i <= (num1 > num2 ? num1 : num2); i++) {
//			if (i % 2 ==1) { //홀수
//				sum1 +=i;
//			}else { //짝수
//				sum2 +=i;
//			}
//		}
//		
//		// 1 2 3 4 5 6 7 8 9 10
//		// 1 3 5 7 9
//		// 2 4 6 8 10
//		
//		System.out.println("홀수의 총합 : "+ sum1);
//		System.out.println("짝수의 총합 : "+ sum2);
		
		
		
		//첫째줄에 데이터의 개수 n개를 입력받고
		//사용자로부터 n개의 정수를 입력받앙 입력받은 반대로 출력하세요.
		//ex) 정수입력 : 5
		// 숫자 입력 : 1 7 5 9 4
		// 반대로 출력 : 4 9 5 7 1
		/*
		int size;
		System.out.print("개수 입력 : ");
		size = sc.nextInt();
		
		int[] arr = new int[size]; // n개의 정수를 입력받아야되니 저장하는 데이터가 필요함 고로 함수를 만들어 그 안에 데이터를 저장한다
		for (int i =0; i < arr.length; i++) {
			System.out.print(i + "번째 입력 : "); // 1번째부터 하고싶으면 (i+1) + "번째 입력" 하면된다
			arr[i] = sc.nextInt();
		} // 5 4 8
		// 8 4 5
		for(int i =(arr.length - 1); i <= 0 ; i--) { //length  즉 길이에서 한개를 빼는것이 i다
			System.out.print(arr[i] + " ");
			
		}
		*/
	
		//sc.claose(); 스케너를 대입한 클래스를 마무리할때 써야댐
			 
		 //사용자에게 행의 크기를 입력받고 그 수만큼의 반복을 통해 열의 크기도 받아
		 //문자형 가변 배열을 선언 및 할당하세요.
		 //그리고 각 인덱스에 'a'부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
		 int row, col;
		 System.out.print("행의 크기 : ");
		 row = sc.nextInt();
		 
		 char[][] arr = new char[row][];
		 for(int i = 0; i < arr.length; i++) {
			 System.out.print(i + "행의 열 크기 : ");
			 col = sc.nextInt();
			 
			 arr[i] = new char[col];
		 }
		 
		 char ch = 'a';
		 for (int i =0; i < arr.length; i ++) {
			 for (int j =0; j < arr[i].length; j++) {
				 arr[i][j] = ch++;
			 }
			
		 }
		 
		 for (int i =0; i < arr.length; i ++) {
			 for (int j =0; j < arr[i].length; j++) {
				 System.out.print(arr[i][j] + " ");
			 }
			 System.out.println();
		 }
		 
		 //ex.
		 //행의 크기 : 4
		 //0행의 크기 : 2
		 //1행의 크기 : 6
		 //2행의 크기 : 3
		 //3행의 크기 : 5
	 }
			 
			 

}
