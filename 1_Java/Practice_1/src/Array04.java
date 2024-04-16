import java.util.Arrays;
import java.util.Scanner;
public class Array04 {

	public static void main(String[] args) {
		/*
		 * "일"요일부터 "월"요일까지 요일에 대한 정보를 가지고 있는 배열을 하나 만들어줍니다.
		 * 0~6까지의 숫자를 입력받아 해당 인덱스에 있는 요일을 출력하고 범위에 없는 숫자를 입력시 '월','화','수','목','금','토','일'
		 * 0~6사이의 숫자를 입력하세요를 출력하고 다시 입력을 받습니다
		 */
		Scanner sc = new Scanner(System.in);
		String[] week = {"일","월","화","수","목","금","토"}; //일요일 부터 월요일까지 문자열을 저장한 배열 ㅈㄷ다생성
		int num;
		do {	
			System.out.print("0~6 사이 숫자 입력 : ");
			num = sc.nextInt();
		}while(!(num >= 0 && num <= 6 )); // (num < 0 || num > 6);
		
		System.out.println(week[num] + "요일");
		
		
		
		
	}

}
