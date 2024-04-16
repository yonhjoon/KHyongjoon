package Test_객체배열;

import java.util.Scanner;

public class SnackMenu {

	Scanner sc = new Scanner(System.in);
	SnackController scr = new SnackController();
	
	
	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		
		System.out.print("종류 : ");
		String kind = sc.next();
		System.out.print("이름 : ");
		 String name= sc.next();
		System.out.print("맛 : ");
		 String flavor= sc.next();
		System.out.print("개수 : ");
		 int numOf = sc.nextInt();
		System.out.print("가격 : ");
		 int price = sc.nextInt();
		 
		 System.out.println("저장한 정보를 확인하시겠습니까? (y/n) : ");
		 char word = sc.next().charAt(0);
		 
		 if (word == 'y') {
			 System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		 } else if (word == 'Y') {
			 System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		 }else if(word == 'n'){
			 System.out.println(" ");
		 }else if (word == 'N') {
		 }else {
			 System.out.println("잘못입력하셨습니다 다시 입력해주세요");
			 this.menu();
		 }
	}
	
	
}
