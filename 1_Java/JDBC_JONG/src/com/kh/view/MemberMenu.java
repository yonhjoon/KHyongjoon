package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

// View : 사용자가 보게될 시각적인 요소(화면) 출력및 입력
public class MemberMenu {
	
	//Scanner객체 생성(전역으로 다 입력받을 수 있도록)
	private Scanner sc = new Scanner(System.in);

	//MemberController 객체생성(전역에서 바로 요청할 수 있도록)
	private MemberController mc = new MemberController();
	
	/*
	 * 사용자가 보개될 첫 화면(메인화면)
	 */
	public void mainMenu() { // 메인화면
		
		while(true) {
			System.out.println("=========책관리 프로그램==================");
			System.out.println("1. 그림 추가");
			System.out.println("2. 그림 전체 조회");
			System.out.println("3. 그림 정보 변경");
			System.out.println("4. 그림 삭제");
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
				//userId
				//패스워드, 이메일, 전화번호, 주소
				this.updateMember();
				break;
			case 4:
//				System.out.print("아이디 : ");
//				String userId = sc.nextLine();
				
				//String userId = this.inputMemberId();
				
				mc.deleteMember(this.inputMemberId());
				break;
			case 0:
				System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void inputMember() { // 객체 추가 화면
		System.out.println("==============그림 추가===============");
		// id~취미까지 입력받기
		
		System.out.print("작품 이름 : ");
		String userId = sc.nextLine();
		
		System.out.print("작품 고유번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("화가 이름 : ");
		String userName = sc.nextLine();
		
		System.out.print("화가 이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("화가 전화번호(-빼고입력) : ");
		String phone = sc.nextLine();
		
		System.out.print("화가 주소 : ");
		String address = sc.nextLine();
		
		System.out.print("박물관 유/무 : ");
		String hobby = sc.nextLine();
		
		//회원추가 요청 == Controller메소드 요청
		mc.insertMember(userId, userPwd, userName, email, phone, address, hobby);
		
	}

	public void updateMember() { //정보 변경화면
		System.out.println("\n=========책 정보 변경==============");
		
		//(어떤회원인지 찾기위한)아이디, 비밀번호, 이메일, 전화번호, 주소
		
		String userId = this.inputMemberId();
		
		System.out.print("변경할 작품고유번호");
		String userPwd = sc.nextLine();
		
		System.out.print("변경할 화가 이메일");
		String email = sc.nextLine();
		
		System.out.print("변경할 화가 전화번호");
		String phone = sc.nextLine();
		
		System.out.print("변경할 화가 주소");
		String address = sc.nextLine();
		
		mc.updateMember(userId, userPwd, email, phone, address);
	}
	
	public String inputMemberId() {
		System.out.print("화가 이름 : ");
		String userId = sc.nextLine();
		return userId;
	}
	
	//-------------------------------- 응답화면------------------------------------
	/**
	 * 서비스요청 처리 후 성공했을 경우 사용자가 보게될 응답화면
	 * @param : 객체별 성공메세지
	 */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}
	
	/**
	 * 서비스요청 처리 후 실패했을 경우 사용자가 보게될 응답화면
	 * @param message: 객체별 실패메세지
	 */
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
	
	/**
	 * 조회서비스 요청시 조회결과가 없을 떄 사용자가 보게될 응답화면
	 * @param message: 조회결과에 대한 응답메세지
	 */
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}
	
	/**
	 * 조회서비스 요청시 결과가 여러행일 경우 보게될 응답화면
	 * @param list: 조회결과
	 */
	public void displayMemberList(ArrayList<Member> list) {
		//for loop
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		
		//for each
		for(Member m : list) {
			System.out.println(m);
		}
	}
	
	public void displayMember(Member m) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(m);
	}
	
	
	
	
	
	
	
	
	
}
