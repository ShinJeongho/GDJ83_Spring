package com.win.app.robot;

import org.springframework.stereotype.Component;

@Component("la")
public class LeftArm implements Arm {

	public void info() {
		System.out.println("왼쪽팔 입니다");
	}
}
