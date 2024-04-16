package Jang_240227;

import java.util.Scanner;

public class SnackMenu {

	Scanner sc = new Scanner(System.in);
	
	SnackController src = new SnackController();
	
	public void menu() {//사용자가 Snack 객체에 데이터를 저장할 수 있도록 값을 받고 저장한값을 출력하는 메소드
		
		System.out.print("종류 : ");
		String kind = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("맛 : ");
		String flavor = sc.next();
		System.out.print("개수 : ");
		int numOf = sc.nextInt();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print(src.confirmData());
		//저장
		//저장 완료되었습니다.
		
		
		//저장한 정보 확인
		System.out.print("\n저장한 정보를 확인하시겠습니까?(y/n) : ");
		char word =sc.next().charAt(0);
		
		if(word == 'y') {
			//Y
			System.out.println(src.saveData(kind, name, flavor, numOf, price));
		}else {
			//N
			System.out.println("");
		}
		
		
		
	}
	
	
	
}
