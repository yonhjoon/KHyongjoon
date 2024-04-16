package com.kh.MemberService;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;


// Service를 사용하는 이유 
/*
 * 모듈화 : 어떤 컨트롤러가 여러개의 리포지터리(소프트웨어의 정보를 관리하는 데이터베이스)를 사용하여 데이터를 조회한 후 가공하여 리턴한다고 가정했을 때, 
 * 		  이러한 기능을 서비스로 만들어두면 컨트롤러에서는 해당 서비스를 호출하여 사용하면 된다. 
 * 		  하지만 서비스로 만들지 않고 컨트롤러에서 구현하려 하면 해당 기능을 필요로 하는 모든 컨트롤러가 
 * 		  동일한 기능을 중복으로 구현해야 하므로 서비스는 모듈화를 위해서 꼭 필요합니다.
 * 
 * 보안 : 컨트롤러는 리포지터리 없이 서비스를 통해서만 데이터베이스에 접근하도록 구현하는 것이 보안상 안전합니다. 
 * 		서비스를 따로 구축하면 해커가 만일 해킹을 통해 컨트롤러를 제어할 수 있게 되더라도 리포지터리에 직접 접근할 수는 없게 됩니다.
 * 
 * 엔티티 객체와 DTO 객체의 변환 : 엔티티 클래스는 데이터베이스와 직접 맞닿아 있는 클래스이기 때문에 컨트롤러나 타임리프와 같은 템플릿 엔진에 전달하여 사용하는 것은 좋지 않습니다. 
 * 							컨트롤러나 타임리프에서 사용하는 데이터 객체는 속성을 변경하여 비즈니스적인 요구를 처리해야 하는 경우가 많은데 
 * 							엔티티를 직접 사용하여 속성을 변경한다면 테이블 컬럼이 변경돼 엉망이 될 수도 있기 때문입니다.
 * 
 * 짧은요약 : 데이터 처리를 위해 작성하는 클래스
 */
public class MemberService {
		//1) JDBC driver등록
		//2) Connection 객체 생성
		//3) Connection 객체 처리

	public int insertMember(Member m) {
		
		//Connection : 네트워크 상의 연결 자체를 의미한다. 
		//			  -보통 Connection 하나당 트랜잭션 하나를 관리한다. 
		//			  -트랜잭션은 하나 이상의 쿼리에서 동일한 Connection 객체를 공유하는 것을 의미한다.
		Connection conn = JDBCTemplate.getConnerction();
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	
public 	ArrayList<Member> selectList(){
	Connection conn = JDBCTemplate.getConnerction();
	ArrayList<Member> result = new MemberDao().selectList(conn);
	JDBCTemplate.close(conn);
	return result;
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
