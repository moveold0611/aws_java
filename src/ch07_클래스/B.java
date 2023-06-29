package ch07_클래스;

public class B {
	//메소드 (메소드의 이름은 동사형태)
	
	
	//반환x 매개변수x
	void test1() {
		System.out.println("test1 메소드 호출");
	}
	
	//반환(정수) 매개변수x
	int test2() {
		System.out.println("test2 메소드 호출");
		return 100;	
	}
	
	//반환(논리) 매개변수x
	boolean test3() {
		System.out.println("test3 메소드 서비스를 실행합니다.");	
		return test2() == 100; //true;
	}
	
	//반환x 매개변수(문자열, 정수)
	void test4(String name, int age) {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);		
	}
	
	void test4(int age, String name) {
		System.out.println("나의 이름: " + name);
		System.out.println("나의 나이: " + age);		
	}
	//오버로딩 -> 같은 메소드명에 다른 자료형의 매개변수 사용 가능
	
	/* 메소드
	 * 
	 * 1. 재사용
	 * 2. 모듈화
	 * 3. 클린화 (하나의 메소드는 하나의 기능을 담당)
	 */
	
}
