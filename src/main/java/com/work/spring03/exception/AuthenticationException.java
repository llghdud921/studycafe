package com.work.spring03.exception;

/**
 * 사용자 인증 예외 클래스
 */
public class AuthenticationException extends Exception {
	public AuthenticationException() {
		super("사용자 인증에 실패했습니다.");
	}
	
	public AuthenticationException(String message) {
		super(message);
	}	
}
