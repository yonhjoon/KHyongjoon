package staticex;

public class StudentTest1 { //static 변수 테스트하기
	public static void main(String[] args) {
		Student studentLee = new Student();
		studentLee.setStudentName("이지원");
		System.out.println(Student.serialNum); //serialNum 변수의 초깃값 출력
		studentLee.serialNum++; // static 변수값 증가
		
		
		Student Son = new Student();
		Son.setStudentName("손수경");
		
		// 증감된 값 출력
		System.out.println(Son.serialNum);         
		System.out.println(studentLee.serialNum);
	}
}
