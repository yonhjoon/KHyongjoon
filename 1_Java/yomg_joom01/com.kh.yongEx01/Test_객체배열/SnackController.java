package Test_객체배열;

public class SnackController {

	Snack s = new Snack();

	public SnackController() {
		super();
	}

	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		return kind + "(" + name + " - " + flavor + ")" + numOf + "개 " + price + "원";
		
	}
	
	public String confirmData() {
		return "저장완료 되었습니다.";
		
	}
	
	
	
	
}
