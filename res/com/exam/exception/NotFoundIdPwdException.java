package com.exam.exception;

public class NotFoundIdPwdException extends Exception {

	public NotFoundIdPwdException() {
		super("아이디 혹은 패스워드가 일치하지 않습니다.");
	}
	
}
