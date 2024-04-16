package classpart_연습;

public class ShopOrder {

	long number; // 주문번호
	String ID; // 주문자 아이디
	String date; // 주문 날짜
	String name; // 주문자 이름
	String ProductNumber; // 상품 번호
	String address; // 주소
	
	
	
	public ShopOrder() {
		super();
	}

	public ShopOrder(long number, String iD, String date, String name, String productNumber, String address) {
		super();
		this.number = number;
		ID = iD;
		this.date = date;
		this.name = name;
		ProductNumber = productNumber;
		this.address = address;
	}
	
}
