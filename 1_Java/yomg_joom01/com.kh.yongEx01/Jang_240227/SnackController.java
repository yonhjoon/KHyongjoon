package Jang_240227;

public class SnackController {

	private Snack s = new Snack();
	
	public SnackController() {
		super();
	}
	
	public String saveData(String kind, String name, String flavor, int numOf, int price){
		
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		return s.toString() ;
		//데이터를 setter 를 이용해 저장하고 저장완료되었다는 결과를 반환하는 메소드
	}
	
	public String confirmData() {
		return  s.information();
		// 저장된 데이터를 반환하는 메소드
	}
	
	
}
