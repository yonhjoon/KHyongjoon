package com.kh.spring.board.model.vo;

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
public class Board {
	private int boardNo ;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String originName;
	private String changeName;
	private int count;
	private String createDate;
	private String status;
}
