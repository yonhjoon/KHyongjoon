package staticex1;

public class Human {

	public String name; // 이름
	public int momry; // 보유 돈
	public String cafeMenu; // 카페 메뉴
	
	public Human(String name, int momry) {
		this.name = name; //이름
		this.momry = momry; // 보유 돈
	}
	
	public void takeCafeAmericano(Cafe americano) { // 아메리카노를 4000원 지불하는 기능을 구현한 메소드
		americano.take(4000);
		americano.takeMenu("아메리카노");
		this.momry -= 4000;
	}
	
	public void takeCafeLatte (Cafe latte) { // 라떄를 4500원 지불하는 기능을 구현한 메소드
		latte.take(4500);
		latte.takeMenu("카페라떼");
		this.momry -= 4500;
	}

	public void takecafeMenu(Cafe menu) {
		this.cafeMenu = cafeMenu;
	}
	public void showInfo() {
		System.out.println(name + " 님의 보유금액은 :" + momry +"입니다.");
	}
	
	
}