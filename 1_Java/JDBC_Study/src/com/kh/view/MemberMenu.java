package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.Controller.MemberController;
import com.kh.model.vo.Member;

public class MemberMenu {
	// View : 사용자가 보게될 시각적인 요소 즉 화면에 보이는 출력 및 입력 (회원가입 창 같은것)
	
	// 전역으로 다 입력받을수 있게 생성자로 만들어놓는다
	private Scanner sc = new Scanner(System.in);
	
	//전역에서 바로 요청할수있게 만들어 놓는다
	private MemberController mc = new MemberController();
	
	
	// 이제부터가 사용자에게 보이게 될 화면
	
	public void mainMenu() {
		while(true) {
			System.out.println("=========책관리 프로그램==================");
			System.out.println("1. 책 추가");
			System.out.println("2. 책 전체 조회");
			System.out.println("3. 책 정보 변경");
			System.out.println("4. 책 삭제");
			System.out.println("5. 책 아이디 검색");
			System.out.println("6. 책 이름으로 키워드 검색");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.inputMember();
				break;
			case 2:
				mc.selectList(); // 회원정보 내놔 -> controller에 요청
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 0:
				System.out.println("이용해주셔서 감사합니다 프로그램을 종료합니다");
				break;
			default :
				System.out.println("잘못입력하셨습니다 다시 입력해주세요.");
			}
		}
	}
	public void inputMember() {
		System.out.println("============책 추가 화면============");
		//이름~ 발행일
		//책이름, 저자, 출판사, 발행일
		
		System.out.println("책 이름");
		String name = sc.next();
		
		System.out.println("저자");
		String author = sc.next();
		
		System.out.println("출판사");
		String publisher = sc.next();
		
		System.out.println("발행일");
		String date = sc.next();
		
		// 회원 추가 요쳥 == Controller메소드 요청
		mc.insertMember(name, author, publisher, date);
	}
	
	public void updateMember() {
		
	}
	
	public void inputMemberId() {
	
	}
	
	public void displaySuccess(String message) {
		
	}
	
	public void displayFail(String message) {
		
	}
	
	public void displayNoData(String message) {
		
	}
	
	/**
	 * 조회서비스 요청시 결과가 여러행일 경우 보게될 응답화면
	 * @param list: 조회결과
	 */
	public void displayMemberList(ArrayList<Member> list) {
		for(Member m : list) {
			System.out.println(m);
		}
	}
	
	public void displayMember(Member m) {
		
	}
	
	
	
	
	
}
