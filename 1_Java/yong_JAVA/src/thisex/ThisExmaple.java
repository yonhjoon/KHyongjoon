package thisex;

   class BirthDay {

	int day;
	int month;
	int year;
	
	public void setYear(int year) { // 태어난 연도 정하는 메서드
		this.year = year; // bDay.year = tear; 와 같음
	}
	
	public void printThis() { // this 출력 메소드
		System.out.println(this); //System.out.println(bDay) 와 같음
	}
   }
	
	public class ThisExmaple{
		public static void main(String[] args) {
			BirthDay bDay = new BirthDay();
			bDay.setYear(2000);		// 태어난 연도를 2000으로 지정
			System.out.println(bDay); // 참조변수 출력
			bDay.printThis();  //this 출력 메소드 호출
			
		}
	}

