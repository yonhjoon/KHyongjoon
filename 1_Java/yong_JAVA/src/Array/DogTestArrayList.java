package Array;

import java.util.ArrayList;

public class DogTestArrayList {
	
	public static void main(String[] args) {
		ArrayList<Dog> dog = new ArrayList<Dog>(); //ArrayList 선언
		
		dog.add(new Dog("뽀삐","말티즈"));
		dog.add(new Dog("a","s"));
		dog.add(new Dog("d","f"));
		dog.add(new Dog("뽀삐","말티즈"));
		dog.add(new Dog("뽀삐","말티즈"));
		
		for(Dog d : dog) {
			System.out.println(d.showDohInfo());
		}
	}
}
