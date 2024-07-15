package com.win.app.boards.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.win.app.members.MemberDTO;
import com.win.app.util.Pager;

@Controller
@RequestMapping("/board/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception {
		List<NoticeDTO> list = noticeService.getList(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		model.addAttribute("boardType", "notice");
		return "board/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model) throws Exception {
		model.addAttribute("mode", "add");
		model.addAttribute("boardType", "notice");
		return "board/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, HttpSession session) throws Exception {
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if (member == null) {
			return "redirect:/members/login";
		}

		noticeDTO.setBoardWriter(member.getM_id());
		int result = noticeService.add(noticeDTO);
		return "redirect:/board/notice/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(int boardNum, Model model) throws Exception {
		noticeService.incrementHit(boardNum);
		NoticeDTO noticeDTO = noticeService.detail(boardNum);
		model.addAttribute("notice", noticeDTO);
		model.addAttribute("mode", "detail");
		model.addAttribute("boardType", "notice");
		return "board/detail";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateForm(int boardNum, Model model) throws Exception {
		NoticeDTO noticeDTO = noticeService.detail(boardNum);
		model.addAttribute("notice", noticeDTO);
		model.addAttribute("mode", "update");
		model.addAttribute("boardType", "notice");
		return "board/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		return "redirect:/board/notice/detail?boardNum=" + noticeDTO.getBoardNum();
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(int boardNum) throws Exception {
		int result = noticeService.delete(boardNum);
		return "redirect:/board/notice/list";
	}
}
