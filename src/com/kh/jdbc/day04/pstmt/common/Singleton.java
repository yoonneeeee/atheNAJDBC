package com.kh.jdbc.day04.pstmt.common;

public class Singleton {
	// static이면서 클래스타입인 멤버변수 필요
	private static Singleton instance;
	//  static이면서 public이고 리턴타입이 singleton인 메소드 필요
	// 메소드 안에서는 if문으로 널체크 후 업스면 객체 생성
	// Null이 아니면 그대로 리턴
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
