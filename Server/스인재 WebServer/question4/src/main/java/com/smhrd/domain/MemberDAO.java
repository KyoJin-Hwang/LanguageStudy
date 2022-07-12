package com.smhrd.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;
import com.smhrd.domain.Member;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	//회원가입
	public int insertMember(Member member) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("com.smhrd.domain.MemberDAO.insertMember",member);
			if(cnt>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	// 로그인 기능
	public Member selectMember(Member id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Member loginMember = null;
		try {

			loginMember = sqlSession.selectOne("com.smhrd.domain.MemberDAO.selectMember",id);
			if(loginMember != null) {
				sqlSession.commit();
				System.out.println("DAO1");
			}else {
				sqlSession.rollback();
				System.out.println("DAO2");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return loginMember;
	}
	
}
