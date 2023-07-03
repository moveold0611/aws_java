package ch19_제네릭;

public class ResponseMain {
	
	public static void main(String[] args) {	
		SignupUser signupUser = SignupUser.builder()
				.username("aaa")
				.password("1234")
				.name("김준일")
				.email("aaa@gmail.com")
				.build();
		
		Response<String> response1 = new Response<String>(200, "회원가입 성공!!");
		System.out.println(response1);
		// 제네릭 타입 클래스의 <T>자료형을 String로 사용하겠다.
		// 생성시에 <T>자료형을 String자료형으로 변환
				
		Response<SignupUser> response2 = new Response<SignupUser>(400, signupUser);
		// 제네릭 타입 클래스의 <T>자료형을 SignupUser로 사용하겠다.
		// 생성시에 <T>자료형을 SignupUser자료형으로 변환
		System.out.println(response2);
		
		AccountUser accountUser = AccountUser.builder()
				.username("aaa")
				.password("1234")
				.build();
		
		Response<AccountUser> response3 = new Response<AccountUser> (200, accountUser);
		//WildCard 제네릭  <?>     =>    뭐가 들어올지 모른다
//		response3 = response2;
		//WildCard 때문에 자동으로 자료형이 변환	
		
		UpdataUser updataUser = UpdataUser.builder()
			.phone("1324")
			.address("1")
			.build();
			
		Response<?> response4 = new Response<UpdataUser>(300, updataUser);
	
		printResponse(response3);
		// <? extends AccountUser>를 사용하여서 response3만 사용가능
		// 이렇게 사용할때는 생성시에 <?> 사용 불가
		
		
	}
	
	
//	private static Response<?> printResponse(Response<? extends AccountUser> response) {
//  AccountUser를 상속받은 자료형만 자유롭게 변환
//		System.out.println(response);
//		return response;
		
	private static Response<?> printResponse(Response<? super SignupUser> response) {
//	SignupUser와 그 부모의 자료형을 자유롭게 변환
			System.out.println(response);
			return response;
		}

	
	

}
