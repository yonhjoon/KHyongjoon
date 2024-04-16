package com.kh.study240222;

public class StudentMenu {
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		System.out.println("========== 학생 정보 출력 ==========");
		
		Student[] stuArr = ssm.printStudent();
		
		for(int i = 0; i < stuArr.length; i++) {
			stuArr[i].inform();
		}
		
		System.out.println("========== 학생 성적 출력 ==========");
		
		double[] scoreArr = ssm.avgScore();
		System.out.println("학생 점수 합계 : " + scoreArr[0]);
		System.out.println("학생 점수 평균 : " + scoreArr[1]);
		
		System.out.println("========== 성적 결과 출력 ==========");
		
		for(int i = 0; i < stuArr.length; i++) {
			if(ssm.CUT_LINE > stuArr[i].getScore()) { // 점수미달 -> 탈락
				System.out.println(stuArr[i].getName() + "학생은 재시험대상입니다.");
			}else { // 통과
				System.out.println(stuArr[i].getName() + "학생은 통과입니다.");
			}
		}
		
	}
}
