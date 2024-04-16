package classpart;

public class StudentTest1 {
	public static void main(String[] args) {
		Student student1 = new Student(); // 첫 번째 학생 호출
		student1.studentName = "안연수";   // studentName : 멤버변수 사용
		System.out.println(student1.getStudentName()); // getStudentName() :  메서드 사용
		
		Student student2 = new Student(); // 두 번쨰 학생 호출
		student2.studentName = "안승연";  // studentName : 멤버변수 사용
		System.out.println(student2.getStudentName()); // getStudentName() :  메서드 사용
		
	}
}
