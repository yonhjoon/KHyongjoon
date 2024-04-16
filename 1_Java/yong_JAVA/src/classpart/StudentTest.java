package classpart;

public class StudentTest {

	public static void main(String[] args) { // main() 함수 시작
		Student studentAhn = new Student(); // Student 클래스 생성
		studentAhn.studentName = "안승연";
		
		System.out.println(studentAhn.studentName);
		System.out.println(studentAhn.getStudentName());

	} // main() 함수 끝

}
