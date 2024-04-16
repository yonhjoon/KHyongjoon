package Test_원둘래;

public class Rectangle {

	private int width;
	private int height;
	
	public Rectangle() {
		super();
	}
	public Rectangle(int x, int y, int width, int height) { //매게변수 생성자
		super();
		this.width = width;
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
	
	
}
