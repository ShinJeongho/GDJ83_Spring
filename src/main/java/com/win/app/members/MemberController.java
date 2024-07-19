package com.win.app.members;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/members/*")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() throws Exception {
		return "members/join"; // view 파일 경로에 맞게 수정
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, MultipartFile file, HttpSession session) throws Exception {
		int result = memberService.join(memberDTO, file);
		return "redirect:/";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model, @CookieValue(name = "remember", required = false, defaultValue = "") String value)
			throws Exception {
		model.addAttribute("id", value);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO, String remember, HttpServletResponse response, HttpSession session)
			throws Exception {
		if (remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getMember_id());
			cookie.setMaxAge(60 * 60 * 24 * 7); // 1주일 동안 유지
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		MemberDTO result = memberService.login(memberDTO);
		if (result != null) {
			session.setAttribute("member", result);
			return "redirect:/"; // 로그인 성공 시 메인페이지로 리다이렉트
		}
		return "redirect:/members/login?error=1"; // 로그인 실패 시 다시 로그인 페이지로 리다이렉트
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate(); // 세션 무효화
		return "redirect:/";
	}

	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public String mypage(HttpSession session, Model model) throws Exception {
		MemberDTO sessionMember = (MemberDTO) session.getAttribute("member");
		if (sessionMember != null) {
			MemberDTO memberDTO = memberService.getMemberWithFiles(sessionMember.getMember_id());
			model.addAttribute("member", memberDTO);
			return "members/mypage"; // mypage.jsp로 이동
		} else {
			return "redirect:/members/login"; // 로그인 페이지로 리다이렉트
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) throws Exception {
		MemberDTO sessionMember = (MemberDTO) session.getAttribute("member");
		if (sessionMember != null) {
			MemberDTO memberDTO = memberService.getMemberById(sessionMember.getM_id());
			model.addAttribute("member", memberDTO);
			return "members/update";
		} else {
			return "redirect:/members/login";
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO, MultipartFile profileImage, HttpSession session) throws Exception {
		int result = memberService.updateMember(memberDTO, profileImage);
		if (result > 0) {
			session.setAttribute("member", memberDTO);
		}
		return "redirect:/members/mypage";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpSession session) throws Exception {
		MemberDTO sessionMember = (MemberDTO) session.getAttribute("member");
		if (sessionMember != null) {
			int result = memberService.deleteMember(sessionMember.getM_id());
			if (result > 0) {
				session.invalidate();
				return "redirect:/";
			}
		}
		return "redirect:/members/mypage";
	}
}
