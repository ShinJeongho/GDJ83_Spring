package com.win.app.robot;

//@Component // 객체생성
public class Robot {

	// @Autowired // setRightARm(rightARm)
	// @Qualifier("ra")
	private Arm rightArm; // Autowired는 타입명에서 변수명은 클래스명을 소문자로

	// @Autowired
	// @Qualifier("la") // 서로이름이다를때 씀
	private Arm leftArm;

	public Arm getRightArm() {
		return rightArm;
	}

	public void setRightArm(Arm rightArm) {
		this.rightArm = rightArm;
	}

	public Arm getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(Arm leftArm) {
		this.leftArm = leftArm;
	}

}