package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	//원본파일을 전달 받아서 파일명 수정작업후 수정된 파일을 반환시켜주는 메소드
	@Override
	public File rename(File originFile) {
		
		//원본파일명("sampleImg.jpg")
		String originName = originFile.getName();
		
		//수정파일명("20240215213212345.jpg")
		//파일업로드시간으로 처음이름을 줄것이다(년월일시분초가 될것이고) + 랜덤 5자리 + .jpg(원본 확장자)
		
		//1. 파일업로드 시간
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		//2. 5자리 랜덤값
		int ranNum = (int)(Math.random()*90000 + 10000);
		                              //10000부터 90000개까지
					//실수형을 나와서 int로 형변환한것
		
		//3. 원본파일확장자(.jpg)- . 부터가 확장자이다.
		String ext = originName.substring(originName.lastIndexOf("."));
		// 뒤에서부터 index값을 찾아온다 .으로부터 모르겠으면 lastIndexOf검색
		
		// 모두 하나로 만들어보자
		String changeName = currentTime + ranNum + ext;
		
		//파일 객체를 만들어보자
		File changeFile = new File(originFile.getParent(), changeName);
		// 이렇게하면 originFile의 경로로 찾아가서 changeName으로 파일명으로 바꾼다
		
		return changeFile;
		
		
		
		
	}
	
}
