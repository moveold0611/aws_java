package ch18_빌더;
// 빌더는 스태틱 안에 스태틱을 호출하여 쌓는 형식
// (스태틱은 생성이 필요하지 않다는 점을 활용)
public class UserTest {
	public static void printUser() {
		System.out.println("사용자 정보 출력");
		(new UserTest()).test();
		new UserTestTest();
	}
	
	public void test() {
		System.out.println("테스트 메소드 호출");
	}
	
	
	
	
	
	public static class UserTestTest {
			public void testTest() {
				System.out.println("테스트테스트 메소드 호출");
			}
		}
	



}
