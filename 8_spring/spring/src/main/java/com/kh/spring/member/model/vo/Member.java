package com.kh.spring.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*
 * Lombok
 * - 자동 코드 생성 라이브러리
 * - 반복되는 getter, setter, toString등의 메소드를 자동으로 생성해줄 수 있는 라이브러리
 * 
 * lombok설치방법
 * 1. 라이브러리 다운로드 후 적용(pom.xml)
 * 2. 다운로드된 jar파일을 찾아서 설치(사용하는 ide에 설치)
 * 3. ide재실행
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
	private String userId; //회원아이디
	private String userPwd; //회원비밀번호
	private String userName; //회원명
	private String email; //회원이메일 
	private String gender; //회원성별
	private String age; //회원나이
	private String phone; //회원전화번호
	private String address; //회원주소
	private Date enrollDate; //회원가입일
	private Date modifyDate; //정보수정일
	private String status; //상태값(Y/N)
	
	
}
