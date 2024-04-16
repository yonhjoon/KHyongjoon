package com.kh.stydy2400225;

import java.util.Scanner;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() {
		super();
	}
	
	public void mainMenu() { //메인 메뉴 출력 메소드
		
				System.out.println("최대 등록 가능한 회원 수는 10명입니다.");
				System.out.println("현재 등록된 회원 수는 "+ mc.existMemberNum()  + "명입니다.");
				
				System.out.println("1. 새 회원 등록");
				System.out.println("2. 회원 검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				int number = sc.nextInt();
				
				switch(number) {
				case 1:
					this.insertMember();
					break;
				case 2:
					this.searchMember();
					break;
				case 3:
					this.updateMemner();
					break;
				case 4:
					this.deleteMember();
					break;
				case 5:
					this.printAll();
					break;
				case 9:
					
					break;
				default :
					System.out.println("잘못입력하셨습니다");
					return;
				}
			
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다.");
				
				System.out.println("2. 회원 검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				int sumber = sc.nextInt();
				
				switch(sumber) {
				case 2:
					this.searchMember();
					break;
				case 3:
					this.updateMemner();
					break;
				case 4:
					this.deleteMember();
					break;
				case 5:
					this.printAll();
					break;
				case 9:
					
					break;
				}
			}		
		
	
	public void insertMember() { //회원등록하기 위한 데이터를 사용자에게 입력 받는 메소드
		System.out.println("---새로운 회원등록 페이지---");
		
			System.out.print("아이디 : ");
			String id = sc.next();
			sc.nextLine();
			//String id,String name, String pwd, String email, char ch, int age
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("비밀번호 : ");
			String pwd = sc.next();
			
			System.out.print("이메일 : ");
			String email = sc.next();
			
			System.out.print("성별(M/F) : ");
			char ch = sc.next().charAt(0);
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			
			mc.insertMember(id, name, pwd, email, ch, age);
			
			this.mainMenu();
		}
	public void searchMember() { //검색 메뉴 출력 메소드
		
		System.out.println("1. 아이디로 검색하기 : ");
		System.out.println("2. 이름로 검색하기 : ");
		System.out.println("3. 이메일로 검색하기 : ");
		System.out.println("9. 메인으로 돌아가기");
		System.out.println("메뉴번호 : ");
		int number = sc.nextInt();
		
		switch(number) {
		case 1:
			this.searchId();
			break;
		case 2:
			this.searchName();
			break;
		case 3:
			this.searchEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			this.mainMenu();
			break;
		default :
			System.out.println("잘못입력하셨습니다 다시 입력해주세요.");
			this.mainMenu();
			break;
		}
		
	}
	public void searchId() { //아이디 검색을 위한 데이터를 사용자에게 입력 받는 메소드
		
		System.out.println("검색하실 아이디 : ");
		int id = sc.nextInt();
	}
	public void searchName() { //이름 검색을 위한 데이터를 사용자에게 입력 받는 메소드
		System.out.println("검색하실 이름 : ");
		int name = sc.nextInt();
	}
	public void searchEmail() { //이메일 검색을 위한 데이터를 사용자에게 입력 받는 메소드
		System.out.println("검색하실 이메일 : ");
		int email = sc.nextInt();
	}
	public void updateMemner() { //수정 메뉴 출력 메소드
		
	}
	public void updatePassword() { //비밀번호 수정을 위한 데이터를 사용자에게 입력 받는 메소드
		
	}
	public void updateName() { //이름 수정을 위한 데이터를 사용자에게 입력 받는 메소드
		
	}
	public void updateEmail() { //이메일 수정을 위한 데이터를 사용자에게 입력 받는 메소드
		
	}
	public void deleteMember() { //삭제 메뉴 출력 메소드
		
	}
	public void deleteOne() { //하나의 회원 삭제 결과를 출력하는 메소드
		
	}
	public void deleteAll() { //전체 회원 삭제 결과를 출력하는 메소드
			
	}
	public void printAll() { //전체 회원을 출력하는 메소드
		
	}

	
	
	
}
