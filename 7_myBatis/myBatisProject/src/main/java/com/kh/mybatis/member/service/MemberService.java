package com.kh.mybatis.member.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {
	// interface: 추상메서드
	public abstract int insertMember(Member m);
	
	public abstract Member loginMember(Member m); //로그인 할수있냐없냐 메소드
}
