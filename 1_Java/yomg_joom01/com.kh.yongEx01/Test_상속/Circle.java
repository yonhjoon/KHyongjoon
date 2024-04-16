package Test_상속;

public class Circle {

	private int radius;

	public Circle() {
		super();
	}
	

	public Circle(int x, int y, int radius) {
		super();
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
	
}
