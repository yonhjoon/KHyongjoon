package Test_상속;

public class RectangleController {

	Rectangle r = new Rectangle();
	
	public String calcArea (int x, int y, int height, int width) { // 면적 : 너비 * 높이
		return  "면적 : " + x + ", " + y + ", " +  height + ", "+ width +" / " + height * width;
	}
	
	public String calcPerimeter (int x, int y, int height, int width) { // 둘레 : 2 * (너비 + 높이)
		return "둘레 : " + x + ", " + y + ", " +  height + ", "+ width +" / " + 2 * (height + width);
	}
	
}
