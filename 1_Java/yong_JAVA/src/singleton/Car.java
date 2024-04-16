package singleton;

public class Car {

	private String mySonata;
	private String yourSonata;
	public static  int serialNum = 10000;
	private int CarCount;
	
	public Car() {
		serialNum += 1;
		CarCount += serialNum;
	}

	public String getMySonata() {
		return mySonata;
	}

	public void setMySonata(String mySonata) {
		this.mySonata = mySonata;
		CarCount = serialNum;
	}

	public String getYourSonata() {
		return yourSonata;
	}

	public void setYourSonata(String yourSonata) {
		this.yourSonata = yourSonata;
		CarCount += CarCount ;
	}

	@Override
	public String toString() {
		return "Car [mySonata=" + mySonata + ", yourSonata=" + yourSonata + "]";
	}
	
	
	
	
}
