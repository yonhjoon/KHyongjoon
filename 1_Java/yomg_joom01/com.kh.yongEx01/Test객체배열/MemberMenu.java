package Test객체배열;

import java.util.Scanner;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	
	MemberController mc = new MemberController();
	
	
	public MemberMenu() { //기본생성자
		
	}
	
	public void mainMenu() { //메인 메뉴 출력 메소드
	
		while(mc.existMemberNum() != 11) {
			
			System.out.println("\n==================메인메뉴====================");
			System.out.println("최대 등록 가능한 회원수는 "+mc.SIZE+"명입니다.");
			System.out.println("현재등록된 회원수는 "+mc.existMemberNum() +"명입니다.");
			
			System.out.println("1. 새 회원등록");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 입력 : ");
			int number = sc.nextInt();
			sc.nextLine();
			
			switch(number) {
			case 1:
				this.insertMember();
				break;
			case 2:
				this.searchMember();
				break;
			case 3:
				this.updateMember();
				break;
			case 4:
				this.deleteMember();
				break;
			case 5:
				this.printAll();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default :	
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}if (mc.existMemberNum() == 11) {
			System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 입력 : ");
			int number = sc.nextInt();
			sc.nextLine();
			
			switch(number) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 9:
				
				break;
			default :
			}
		}
	}
		
	
	public void insertMember() { //회원등록하기 위한 데이터를 사용자에게 입력 받는 메소드
		MemberMenu mm = new MemberMenu();
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			mc.checkId(id);
			System.out.print("이름 입력 : ");
			String name = sc.next();
			System.out.print("비밀번호 입력 : ");
			String pwd = sc.next();
			System.out.print("이메일 입력 : ");
			String email = sc.next();
			System.out.print("성별 입력(M/F) : ");
			char gender = sc.next().charAt(0);
			if(gender == 'f' || gender == 'F') {
				
			}else if(gender == 'm' || gender == 'M'){
				
			}else {
				System.out.println("잘못 입력하셨습니다 다시 입력해주세요.");
				mm.insertMember();
			}
			
			System.out.print("나이 입력 : ");
			int age = sc.nextInt();
			
			mc.insertMember(id, name, pwd, email, gender, age);
			System.out.println("저장이 완료되었습니다.");
		
	}
	public void searchMember() { //검색 메뉴 출력 메소드
		System.out.println("\n===============회원검색창==============");
		while(true) {
			System.out.println("1.아이디로 검색");
			System.out.println("2.이름으로 검색");
			System.out.println("3.이메일로 검색");
			System.out.println("9.메인으로 돌아가기");
			System.out.print("메뉴 번호 : ");
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
				break;
			default :
					System.out.println("잘못 입력하셨습니다.");
			}
			return;
		}
	}
	
	public void searchId() { //아이디 검색을 위한 데이터를 사용자에게 입력 받는 메소드
		System.out.print("검색할 아이디 : ");
		String id = sc.next();
		
		String act = mc.searchId(id);
		if(act == id) {
			System.out.println("검색하이디");
		}else {
			System.out.println("검ㅅ개아이");
		}
		
	}
	public void searchName() { //이름 검색을 위한 데이터를 사용자에게 입력 받는 메소드
		
	}
	public void searchEmail() { //이메일 검색을 위한 데이터를 사용자에게 입력 받는 메소드
		
	}
	public void updateMember() { //수정 메뉴 출력 메소드
		
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
