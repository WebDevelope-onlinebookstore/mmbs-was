package com.mong.mmbs.dto;

public class MemberDAOImpl {

	//비밀번호변경
	@Override
	public int updatePw(MemberVO vo) throws Exception {
		return sqlSession.update(namespace+".updatePw", vo);
	}
}
