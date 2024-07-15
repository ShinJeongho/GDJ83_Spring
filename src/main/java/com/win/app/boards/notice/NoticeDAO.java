package com.win.app.boards.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.win.app.boards.BoardDAO;
import com.win.app.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO<NoticeDTO> {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.win.app.boards.notice.NoticeDAO.";

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	@Override
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	@Override
	public int add(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", noticeDTO);
	}

	@Override
	public NoticeDTO detail(int boardNum) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", boardNum);
	}

	@Override
	public int update(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", noticeDTO);
	}

	@Override
	public int delete(int boardNum) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", boardNum);
	}

	@Override
	public int incrementHit(int boardNum) throws Exception {
		return sqlSession.update(NAMESPACE + "incrementHit", boardNum);
	}
}
