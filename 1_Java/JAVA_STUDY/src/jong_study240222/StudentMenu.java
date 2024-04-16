package jong_study240222;

import com.kh.study240222.Student;

public class StudentMenu {

	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		System.out.println("========== 학생 정보 출력 ==========");
		
		Student[] sAru = ssm.printStudent();
		for (int i = 0; i < sAru.length; i++) {
			System.out.println(sAru[i].inform());
		}
		
		System.out.println("========== 학생 성적 출력 ==========");
		
		double[] dbArr = ssm.avgScore();
		System.out.println("학생 점수 합계 : " + (int)dbArr[0]);
		System.out.println("학생 점수 평균 : " + dbArr[1]);
		
		
		System.out.println("========== 성적 결과 출력 ==========");
		
		for (int i = 0 ; i <sAru.length;i++) {
			if (ssm.CUT_LINE > sAru[i].getScore()) {
				System.out.println(sAru[i].getName() + "학생은 재시험 대상입니다.");
			}else {
				System.out.println(sAru[i].getName() + "학생은 통과입니다");
			}
		}
		
		
		
	}
}
