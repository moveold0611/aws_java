package ch22_익명클래스;

@FunctionalInterface
// 메소드를 하나만 달아야한다는 표시 @FunctionalInterface
public interface GrantedAuthorities {
	public String getAuthority();
	
	
}
