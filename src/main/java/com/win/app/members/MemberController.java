package com.win.app.members;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String join(@ModelAttribute MemberDTO memberDTO) throws Exception {
		System.out.println("MemberDTO: " + memberDTO); // 디버그 로그 추가
		System.out.println("Member Name: " + memberDTO.getMember_name()); // 추가 로그
		System.out.println("Member Number: " + memberDTO.getMember_number());
		System.out.println("Phone: " + memberDTO.getPhone());
		System.out.println("Email: " + memberDTO.getEmail());
		System.out.println("Member ID: " + memberDTO.getMember_id());
		System.out.println("Member PWD: " + memberDTO.getMember_pwd());
		int result = memberService.join(memberDTO);
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
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		MemberDTO result = memberService.login(memberDTO);
		if (result != null) {
			session.setAttribute("member", result);
		}
		return "redirect:/";
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
			MemberDTO memberDTO = memberService.getMemberWithAccounts(sessionMember.getM_id());
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
	public String update(MemberDTO memberDTO, HttpSession session) throws Exception {
		int result = memberService.updateMember(memberDTO);
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
