package Test객체배열;

public class MemberController {

	private Test객체배열.Member[] m = new Member[SIZE];
	public static int SIZE = 10;
	
	public int existMemberNum() {//현재 존재하는 멤버 수 반환
		//우리는 정보를 가지고 멤버를 추가
		//멤버객체 1개 만들고 데이터는 넘겨받은 것들로 세팅
		// 그 다음 객체배열 m에 null인 공간을 찾아서 넣어주기

		
		int count =0;//3
		
		for(int i= 0; i < m.length; i++) {
			if(m[i] == null) {
				return count;
			} else {
				count++;
			}
		}
		return count;
	}
	
	public boolean checkId(String inputld) { // 아이디 중복확인 하는 메소드
		//이미가입한 아이디가 있는지 확인해라
		//배열 m에 있는 사람들 중에 inputId를가진사람이 있으면 return true
		//없으면 false
		//배열m을 전체적으로 반복하면서 => [m,m,m,m,null,null...]
		//배열m에 i번째가 null이 아닌지
		//안에있는 멤버객체에 id를 꺼내서 해당아이디가 inputId와 같은지?
		
		for(int i = 0; i < m.length; i++) {
			m[i] = new Member(); 
		}
		
		
		int result = new MemberService().insertMember(m);
		
		if (result > 0) { // insert가 성공적으로 완료되었다
			//성공화면
			new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
		} else { // insert가 실패했다.
			//실패화면
			new MemberMenu().displayFail("회원추가를 실패하였습니다.");
		}
		
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null && m[i].equals(inputld)) {
				return true;
			}else {
				return false;
			}
		}
		
		return true;
		
	}
	
	public void insertMember(String id, String name, String password, String email, 
							char gender, int age) { //Member객체를 객체배열에 저장하는 메소드
		
		for(int i =0; i < m.length; i++) { // 반복문을 돌며
			if(m[i] == null) {
				m[i] = new Member(id, name, password, email, gender, age);
				break;
			} 
				
			
		}
	}
	
	public String searchId(String id) { //id로 회원을 조회하는 메소드
		String act = this.searchId(id);
		if(act == id) {
			System.out.println("검색하이디");
		}else {
			System.out.println("검ㅅ개아이");
		}
		return id;
	}
	public Member[] searchName(String name) { //이름으로 회원을 조회하는 메소드
		
	}
	public Member[] searchEmail(String email) { //이메일로 회원을 조회하는 메소드

		
	}
	
	public boolean updatePassword(String id, String password) { //비밀번호 변경 메소드
		
	}
	
	public boolean updateName(String id, String name) { //이름 변경 메소드
		
	}
	public boolean updateEmail(String id, String email) { //이메일 변경 메소드
		
	}
	public boolean delete(String id) { //한 회원만 삭제하는 메소드
		
	}
	public void delete() { //전체 회원을 삭제하는 메소드
		
	}
	
	public Member[] printAll() { //Member객체 반환 메소드
		
	}
	
	
	
	
	
	
	
	
	
}
