package arraylist;

public class StudentTest {

	public static void main(String[] args) {
		Student Yong = new Student(1001,"장용준");
		Yong.addSubject("국어", 100);
		Yong.addSubject("수학", 50);
		
		Student SE = new Student(1002,"윤세련");
		SE.addSubject("국어", 70);
		SE.addSubject("수학", 85);
		SE.addSubject("영어", 100);
		
		Yong.showStudentInfo();
		System.out.println("=======================");
		SE.showStudentInfo();
		

	}

}
