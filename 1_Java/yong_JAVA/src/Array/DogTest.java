package Array;

public class DogTest {

	public static void main(String[] args) {
		Dog[] d = new Dog[5];
		
		d[0] = new Dog("뽀삐","말티즈");
		d[1] = new Dog("삐삐","푸들");
		d[2] = new Dog("탄이","프랜치불독");
		d[3] = new Dog("썰매","허스키");
		d[4] = new Dog("진돗","진돗개");

		for (int i = 0; i < d.length; i ++){
			System.out.println(d[i].showDohInfo());
		}
		
		System.out.println("=========");
		
		for (Dog dog : d) {
			System.out.println(dog.showDohInfo());
		}
		
	}
	
}
