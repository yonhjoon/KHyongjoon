package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RunTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
//		prop.setProperty("C", "INSERT"); // 데이터 저장
//		prop.setProperty("R", "SELECT"); // 데이터 읽기
//		prop.setProperty("U", "UPDATE"); // 데이터 수정
//		prop.setProperty("D", "DELETE"); // 데이터 삭제
//
//		try {
//			//prop.store(new FileOutputStream("resources/driver.properties"), "properties test");
//			prop.storeToXML(new FileOutputStream("resources/query.xml"), "properties test");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("driver"));
		System.out.println(prop.getProperty("url"));
		
	}

}
