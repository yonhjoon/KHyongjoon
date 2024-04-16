package Test상소속;

public class Circle {

	private int radius;

	public Circle() {
		super();
	}

	public Circle(int x, int y,int radius) { // 매게변수 생성자
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
	public String toString() { // 필드에 담긴 데이터를 반환하는 메소드
		return "Circle [radius=" + radius + "]";
	}
	
	
}
