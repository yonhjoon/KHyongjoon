package staticex1;

public class student { // 사람 객체 생성

	private String name; //이름
	public static int ID = (2345); 
	private int cardNumber; // 고유카드번호
	
	public student() {
		ID += 1;
		cardNumber = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\n카드번호 : " + cardNumber + "입니다.";
	}
	
	
	
}
