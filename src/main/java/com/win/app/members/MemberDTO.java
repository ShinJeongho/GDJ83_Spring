package com.win.app.members;

import java.util.List;

import com.win.app.accounts.AccountDAO;

public class MemberDTO {
	private Integer m_id;
	private String member_name;
	private String member_number;
	private String phone;
	private String email;
	private String member_id;
	private String member_pwd;
	private List<AccountDAO> dtos;

	public List<AccountDAO> getDtos() {
		return dtos;
	}

	public void setDtos(List<AccountDAO> dtos) {
		this.dtos = dtos;
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_number() {
		return member_number;
	}

	public void setMember_number(String member_number) {
		this.member_number = member_number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
}
