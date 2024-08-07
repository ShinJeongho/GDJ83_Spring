package com.win.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.app.boards.BoardDTO;
import com.win.app.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;

	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.init();
		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		return noticeDAO.getList(pager);
	}

	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}

	public NoticeDTO detail(int boardNum) throws Exception {
		return noticeDAO.detail(boardNum);
	}

	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}

	public int delete(int boardNum) throws Exception {
		return noticeDAO.delete(boardNum);
	}
}
