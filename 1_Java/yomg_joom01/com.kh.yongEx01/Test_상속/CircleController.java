package Test_상속;

public class CircleController {

	Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) { // 면적 : PI * 반지름 * 반지름
		return "면적 : " + x + ", " + y + ", " +  radius + " / " + (Math.PI * radius * radius);
	}
	
	public String calcCircum (int x, int y, int radius) { // 둘레 : PI * 반지름 * 2
		return "둘레 : " + x + ", " + y + ", " +  radius + " / "+(Math.PI * radius * 2);
	}
	
	
}
