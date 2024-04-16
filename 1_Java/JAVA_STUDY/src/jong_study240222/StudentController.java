package jong_study240222;

import com.kh.study240222.Student;

public class StudentController {

	private Student[] sArr = new Student[5];
	public static final int CUT_LINE  = 60;
	
	public StudentController() {
		sArr[0] = new Student("김길동","자바",100);
		sArr[1] = new Student("박길동","디비",50);
		sArr[2] = new Student("이길동","화면",85);
		sArr[3] = new Student("정길동","서버",60);
		sArr[4] = new Student("홍길동","자바",20);
	}
	
	public Student[] printStudent() {
		return this.sArr;
	}
	
	public int sumScore() {
		int num = sArr[0].getScore()+
				sArr[1].getScore()+
				sArr[2].getScore()+
				sArr[3].getScore()+
				sArr[4].getScore();
		return num;
	}
	
	public double[] avgScore() {
		double[] doubleArr = new double[2];
		doubleArr[0] = this.sumScore();
		doubleArr[1] = this.sumScore() / sArr.length;
		
		return doubleArr;
	}
}
