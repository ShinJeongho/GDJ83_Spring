package com.win.app.robot;

import org.springframework.stereotype.Component;

@Component("ra") // 객체생성 ("빈의이름")
public class RightArm implements Arm {

	public void info() {
		System.out.println("오른팔 입니다");
	}

}
