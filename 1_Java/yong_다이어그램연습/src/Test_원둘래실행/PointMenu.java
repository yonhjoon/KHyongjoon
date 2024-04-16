package Test_원둘래실행;

import java.util.Scanner;

public class PointMenu {

	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() { //메인메뉴 출력, 잘못 입력했을 시 다시 받도록 반복
	
		System.out.println("========메뉴========");
		
		System.out.println("1. 원");
		System.out.println("2. 사각형");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		int number = sc.nextInt();
		
		switch(number) {
			case 1:
				this.circleMenu();
				break;
			case 2:
				this.rectangleMenu();
				break;
			case 9:
				
				break;
			default :
		}
		
		
	} 
	public void circleMenu() { //원 메뉴 출력, 잘못 입력했을 시 메인메뉴로 돌아감
		System.out.println("========원 메뉴========");
		
		System.out.println("1. 원 둘래");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int number = sc.nextInt();
		
			switch(number) {
				case 1:
					this.calcCircum();
					break;
				case 2:
					this.calcCircleArea();
					break;
				case 9:
					this.mainMenu();
					break;
				default :
			}
	}
	
	public void rectangleMenu() { //사각형 메뉴 출력, 잘못 입력했을 시 메인메뉴로 돌아감
		System.out.println("========사각형 메뉴========");
		
		System.out.println("1. 사각형 둘래");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int number = sc.nextInt();
		
			switch(number) {
				case 1:
					this.calcPerimeter();
					break;
				case 2:
					this.calcRectArea();
					break;
				case 9:
					this.mainMenu();
					break;
				default :
			}
	}
	
	public void calcCircum() { // X, y 좌표와 반지름을 받아 원의 정보와 원 둘레 출력
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int xy = sc.nextInt();
		
		cc.calcArea(x, y, xy);
	}
	
	public void calcCircleArea() { // X, y 좌표와 반지름을 받아 원의 정보와 원 넓이 출력
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int xy = sc.nextInt();
		
		cc.calcArea(x, y, xy);
	}
	
	public void calcPerimeter() { //X, y 좌표와 높이, 너비를 받아 사각형의 정보와 사각형 둘레 출력
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int w = sc.nextInt();
		System.out.print("넓이 : ");
		int h = sc.nextInt();
		
		rc.calcPerimeter(x, y, w, h);
	}
	
	public void calcRectArea() { //X, y 좌표와 높이, 너비를 받아 사각형의 정보와 사각형 넓이 출력
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int w = sc.nextInt();
		System.out.print("넓이 : ");
		int h = sc.nextInt();
		
		rc.calcArea(x, y, w, h);
	}
}
