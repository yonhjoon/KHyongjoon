package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	public static final String SERVICE_KEY = "8h1yVur%2F0C1jzB%2BQnTVFLYlJk9Gfckktb8MFl25lzXaujB8wU9qgmg5abLreCLJnE2J%2FOK4DW5bqq0p4FPIEqw%3D%3D";
	
//	@PostMapping(value="air")//air 자원을 post할때 
//	public String getAirInfo() {
//		"나누는 연습을 좀 해봐라"
//	}
//	
//	@GetMapping(value="air") //air자원을 get할때
//	public String getAirInfo() {
//		
//	}
	
	@ResponseBody
	@RequestMapping(value="air", produces="application/json; charset=UTF-8") //띄어쓰기 함부러 하지말기...
	public String getAirInfo(String location) throws IOException {
		
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + SERVICE_KEY;
		url += "&returnType=json";
		url += "&sidoName=" + URLEncoder.encode(location, "UTF-8"); //요청시 전달값에 한글이 있으면 인코딩 작업을 해줘야한다.
		
		//url에 parameter 정보들을 추가하시오
//		- serviceKey : 공공데이터포털에서 훈련생 개인이 승인받은 OpenAPI 인증키

//		- returnType (json으로 출력결과 받음)
		
//		- sidoName : 서울, 부산, 대전
		
		// 1. 요청하고자하는 url을 전달하면서 java.net.URL 객체 생성
		URL reqeustURL = new URL(url);
				
		// 2. 만들어진 URL객체를 가지고 HttpURLConnection객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)reqeustURL.openConnection();
	
		// 3. 요청에 필요한 Header설정하기
		urlConnection.setRequestMethod("GET"); //포스트 설정 //안해줘도 기본값은 GET
				
		// 4. 해당 api서버로 요청 보낸후 입력데이터 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String responseText = "";
		String line;
		while((line = br.readLine()) != null ) { //읽을게 더 이상없을때는 null반환
			responseText += line;
		}
		br.close();
		urlConnection.disconnect();
		
		return responseText;
		
		
	}
	
}
