package com.kh.opendata.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Run {
	// 기본키
	public static final String SERVICE_KEY = "8h1yVur%2F0C1jzB%2BQnTVFLYlJk9Gfckktb8MFl25lzXaujB8wU9qgmg5abLreCLJnE2J%2FOK4DW5bqq0p4FPIEqw%3D%3D";

	public static void main(String[] args) throws IOException {
		//api문서보고 토대로 만든다
		
		//요청주소
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + SERVICE_KEY;
		url += "&returnType=json";
		url += "&sidoName=" + URLEncoder.encode("서울", "UTF-8"); //요청시 전달값에 한글이 있으면 인코딩 작업을 해줘야한다.
		
		
//		System.out.println(url);
//		http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKeyEu7NY%2Fn4d14%2FZA74L3unKaXVSmcTCCQezqyJuij7jo3sEWOd80JV6L3nWTKAFiV7CHHiNDGDD%2BFUs9uaSk%2BRGg%3D%3D&returnType=json&sidoName=%EC%84%9C%EC%9A%B8
	
		//자바코드로 서버에서 서버로 요청을 보내야함
		// ** HttpURLConnection 객체를 이용해서 요청을 보내자
		
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
		
		System.out.println("1 : "+responseText);
		
		//각각의 item정보 -> JSON형식으로 변환
		// JSONObject, JSONArray -> json라이브러리에서 제공하느 객체들
		// JsonObject, JsonArray -> Gson에서 제공
		
		// Json 버젼 2.10.1 로 바꾸니 된다
		JsonObject totalObj = JsonParser.parseString(responseText).getAsJsonObject();
		System.out.println("2 : "+totalObj);
		
		JsonObject responseObj = totalObj.getAsJsonObject("response");
		JsonObject bodyObj = responseObj.getAsJsonObject("body");
		System.out.println("3 : "+bodyObj);
		
		int totalCount = bodyObj.get("totalCount").getAsInt();
		JsonArray itemArr = bodyObj.getAsJsonArray("items");
		System.out.println("4 : "+itemArr);
		
		for(int i = 0; i < itemArr.size();  i++) {
			JsonObject item = itemArr.get(i).getAsJsonObject(); // i번째 구의 미세먼지정보를 가진 json객체 
			System.out.println("측정소명 : " + item.get("stationName").getAsString());
			System.out.println("측정일시 : " + item.get("dataTime").getAsString());
			System.out.println("미세먼지농도 : " + item.get("pm10Value").getAsString());
			
		}
	
	}
	
	
}
