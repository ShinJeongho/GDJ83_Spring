package com.win.app.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 객체생성
public class Robot {

	@Autowired // setRightARm(rightARm)
	@Qualifier("ra")
	private Arm rightArm; // Autowired는 타입명에서 변수명은 클래스명을 소문자로

	@Autowired
	@Qualifier("la") // 서로이름이다를때 씀
	private Arm leftArm;

	public Arm getRa() {
		return ra;
	}

	public void setRa(Arm ra) {
		this.ra = ra;
	}

	public Arm getLa() {
		return la;
	}

	public void setLa(Arm la) {
		this.la = la;
	}

}