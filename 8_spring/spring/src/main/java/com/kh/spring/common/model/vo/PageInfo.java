package com.kh.spring.common.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Lombok
 * - 자동 코드 생성라이브러리
 * - 반복되는 getter, setter, toString등의 메소드를 자동으로 생성해줄 수 있는 라이브러리
 * 
 * lombok설치방법
 * 1. 라이브러리 다운로드 후 적용(pom.xml)
 * 2. 다운로드된 jar파일을 찾아서 설치(사용하는 ide에 설치)
 * 3. ide재실행
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PageInfo {
	//총 게시글 수(전체게시글 수) 알아야 페이징처리를 할 수 있다.
	private int listCount; //현재 총 게시글 수
	private	int currentPage; // 현재 페이지를 알수있는 방법(사용자가 요청한 페이지 1페이지면 1페이지 2페이지면 2페이지)
	private int pageLimit; // 페이지 하단에 보여질 페이징바의 갯수
	private	int boardLimit; // 한 페이지내에 보여질 게시글 최대갯수
	//위 4개의 값을 기준으로 아래 3개의 값을 구해야함
		
	private int maxPage; // 가장 마지막 페이지 (총 페이지의 수 랑 같다 (listCount % boardLimit))
	private int startPage; // 페이징바의 시작수
	private int endPage; // 페이징바의 마지막 끝수
}
