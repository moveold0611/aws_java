package ch22_익명클래스;

public class AuthorityMain {

	public static void main(String[] args) {
		GrantedAuthorities authorities = new GrantedAuthorities() {			
			@Override
			public String getAuthority() {
				System.out.println("권한출력");
				return "ROLE_USER";
			}
		}; // 생성시 익명 클래스를 임의로 구현하여 상속,추상을 해결
		
		System.out.println(authorities.getAuthority());
		
		A a = new A();
		System.out.println(a.getAuthority());
	}

}

class A implements GrantedAuthorities {
	@Override
	public String getAuthority() {
		System.out.println("두번째 권한출력");
		return "ROLE_Admin";
	}
}