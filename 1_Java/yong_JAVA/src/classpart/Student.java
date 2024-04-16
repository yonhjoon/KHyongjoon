package classpart;

public class Student { // class : 클래스를 만드는 예약어  // Student : 클래스이름
	int studentId; //학번
	String studentName; //학생이름
	int geade; // 학년
	String address; // 사는 곳
	
	// 학번 , 학생이름 , 학년 , 사는 곳 다 합친것이 "멤버변수" 이다. 
	// 멤버변수 : 클래스 내부에 선언하여 객체속성을 나타내는 변수
	
	public void showStudentInfo() {
		System.out.println(studentName + "," + address); // 메소드 추가 // 이름 , 주소 출력
	}

	public String getStudentName() { // 학생이름을 반환하는 메서드
		return studentName;
	}
	
	public void setStudentName(String name) { // 학생이름을 매게변수로 전달하는 메서드
		studentName = name;
	}
	
	
	public static void main(String[] args) {
		Student studenAhn = new Student(); // Student 클래스 생성
		studenAhn.studentName = "안연수";
		
		System.out.println(studenAhn.studentName);
		System.out.println(studenAhn.getStudentName());
	}
	
	
	
	
	
}
