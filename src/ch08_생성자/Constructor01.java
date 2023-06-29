package ch08_생성자;

public class Constructor01 {

	Constructor01() {
		/* 생성자의 특징
		 * 
		 * 반환 자료형 없음
		 * 클래스명과 동일한 이름 사용
		 * 메소드처럼 오버로딩 가능
		 */	
		System.out.println("생성자 호출");
	}
	
	Constructor01(int i) {
		System.out.println("정수값 생성자 호출");
	}
	
	Constructor01(String s) {
		System.out.println("문자열 생성자 호출");
	}
	
	
}
