package ch22_익명클래스;

public class LambdaTest {
	// 람다 = 함수형 프로그래밍
	public static void main(String[] args) {
		// -> 화살표 함수 (인터페이스 안에 하나의 함수만 존재해야 사용 가능)
		GrantedAuthorities authorities = () -> { 
			System.out.println("권한출력");
			return "ROLE_USER";
		};
		
		/* 아래와 동일
		
		 GrantedAuthorities authorities = new GrantedAuthorities() {			
			@Override
			public String getAuthority() {
				System.out.println("권한출력");
				return "ROLE_USER";
			}
		 };
		 				  
		 */
		authorities.getAuthority();
		
		System.out.println(authorities.getAuthority());
		
		//인터페이스 안에 default 접근지정자를 만들면 일반 메소드를 생성가능
		// 람다식은 매개 변수 안에 자료형 생략가능
	}
	
}
