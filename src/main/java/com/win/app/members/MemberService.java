package com.win.app.members;

import java.io.File;
import java.util.Calendar;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private ServletContext servletContext;

	public int join(MemberDTO memberDTO, MultipartFile file) throws Exception {
		// 중복된 데이터 체크
		if (isDuplicate(memberDTO)) {
			throw new DuplicateKeyException("중복된 회원 정보가 존재합니다.");
		}

		// 회원가입 정보 저장 및 m_id 생성
		memberDAO.join(memberDTO); // 여기서 이미 memberDTO에 m_id가 설정됩니다.

		if (file != null && !file.isEmpty()) {
			saveProfileImage(memberDTO.getM_id(), file);
		}

		return memberDTO.getM_id();
	}

	private boolean isDuplicate(MemberDTO memberDTO) throws Exception {
		return memberDAO.isDuplicate(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null && result.getMember_pwd().equals(memberDTO.getMember_pwd())) {
			return result;
		}
		return null;
	}

	public MemberDTO getMemberWithFiles(String memberId) throws Exception {
		return memberDAO.getMemberWithFiles(memberId);
	}

	public MemberDTO getMemberById(int m_id) throws Exception {
		return memberDAO.getMemberById(m_id);
	}

	public MemberDTO getMemberWithAccounts(int m_id) throws Exception {
		return memberDAO.getMemberWithAccounts(m_id);
	}

	public int updateMember(MemberDTO memberDTO, MultipartFile profileImage) throws Exception {
		if (profileImage != null && !profileImage.isEmpty()) {
			saveProfileImage(memberDTO.getM_id(), profileImage);
		}
		return memberDAO.updateMember(memberDTO);
	}

	public int deleteMember(int m_id) throws Exception {
		return memberDAO.deleteMember(m_id);
	}

	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return memberDAO.detail(memberDTO);
	}

	private void saveProfileImage(int m_id, MultipartFile file) throws Exception {
		String path = servletContext.getRealPath("/resources/upload/members");
		File dir = new File(path);

		if (!dir.exists()) {
			dir.mkdirs(); // 디렉토리 생성
		}

		// 파일명 중복 안 되게
		Calendar calendar = Calendar.getInstance();
		long n = calendar.getTimeInMillis();

		String originalFileName = file.getOriginalFilename();
		String newFileName = n + "_" + originalFileName;

		// 하드디스크에 파일 저장
		File newFile = new File(dir, newFileName);
		file.transferTo(newFile); // 파일 저장

		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setM_id(m_id);
		memberFileDTO.setFileName(newFileName);
		memberFileDTO.setOriName(originalFileName);

		memberDAO.insertMemberFile(memberFileDTO);
	}
}
