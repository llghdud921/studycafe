package com.work.spring03.exception;

/**
 * 레코드 없는경우 예외 클래스
 */
public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		super("해당 레코드를 찾을 수 없습니다.");
	}
	
	public RecordNotFoundException(String key) {
		super(key + " : 해당 레코드를 찾을 수 없습니다.");
	}
}
