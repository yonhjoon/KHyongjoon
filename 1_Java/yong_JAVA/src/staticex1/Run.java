package staticex1;

public class Run {
	public static void main(String[] args) {
		Human Jang = new Human("장용준",10000);
		Human SE = new Human("윤세련",20000);
		
		
		Cafe cfA = new Cafe("별다방");
		
		Jang.takeCafeAmericano(cfA);
		Jang.showInfo();
		cfA.showInfo();
		
		
		Cafe cfL = new Cafe("백다방");
		SE.takeCafeLatte(cfL);
		SE.showInfo();
		cfL.showInfo();
	}
}
