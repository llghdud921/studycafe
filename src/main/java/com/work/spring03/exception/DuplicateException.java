package com.work.spring03.exception;

/**
 * 레코드 중복된 경우 예외 클래스
 */
public class DuplicateException extends Exception {
	public DuplicateException() {
		super("해당 레코드가 이미 등록 되어 있습니다.");
	}
	
	public DuplicateException(String key) {
		super(key + " : 해당 레코드가 이미 등록 되어 있습니다.");
	}
}
