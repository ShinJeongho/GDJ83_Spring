package com.win.app.members;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.win.app.members.MemberDAO.";

	public void join(MemberDTO memberDTO) throws Exception {
		sqlSession.insert(NAMESPACE + "join", memberDTO);
	}

	public boolean isDuplicate(MemberDTO memberDTO) throws Exception {
		int count = sqlSession.selectOne(NAMESPACE + "isDuplicate", memberDTO);
		return count > 0;
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "login", memberDTO);
	}

	public MemberDTO getMemberById(int m_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getMemberById", m_id);
	}

	public MemberDTO getMemberWithAccounts(int m_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getMemberWithAccounts", m_id);
	}

	public int insertMemberFile(MemberFileDTO memberFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertMemberFile", memberFileDTO);
	}

	public MemberDTO getMemberWithFiles(String memberId) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getMemberWithFiles", memberId);
	}

	public int updateMember(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateMember", memberDTO);
	}

	public int deleteMember(int m_id) throws Exception {
		return sqlSession.delete(NAMESPACE + "deleteMember", m_id);
	}

	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", memberDTO);
	}
}
