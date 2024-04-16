package Test_상속;

import java.util.Scanner;

public class PointMenu {

	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() { //메인메뉴 출력, 잘못 입력했을 시 다시 받도록 반복
		
		
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 원");
		System.out.println("2. 사각형");
		System.out.println("9. 끝내기");
		System.out.print("메뉴번호 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			 this.circleMenu();
			break;
		case 2:
			this.rectangleMenu();
			break;
		case 9:
			System.out.println("종료합니다.");
			return;
		}
	}
	
	public void circleMenu() { //원 메뉴 출력, 잘못 입력했을 시 메인메뉴로 돌아감
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴번호 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			 this.calcCircum();
			break;
		case 2:
			this.calcCircleArea();
			break;
		case 9:
			this.mainMenu();
		}
	}
	
	public void rectangleMenu() { //사각형 메뉴 출력, 잘못 입력했을 시 메인메뉴로 돌아감
		System.out.println("===== 사각형 메뉴 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴번호 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			 this.calcPerimeter();
			break;
		case 2:
			this.calcRectArea();
			break;
		case 9:
			System.out.println("종료합니다.");
		}
	}
	
	public void calcCircum() { //X, y 좌표와 반지름을 받아 원의 정보와 원 둘레 출력
		
		System.out.print("x좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("돌래 : ");
		int radius = sc.nextInt();
		sc.nextLine();
		
		System.out.println(cc.calcCircum(x,y,radius)); 
		
		this.mainMenu();
	}
	
	public void calcCircleArea() { // X, y 좌표와 반지름을 받아 원의 정보와 원 넓이 출력
		System.out.print("x좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		sc.nextLine();
		
		System.out.println(cc.calcArea(x, y, radius));
		
		this.mainMenu();
	}
	
	public void calcPerimeter() { //X, y 좌표와 높이, 너비를 받아 사각형의 정보와 사각형 둘레 출력
		
		System.out.print("x좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("높이 : ");
		int height = sc.nextInt();
		sc.nextLine();
		
		System.out.print("너비 : ");
		int width = sc.nextInt();
		sc.nextLine();
		
		System.out.println(rc.calcPerimeter(x, y, height, width)); 
		
		this.mainMenu();
	}
	public void calcRectArea() { // X, y 좌표와 높이, 너비를 받아 사각형의 정보와 사각형 넓이 출력
		
		System.out.print("x좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("높이 : ");
		int height = sc.nextInt();
		sc.nextLine();
		
		System.out.print("너비 : ");
		int width = sc.nextInt();
		sc.nextLine();
		
		System.out.println(rc.calcArea(x, y, height, width)); 
		
		this.mainMenu();
	}
	
}
