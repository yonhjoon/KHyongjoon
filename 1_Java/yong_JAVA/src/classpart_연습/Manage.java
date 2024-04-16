package classpart_연습;

public class Manage {

	public static void main(String[] args) {
		Man Mage = new Man();
		
		Mage.age = 40;
		
		Man Name = new Man();
		
		Name.Name = "James";
		
		Man iM = new Man();
		iM.isMarried = true;
		
		Man ch = new Man();
		ch.children = 3;
		
		System.out.println("나이 : " + Mage.age + "\n" + "이름 : " + Name.Name + "\n" +"결혼여부 : " 
						   + iM.isMarried + "\n" +"자녀수 : " + ch.children);
	}
		
	

}
