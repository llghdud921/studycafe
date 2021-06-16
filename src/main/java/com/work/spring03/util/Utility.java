package com.work.spring03.util;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/** 공통으로 사용하기 위한 유틸 클래스 */
public class Utility {
	
	/**
	 * 웹어플리케이션에서 get 요청데이터에 대한 한글 인코딩 설정 변환 메서드
	 * @param data
	 * @return
	 */
	public static String toKorEncoding(String data) {
		try {
			return new String(data.getBytes("8859_1"), "euc-kr");
		} catch(UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	/**
	 * 기본 4자리 숫자형식의 문자열을 반환하는 메서드
	 * 
	 * @see java.lang.Math#random()
	 * @see java.util.Random#nextInt()
	 * @see java.lang.System.currentTimeMillis()
	 * @see java.lang.StringBuilder
	 * 
	 * @return
	 */
	public static String getSecureCode() {
		return getSecureCode(4);
	}

	/**
	 * 아규먼트로 전달받은 길이의 숫자형식의 문자열을 반환하는 메서드
	 * 
	 * @return
	 */
	public static String getSecureCode(int length) {
		Random random = new Random((long)(System.currentTimeMillis() * Math.random()));
		StringBuilder code = new StringBuilder();
		
		for(int i=0; i < length; i++) {
			code.append(random.nextInt(10));  // 0 ~ 9
		}
		return code.toString();
	}

	/**
	 * 2글짜는 영문, 나머지는 숫자 형식의 문자열 반환
	 * @param length
	 * @return
	 */
	public static String getSecureCodeString(int length) {
		Random random = new Random((long)(System.currentTimeMillis() * Math.random()));
		StringBuilder code = new StringBuilder();
		
		for(int i=0; i < length; i++) {
			if(i < 2) {
				code.append((char)(random.nextInt(26) + 65)) ;  // 영문대문자
			} else {
				code.append(random.nextInt(10));  // 0 ~ 9
			}
		}
		return code.toString();
	}
	
	/**
	 * <pre>
	 * 현재날짜를 년도4자리/월2자리/일2자리 기본형식의 문자열 반환
	 * ## 날짜형식 
	 * -- java.text.SimpleDateFormat 참고
	 * -- 년 : y
	 * -- 월 : M
	 * -- 일 : d
	 * -- 12시간 : h
	 * -- 24시간 : H
	 * -- 분 : m
	 * -- 초 : s
	 * -- 오전오후 : a
	 * -- 요일 : E
	 * </pre>
	 * @see java.util.Date
	 * @see java.text.SimpleDateFormat#format(java.util.Date)
	 * @return 기본형식의 현재날짜 문자열
	 */
	public static String getCurrentDate() {
		return getCurrentDate("yyyy/MM/dd");
	}

	/**
	 * 현재날짜를 전달받은 아규먼트 형식의 문자열 반환
	 * @param pattern
	 * @return 지정형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern) {
		return new SimpleDateFormat(pattern).format(new Date());
	}
	
	/**
	 * 현재날짜를 전달받은 아규먼트 형식의, Locale의 문자열 반환
	 * @param pattern
	 * @param locale
	 * @return
	 */
	public static String getCurrentDate(String pattern, Locale locale) {
		return new SimpleDateFormat(pattern, locale).format(new Date());
	}
	
	/**
	 * 정수형 데이터에 천단위 컴마 형식의 문자열 반환
	 * @param number
	 * @return
	 */
	public static String getNumber(long number) {
		return NumberFormat.getInstance().format(number);
	}
	
	/**
	 * 실수형 데이터에 천단위 컴마 형식의 문자열 반환
	 * @param number
	 * @return
	 */
	public static String getNumber(double number) {
		return NumberFormat.getInstance().format(number);
	}
	
	/**
	 * 정수형 데이터에 천단위 컴마 형식의 기본 통화단위 문자열 반환
	 * @param number
	 * @return
	 */
	public static String getCurrencyNumber(long number) {
		return NumberFormat.getCurrencyInstance().format(number);
	}
	
	/**
	 * 정수형 데이터에 천단위 컴마 형식의 지정한 Locale 통화단위 문자열 반환
	 * @param number
	 * @return
	 */
	public static String getCurrencyNumber(long number, Locale locale) {
		return NumberFormat.getCurrencyInstance(locale).format(number);
	}
	
	/**
	 * 첫2글자를 제외한 문자는 * 기호 대체 반환
	 * @param data
	 * @return
	 */
	public static String getSecureString(String data) {
		StringBuilder info = new StringBuilder(data.substring(0, 2));
		for(int i=2; i < data.length(); i++) {
			info.append("*");
		}
		
		return info.toString();
	}
}



