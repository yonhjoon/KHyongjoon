package com.kh.study240222;

public class StudentController {

	private Student[] sArr = new Student[5];
	public static final int CUT_LINE = 60;
	
	// 5개의 객체배열을 위의 샘플 데이터의 값으로 초기화 해주는 기본 생성자
	// 5개의 객체배열에 샘플데이터값으로 모두 채워라
	public StudentController() {
		sArr[0] = new Student("김길동","자바",100);
		sArr[1] = new Student("박길동","디비",50);
		sArr[2] = new Student("이길동","화면",85);
		sArr[3] = new Student("정길동","서버",60);
		sArr[4] = new Student("홍길동","자바",20);
	}
	
	// 객체 배열에 있는 데이터를 반환 (return)
	public Student[] printStudent() {
		return this.sArr;
		
	}
	
	//객체 배열의점수를 합한 값 리턴
	public int sumScore() {
//		int sum = sArr[0].getScore()+
//		sArr[0].getScore()+
//		sArr[1].getScore()+
//		sArr[2].getScore()+
//		sArr[3].getScore()+
//		sArr[4].getScore();
		
		int sum = 0;
		for (int i = 0; i < sArr.length; i++) {
			sum += sArr[i].getScore();
		}
		
		return sum;
	}
	
	// double 배열을 만들어 sumScore의 리턴 값을0번째 인덱스에 저장하고 
	// 합의 평균을 1번째인덱스에 저장 후 배열리턴
	public double[] avgScore() {
		double[] doubleArr = new double[2];
		
		doubleArr[0] = this.sumScore();
		doubleArr[1] = doubleArr[0] / this.sArr.length;
		return doubleArr;
	}
	
}
