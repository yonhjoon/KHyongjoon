package staticex1;

public class Cafe {

	String cafeName; // 카페 이름
	String cafeMenu; // 카페 메뉴
	int price; // 메뉴 가격
	int momry; // 메뉴판매 수
	
	public Cafe(String cafeName) { // 카페이름을 매게변수로 받은 생성사
		this.cafeName = cafeName;
	}
	
	public void takeMenu(String CafeMenu) { // 카페메뉴 생성자
		this.cafeMenu = CafeMenu;
	}
	
	public void take(int price) { // 메뉴를 구매한 경우를 구현한 메소드
		this.price = price;
		momry++;
		
	}
	
	public void showInfo() {
		System.out.println(cafeName + "의 메뉴 " + cafeMenu + " 나왔습니다! 가격은 :" + price + "입니다 "+cafeMenu +" 판매 수는 :" +  momry + "입니다!");
	}
	
}